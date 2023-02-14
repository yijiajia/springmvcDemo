package com.example.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {

    private String userName;

    private String pwd;

    private int age;

    @Override
    public String toString() {
        int[] nums = {1};
        return "User{" +
                "userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                '}';



    }
}
