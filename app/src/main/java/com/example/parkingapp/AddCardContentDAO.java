package com.example.parkingapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AddCardContentDAO {
    @Insert
    void  insert(AddCardContent addCardContent);
    @Delete
    void delete(AddCardContent addCardContent);

    @Query("SELECT * FROM Card")
    LiveData<List<AddCardContent>> getAllContent();
}
