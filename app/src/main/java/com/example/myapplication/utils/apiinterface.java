package com.example.myapplication.utils;

import com.example.myapplication.models.TopMovies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface apiinterface {
    @GET("https://run.mocky.io/v3/924ea708-3be3-455a-b16a-83de537a543a")
    Call<TopMovies> getTopMovies(@Query("page") int currentPage);


}
