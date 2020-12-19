package com.shop.domain;

import java.io.Serializable;

/**
 *
 * @author qsj Cotter
 * @date 2020/11/6
 */
public class Admin implements Serializable {
    private String a_username;
    private String a_password;

    public String getA_username() {
        return a_username;
    }

    public void setA_username(String a_username) {
        this.a_username = a_username;
    }

    public String getA_password() {
        return a_password;
    }

    public void setA_password(String a_password) {
        this.a_password = a_password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "a_username='" + a_username + '\'' +
                ", a_password='" + a_password + '\'' +
                '}';
    }
}
