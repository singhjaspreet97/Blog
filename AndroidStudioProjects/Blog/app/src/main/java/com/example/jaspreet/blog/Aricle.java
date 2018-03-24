package com.example.jaspreet.blog;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jaspreet on 23-03-2018.
 */

public class Aricle {

    @SerializedName("id")
    Integer id;

    @SerializedName("heading")
    String heading;

    @SerializedName("title")
    String title;

    @SerializedName("date")
    String date;

    @SerializedName("content")
    String content;

    public Integer getId() {
        return id;
    }

    public String getHeading() {
        return heading;
    }
    public String getTitle() { return  title; }
    public String getDate() { return date; }
    public String getContent() { return content; }
}

