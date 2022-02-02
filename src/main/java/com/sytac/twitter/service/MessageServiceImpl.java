package com.sytac.twitter.service;

import com.sytac.twitter.exception.ListenerException;
import com.sytac.twitter.model.Author;
import com.sytac.twitter.model.Tweet;
import com.sytac.twitter.oauth.TwitterAuthenticator;
import com.sytac.twitter.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
import twitter4j.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class MessageServiceImpl implements MessageService {
    private static final Logger LOG = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Autowired
    private TwitterAuthenticator twitterAuthenticator;

    @Autowired
    private MessageRepository messageRepository;

    private TwitterStream twitterStream;
    private CountDownLatch latch;
    private StatusListener listener;

    @Value("${message.filter}")
    private String filterMessage;

    @Value("${message.maxcount}")
    private int maxMessageCount;

    @Value("${message.maxduration}")
    private int maxDuration;


    @Override
    public void streamTweets() throws TwitterException, InterruptedException {

        LOG.info("Streaming started...");
        AtomicInteger counter = new AtomicInteger(0);
        initObjects(counter);

        generateFilter();

        StopWatch sw = new StopWatch();
        sw.start();
        boolean stopped = latch.await(maxDuration, TimeUnit.SECONDS);
        sw.stop();

        twitterStream.removeListener(listener);
        twitterStream.shutdown();

        LOG.info("Stream shutdown:{} elapsed time: {}, tweet count: {}", stopped, sw.getTotalTimeMillis(),
                counter.get());
    }

    @Override
    public boolean writeToFile() throws IOException {
        return messageRepository.writeToFile(messageRepository.getSortedTweetList());

    }

    private void generateFilter() {
        FilterQuery tweetFilterQuery = new FilterQuery();
        tweetFilterQuery.track(filterMessage);
        twitterStream.filter(tweetFilterQuery);
    }

    private void initObjects(AtomicInteger counter) throws TwitterException {
        latch = new CountDownLatch(maxMessageCount);
        listener = getMessageListener(latch, counter);
        twitterStream = twitterAuthenticator.createTwitterStream(listener);
    }

    public StatusListener getMessageListener(CountDownLatch latch, AtomicInteger counter) {
        if (listener != null)
            return listener;
        return new StatusListener() {
            @Override
            public void onStatus(Status status) {
                //getting message here
                latch.countDown();
                if (counter.incrementAndGet() <= maxMessageCount)
                    addTweetToRepository(status);

                LOG.info(counter.get() + ". Tweet : " + status.getText());
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
                LOG.info("onDeletionNotice");
            }

            @Override
            public void onTrackLimitationNotice(int i) {
                LOG.info("onTrackLimitationNotice:" + i);
            }

            @Override
            public void onScrubGeo(long l, long l1) {
                LOG.info("onScrubGeo:" + l + " - " + l1);
            }

            @Override
            public void onStallWarning(StallWarning stallWarning) {
                LOG.info("onStallWarning");
            }

            @Override
            public void onException(Exception e) {
                LOG.info("onException:" + e.getMessage());
                throw new ListenerException(e.getMessage());

            }
        };
    }

    private void addTweetToRepository(Status status) {

        Author author = Author.builder()
                .creationDate(status.getUser().getCreatedAt())
                .name(status.getUser().getName())
                .screenName(status.getUser().getScreenName())
                .userId(status.getUser().getId())
                .build();
        Tweet tweet = Tweet.builder()
                .author(author)
                .creationDate(status.getCreatedAt())
                .messageId(status.getId())
                .messageText(status.getText())
                .build();
        messageRepository.add(tweet);
    }
}
