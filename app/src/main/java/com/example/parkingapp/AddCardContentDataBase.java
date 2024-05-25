package com.example.parkingapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {AddCardContent.class}, version = 3 ,exportSchema = false)
public abstract class AddCardContentDataBase extends RoomDatabase {
    public abstract AddCardContentDAO getContentDAO();

    private static AddCardContentDataBase dbInstance;

    public static synchronized AddCardContentDataBase getDbInstance(Context context) {
        if (dbInstance == null) {
            dbInstance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AddCardContentDataBase.class,
                    "content_db"
            ).fallbackToDestructiveMigration().build();
        }
        return dbInstance;
    }
}
