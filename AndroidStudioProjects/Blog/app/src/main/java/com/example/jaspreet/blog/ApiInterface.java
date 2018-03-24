package com.example.jaspreet.blog;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by jaspreet on 20/3/18.
 */

public interface ApiInterface {

    @POST(NetworkURL.LOGIN)
    Call<MessageResponse> login(@Body AuthenticationRequest body);

    @POST(NetworkURL.REGISTRATION)
    Call<MessageResponse> registration(@Body AuthenticationRequest body);

    @GET(NetworkURL.GET_ARTICLES)
    Call<List<Aricle>> getArticles();
}
