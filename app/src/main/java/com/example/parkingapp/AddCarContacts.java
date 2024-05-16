package com.example.parkingapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Car")
public class AddCarContacts {
    @ColumnInfo(name = "car_id")
    @PrimaryKey(autoGenerate = true)
    private  int ID;
    @ColumnInfo(name = "car_type")
    private  String Type;
    @ColumnInfo(name = "car_color")
    private  String Color;

    public AddCarContacts(int ID, String type, String color) {
        this.ID = ID;
        Type = type;
        Color = color;
    }

    public AddCarContacts() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }
}
