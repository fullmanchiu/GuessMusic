package com.guessmusic.model;

/**
 * Created by lance on 17-6-1.
 */

public class UserInfo {
    private String username;
    private String password;
    private int level;
    private int gold;

    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public UserInfo(String username, String password, int level, int gold) {
        this.username = username;
        this.password = password;
        this.level = level;
        this.gold = gold;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

}
