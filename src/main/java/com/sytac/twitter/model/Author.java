package com.sytac.twitter.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
public class Author {

    @NotNull
    private long userId;
    @NotNull
    private Date creationDate;
    @NotNull
    private String name;
    @NotNull
    private String screenName;


}
