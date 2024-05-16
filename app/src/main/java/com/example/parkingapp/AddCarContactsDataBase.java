package com.example.parkingapp;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {AddCarContacts.class}, version = 1, exportSchema = false)
public abstract class AddCarContactsDataBase  extends RoomDatabase {

    public  abstract  AddCarContactsDAO getContactsDAO();

    private static  AddCarContactsDataBase dbinstance;
     public  static synchronized  AddCarContactsDataBase getInstance(Context context ){
         if(dbinstance == null){
             dbinstance = Room.databaseBuilder(
                     context.getApplicationContext(),
                     AddCarContactsDataBase.class,
                     "add_car_contacts_db"

             ).fallbackToDestructiveMigration().build();
         }
         return dbinstance;
     };
}
