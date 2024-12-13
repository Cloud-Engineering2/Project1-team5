package com.team5.fandom.entity.value;

public enum Tag {
    Tag1("Tag1"),
    Tag2("Tag2"),
    Tag3("Tag3");

    private final String hashTag;

    Tag(String hashTag) {
        this.hashTag = hashTag;
    }

    public String getHashTag() {
        return hashTag;
    }
}