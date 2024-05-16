package com.example.parkingapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface AddCarContactsDAO {
   @Insert
    void  insert(AddCarContacts addCarContacts);
   @Delete
   void delete(AddCarContacts addCarContacts);
  @Query(" SELECT * FROM Car")
   LiveData<List<AddCarContacts>> getAllContacts();
}
