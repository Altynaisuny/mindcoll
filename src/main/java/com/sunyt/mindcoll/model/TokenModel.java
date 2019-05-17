package com.sunyt.mindcoll.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class TokenModel {
    /**
     * 绑定用户ID
     */
    @Id
    private long id;
    /**
     * 具体token
     */
    private String token;
    /**
     * token更新时间
     */
    private Date updateTime;
    /**
     * 到期时间
     */
    private Date expireTime;

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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public String toString() {
        return "TokenModel{" +
                "id=" + id +
                ", token='" + token + '\'' +
                '}';
    }
}
