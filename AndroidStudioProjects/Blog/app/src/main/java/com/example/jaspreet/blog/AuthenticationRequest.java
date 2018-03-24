package com.example.jaspreet.blog;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jaspreet on 20/3/18.
 */

public class AuthenticationRequest {
    @SerializedName("username")
    String username;

    @SerializedName("password")
    String password;

    public AuthenticationRequest(String username,String password) {
        this.username = username;
        this.password = password;
    }
}
