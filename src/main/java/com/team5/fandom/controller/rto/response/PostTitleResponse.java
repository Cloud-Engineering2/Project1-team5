package com.team5.fandom.controller.rto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostTitleResponse {
    private Integer id;
    private String title;
    private String content;
    private String name;
    private String tag;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}


