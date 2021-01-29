package com.example.connectapi;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("Godville")
    Observable<ApiKeysList> apiKeys();
}
