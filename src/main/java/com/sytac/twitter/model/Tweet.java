package com.sytac.twitter.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
@Builder
public class Tweet {

    @NotNull
    private long messageId;
    @NotNull
    private Date creationDate;
    @NotNull
    private String messageText;
    @NotNull
    private Author author;


}
