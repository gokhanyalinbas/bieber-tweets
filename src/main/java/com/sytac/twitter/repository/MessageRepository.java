package com.sytac.twitter.repository;

import com.sytac.twitter.model.Author;
import com.sytac.twitter.model.Tweet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface MessageRepository {

    boolean add(Tweet tweet);

    List<Tweet> getSortedTweetList();

    Map<Author, List<Tweet>> getRepository();

    boolean writeToFile(List<Tweet> messageList) throws IOException;
}
