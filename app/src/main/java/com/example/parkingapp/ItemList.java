package com.example.parkingapp;

public class ItemList {
    String carModel;
    int spaceCarNum;

    public ItemList(String carModel, int spaceCarNum) {
        this.carModel = carModel;
        this.spaceCarNum = spaceCarNum;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getSpaceCarNum() {
        return spaceCarNum;
    }

    public void setSpaceCarNum(int spaceCarNum) {
        this.spaceCarNum = spaceCarNum;
    }
}
