package com.sytac.twitter;

import com.sytac.twitter.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;

@SpringBootApplication
public class TwitterappApplication implements CommandLineRunner {


    private static final Logger LOG = LoggerFactory.getLogger(TwitterappApplication.class);

    @Autowired
    private MessageService messageService;
    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(TwitterappApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Application started...");
        messageService.streamTweets();
        messageService.writeToFile();

        if (!environment.acceptsProfiles(Profiles.of("test"))) {
            System.exit(0);
            LOG.info("Application exit with 0.");
        }

    }
}
