package com.sytac.twitter;

import com.sytac.twitter.repository.MessageRepositoryImpl;
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

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
class TwitterappApplicationTest {

    @Mock
    private MessageServiceImpl messageService;
    @Mock
    private MessageRepositoryImpl messageRepository;
    @InjectMocks
    private TwitterappApplication twitterappApplication;
    @Mock
    private Environment environment;

    @BeforeEach
    void setUp() throws TwitterException, InterruptedException {
        MockitoAnnotations.openMocks(this);
        doNothing().when(messageService).streamTweets();
        when(messageRepository.getSortedTweetList()).thenReturn(new ArrayList<>());
        when(messageRepository.writeToFile(any(ArrayList.class))).thenReturn(true);

    }

    @Test
    void run() throws Exception {
        //ReflectionTestUtils.setField(twitterappApplication, "isTestEnvironment", true);
        when(environment.acceptsProfiles(any(Profiles.class))).thenReturn(true);
        twitterappApplication.run();
        verify(messageRepository, times(1)).getSortedTweetList();
        verify(messageRepository, times(1)).writeToFile(any(ArrayList.class));
    }
}