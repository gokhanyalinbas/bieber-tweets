package com.sytac.twitter.oauth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TwitterAuthenticatorTest {
    private static final String key = "RLSrphihyR4G2UxvA0XBkLAdl";
    private static final String secret = "FTz2KcP1y3pcLw0XXMX5Jy3GTobqUweITIFy4QefullmpPnKm4";
    private static final RequestToken requestToken = new RequestToken(key, secret);
    private static final AccessToken ACCESS_TOKEN = new AccessToken(key, secret);
    @InjectMocks
    private TwitterAuthenticator twitterAuthenticator;
    @Mock
    private Twitter twitter;

    @BeforeEach
    void setUp() throws TwitterException {
        MockitoAnnotations.openMocks(this);

        when(twitter.getOAuthRequestToken()).thenReturn(requestToken);

        InputStream in = new ByteArrayInputStream("1122334".getBytes());
        System.setIn(in);

        when(twitter.getOAuthAccessToken(requestToken, "1122334"))
                .thenReturn(ACCESS_TOKEN);
        ReflectionTestUtils.setField(twitterAuthenticator, "consumerKey", key);
        ReflectionTestUtils.setField(twitterAuthenticator, "consumerSecret", secret);

    }

    @Test
    @DisplayName("Create twitter object succesfully")
    void createTwitterStream() throws TwitterException {
        // Test succesfully without any exception
        twitterAuthenticator.createTwitterStream(new StatusListener() {
            @Override
            public void onStatus(Status status) {

            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

            }

            @Override
            public void onTrackLimitationNotice(int i) {

            }

            @Override
            public void onScrubGeo(long l, long l1) {

            }

            @Override
            public void onStallWarning(StallWarning stallWarning) {

            }

            @Override
            public void onException(Exception e) {

            }
        });
        verify(twitter, times(1)).setOAuthAccessToken(any(AccessToken.class));

    }


}