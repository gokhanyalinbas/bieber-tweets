package com.sytac.twitter.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuthorTest {

    private Author author;
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
    }

    @Test
    @DisplayName("Author method's test")
    void authorTest() {
        assertEquals("screenname", author.getScreenName());
        assertEquals("name", author.getName());
        assertEquals(date, author.getCreationDate());
        assertEquals(123456l, author.getUserId());
    }
}