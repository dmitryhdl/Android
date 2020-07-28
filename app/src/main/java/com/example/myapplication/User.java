package com.example.myapplication;

import java.io.Serializable;

public class User implements Serializable {
    private String mLogin;
    private String mPassword;


// Конструкторы
    public User(String mLogin, String mPassword) {
        this.mLogin = mLogin;
        this.mPassword = mPassword;
    }



    // Гетеры и сетеры
    public String getmLogin() {
        return mLogin;
    }

    public void setmLogin(String mLogin) {
        this.mLogin = mLogin;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }



}
