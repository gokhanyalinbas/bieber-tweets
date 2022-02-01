package com.sytac.twitter.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TweetTest {
    private Author author;
    private Tweet tweet;
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
                .userId(123456l)
                .build();

        tweet = Tweet.builder()
                .messageText("message")
                .creationDate(date)
                .author(author)
                .messageId(123456l)
                .build();
    }

    @Test
    @DisplayName("Tweet method's test")
    void tweetTest() {
        assertEquals("message", tweet.getMessageText());
        assertEquals(date, tweet.getCreationDate());
        assertEquals(author.getUserId(), tweet.getAuthor().getUserId());
        assertEquals(123456l, tweet.getMessageId());

    }
}