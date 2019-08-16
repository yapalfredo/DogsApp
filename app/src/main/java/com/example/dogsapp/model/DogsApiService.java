package com.example.dogsapp.model;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DogsApiService {

    private static final String BASE_URL = "https://raw.githubusercontent.com";

    private DogsApi api;

    public DogsApiService(){
        // We're giving retrofit the informations that it needs
        // to call the api and know how to return the information
        // from the api to this application
        api = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Converts JSON to POJO
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //Converts List<DogBreed> in to Single observable
                .build()
                .create(DogsApi.class);
    }

    public Single<List<DogBreed>> getDogs()
    {
        return api.getDogs();
    }
}
