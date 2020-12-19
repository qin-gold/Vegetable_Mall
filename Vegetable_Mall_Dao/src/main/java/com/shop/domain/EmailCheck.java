package com.shop.domain;

/**
 * @author 84735
 */
public class EmailCheck {
    private String email;
    private int email_checkCode;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmail_checkCode() {
        return email_checkCode;
    }

    public void setEmail_checkCode(int email_checkCode) {
        this.email_checkCode = email_checkCode;
    }

    @Override
    public String toString() {
        return "EmailCheck{" +
                "email='" + email + '\'' +
                ", email_checkCode=" + email_checkCode +
                '}';
    }
}
