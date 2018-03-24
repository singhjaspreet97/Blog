package com.example.jaspreet.blog;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jaspreet on 20/3/18.
 */

public class MessageResponse {
    @SerializedName("message")
    String message;

    public String getMessage() {
        return message;
    }
}
