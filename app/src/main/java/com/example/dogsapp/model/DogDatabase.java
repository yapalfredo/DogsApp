package com.example.dogsapp.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {DogBreed.class}, version = 1)
//Database class is always abstract for @Database annotation
//It's a rule; it's just how the system works.
public abstract class DogDatabase extends RoomDatabase {

    //Singleton Design Pattern
    private static DogDatabase instance;

    public static DogDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    DogDatabase.class,
                    "dogDatabase")
                    .build();
        }
        return instance;
    }

    public abstract DogDao dogDao();
}
