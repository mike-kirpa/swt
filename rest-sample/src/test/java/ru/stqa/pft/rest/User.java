package ru.stqa.pft.rest;

import java.io.Serializable;

public class User implements Serializable {

    private String userId;


    public String getUserId() {
        return userId;
    }

    public void setUserid(String userId) {
        this.userId = userId;
    }
}
