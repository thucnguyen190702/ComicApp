package com.example.comicapp.Comic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("get-all")
    Call<List<Comic>> getComics();

}
