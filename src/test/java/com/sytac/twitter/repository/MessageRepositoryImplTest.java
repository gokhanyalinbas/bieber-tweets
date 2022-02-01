package com.sytac.twitter.repository;

import com.sytac.twitter.model.Author;
import com.sytac.twitter.model.Tweet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageRepositoryImplTest {


    private MessageRepository messageRepository = new MessageRepositoryImpl();
    private Author author;
    private Tweet tweet;
    private Author author1;
    private Tweet tweet1;
    private Tweet tweet2;
    private Date date;

    @BeforeEach
    void setUp() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
        String dateInString = "01-01-2022";
        date = formatter.parse(dateInString);
        author = Author.builder()
                .screenName("screenname")
                .name("name")
                .creationDate(date)
                .userId(123456)
                .build();

        dateInString = "01-02-2022";
        date = formatter.parse(dateInString);

        author1 = Author.builder()
                .screenName("screenname")
                .name("name")
                .creationDate(date)
                .userId(1234567)
                .build();

        tweet = Tweet.builder()
                .messageText("message")
                .creationDate(date)
                .author(author)
                .messageId(123456)
                .build();

        tweet1 = Tweet.builder()
                .messageText("message")
                .creationDate(date)
                .author(author1)
                .messageId(1234567)
                .build();

        dateInString = "01-01-2021";
        date = formatter.parse(dateInString);

        tweet2 = Tweet.builder()
                .messageText("message")
                .creationDate(date)
                .author(author1)
                .messageId(12345678)
                .build();
    }

    @Test
    @DisplayName("Add new tweet to repository")
    void add() {
        messageRepository.add(tweet);
        assertEquals(1, messageRepository.getRepository().size());
    }

    @Test
    @DisplayName("Get sorted list")
    void getSortedTweetList() {
        messageRepository.add(tweet);
        messageRepository.add(tweet1);
        messageRepository.add(tweet2);
        assertEquals(123456, messageRepository.getSortedTweetList().get(0).getAuthor().getUserId());
        assertEquals(12345678, messageRepository.getSortedTweetList().get(1).getMessageId());
        //grouping by author
        assertEquals(2, messageRepository.getRepository().get(author1).size());
    }

    @Test
    @DisplayName("Write to file")
    void writeToFile() throws IOException {
        messageRepository.add(tweet);
        messageRepository.add(tweet1);
        assertEquals(true, messageRepository.writeToFile(messageRepository.getSortedTweetList()));

        //Change directory for IOException
        setDirectoryName("./out", "./out1");

        assertEquals(false, messageRepository.writeToFile(messageRepository.getSortedTweetList()));

        setDirectoryName("./out1", "./out");
    }

    private void setDirectoryName(String current, String next) {
        File file = new File(current);
        file.renameTo(new File(next));
    }


}