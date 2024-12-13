package com.team5.fandom.entity.value;

public enum Level {
	Bronze("Bronze"),
	Silver("Silver"),
	Gold("Gold"),
	Platinum("Platinum"),
	Diamond("Diamond");

    private final String levelName;

    Level(String levelName) {
        this.levelName = levelName;
    }

    public String getLevelName() {
        return levelName;
    }
}