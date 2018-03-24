package com.example.jaspreet.blog;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jaspreet on 20/3/18.
 */

public class ErrorResponse {
    @SerializedName("error")
    String error;

    public String getError() {
        return error;
    }
}
