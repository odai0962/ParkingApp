package com.example.parkingapp;

public class RightListLotItem {
   private String ParkingNum;
    private  int imageParkingLot;

    public RightListLotItem(String parkingNum, int imageParkingLot) {
        ParkingNum = parkingNum;
        this.imageParkingLot = imageParkingLot;
    }

    public String getParkingNum() {
        return ParkingNum;
    }

    public void setParkingNum(String parkingNum) {
        ParkingNum = parkingNum;
    }

    public int getImageParkingLot() {
        return imageParkingLot;
    }

    public void setImageParkingLot(int imageParkingLot) {
        this.imageParkingLot = imageParkingLot;
    }
}
