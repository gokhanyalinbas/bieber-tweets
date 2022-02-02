package com.sytac.twitter.service;

import twitter4j.TwitterException;

import java.io.IOException;

public interface MessageService {

    void streamTweets() throws TwitterException, InterruptedException;

    boolean writeToFile() throws IOException;
}
