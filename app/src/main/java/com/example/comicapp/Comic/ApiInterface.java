package com.example.comicapp.Comic;

import com.example.comicapp.Log;
import com.example.comicapp.User.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("get-all")
    Call<List<Comic>> getComics();
    @POST("reg")
    Call<Users> postReg(@Body Users users);
    @POST("login")
    Call<Users> postLogin(@Body Users users);
}
