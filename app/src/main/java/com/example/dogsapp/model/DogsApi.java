package com.example.dogsapp.model;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface DogsApi {

    //Tells Retrofit to get data from the endpoint and then convert to a List of DogBreed
    @GET("/DevTides/DogsApi/master/dogs.json")
    Single<List<DogBreed>> getDogs();   //An observable that returns a single value and then closes




    // For Dynamic URL
    //    @GET()
    //    Single<List<DogBreed>> getDogs(@Url String url);
}
