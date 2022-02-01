package com.sytac.twitter.repository;

import com.google.gson.GsonBuilder;
import com.sytac.twitter.constant.ApplicationConstant;
import com.sytac.twitter.model.Author;
import com.sytac.twitter.model.Tweet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public class MessageRepositoryImpl implements MessageRepository {

    private static final Logger LOG = LoggerFactory.getLogger(MessageRepositoryImpl.class);
    private final Map<Author, List<Tweet>> repository = new ConcurrentHashMap<>();


    @Override
    public boolean add(Tweet tweet) {
        return repository.computeIfAbsent(tweet.getAuthor(), key -> new ArrayList<>()).add(tweet);
    }

    @Override
    public Map<Author, List<Tweet>> getRepository() {
        return repository;
    }

    @Override
    public List<Tweet> getSortedTweetList() {
        List<Tweet> messageList = new ArrayList<>();

        LOG.info("Sort by author creation date !");
        List<Author> sortByAuthorList = new ArrayList<>(repository.keySet());
        sortByAuthorList.sort((p1, p2) -> p1.getCreationDate().compareTo(p2.getCreationDate()));
        LOG.info("Sort by message creation date !");
        for (Author author : sortByAuthorList) {
            messageList.addAll(repository.get(author).stream().sorted((o1, o2) -> o1.getCreationDate().compareTo(o2.getCreationDate()))
                    .collect(Collectors.toList()));
        }

        return messageList;
    }

    @Override
    public boolean writeToFile(List<Tweet> messageList) {
        String output = new GsonBuilder().setPrettyPrinting().create().toJson(messageList);
        try {
            if (Files.exists(Paths.get(ApplicationConstant.OUT_FILE_PATH)))
                Files.delete(Paths.get(ApplicationConstant.OUT_FILE_PATH));
            Files.write(Paths.get(ApplicationConstant.OUT_FILE_PATH), output.getBytes(), StandardOpenOption.CREATE);
            LOG.info(ApplicationConstant.OUT_FILE_PATH + " file have written ! ");
        } catch (IOException e) {
            LOG.info("Write to file error ! " + e.getMessage());
            return false;
        }
        return true;
    }
}
