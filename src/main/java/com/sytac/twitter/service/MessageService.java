package com.sytac.twitter.service;

import twitter4j.TwitterException;

public interface MessageService {

    void streamTweets() throws TwitterException, InterruptedException;
}
