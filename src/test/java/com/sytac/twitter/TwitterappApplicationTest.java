package com.sytac.twitter;

import com.sytac.twitter.service.MessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.test.context.ActiveProfiles;
import twitter4j.TwitterException;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class TwitterappApplicationTest {

    @Mock
    private MessageServiceImpl messageService;
    @InjectMocks
    private TwitterappApplication twitterappApplication;
    @Mock
    private Environment environment;

    @BeforeEach
    void setUp() throws TwitterException, InterruptedException, IOException {
        MockitoAnnotations.openMocks(this);
        doNothing().when(messageService).streamTweets();
        when(messageService.writeToFile()).thenReturn(true);
        when(environment.acceptsProfiles(any(Profiles.class))).thenReturn(true);


    }

    @Test
    void run() throws Exception {
        twitterappApplication.run();
    }
}