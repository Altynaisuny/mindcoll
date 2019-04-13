package com.sunyt.mindcoll.model;

import org.junit.Test;

public class User {
    private String username;
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static class UserBuilder{
        private String username;
        private int age;

        public UserBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public User build(){
            return new User(username, age);
        }
    }
    @Test
    public void test(){
        User user = new User.UserBuilder().setAge(15).setUsername("name").build();
        System.out.println(user.username);
    }


}
