package com.sunyt.mindcoll.model;

public class TokenModel {
    private long id;
    private String token;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "TokenModel{" +
                "id=" + id +
                ", token='" + token + '\'' +
                '}';
    }
}
