/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * ________  __    __  ________    ____       ______   *
 * /_/_/_/_/ /_/   /_/ /_/_/_/_/  _/_/_/_   __/_/_/_/   *
 * /_/_____  /_/___/_/    /_/    /_/___/_/  /_/          *
 * /_/_/_/_/   /_/_/_/    /_/    /_/_/_/_/  /_/           *
 * ______/_/       /_/    /_/    /_/   /_/  /_/____        *
 * /_/_/_/_/       /_/    /_/    /_/   /_/    /_/_/_/ . io  *
 * *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 */
package com.sytac.twitter.oauth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Scanner;

@Component
public class TwitterAuthenticator {

    private static final Logger logger = LoggerFactory.getLogger(TwitterAuthenticator.class);
    @Value("${application.consumerkey}")
    private String consumerKey;
    @Value("${application.consumersecret}")
    private String consumerSecret;
    private Twitter twitter;
    private AccessToken accessToken;


    private void createTwitter() throws TwitterException {
        getTwitter();
        twitter.setOAuthConsumer(consumerKey, consumerSecret);
        RequestToken requestToken = twitter.getOAuthRequestToken();
        String pin = readPIN(requestToken);

        accessToken = twitter.getOAuthAccessToken(requestToken, pin);
        twitter.setOAuthAccessToken(accessToken);

        logger.info("Received Token key: {} secret: {}", accessToken.getToken(), accessToken.getTokenSecret());

    }

    private void getTwitter() {
        if (twitter == null)
            twitter = TwitterFactory.getSingleton();
    }

    private String readPIN(RequestToken requestToken) {
        String pin = null;
        Scanner scanner = new Scanner(System.in);
        try {
            logger.info("\nGo to the following link in your browser:\n{}\n", requestToken.getAuthorizationURL());
            logger.info("\nPlease enter the retrieved PIN:");
            if (scanner.hasNextLine())
                pin = scanner.next();
        } finally {
            scanner.close();
        }
        return pin;
    }

    public TwitterStream createTwitterStream(StatusListener statusListener) throws TwitterException {

        createTwitter();

        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setOAuthConsumerKey(consumerKey).setOAuthConsumerSecret(consumerSecret)
                .setOAuthAccessToken(accessToken.getToken()).setOAuthAccessTokenSecret(accessToken.getTokenSecret());

        TwitterStream twitterStream = new TwitterStreamFactory(configurationBuilder.build()).getInstance();
        twitterStream.addListener(statusListener);

        return twitterStream;
    }


}
