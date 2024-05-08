package com.example.parkingapp;

public class leftListLotItem {
private  String ParkingNum ;
private  int ImageParkingLot;

    public leftListLotItem(String parkingNum, int imageParkingLot) {
        ParkingNum = parkingNum;
        ImageParkingLot = imageParkingLot;
    }

    public String getParkingNum() {
        return ParkingNum;
    }

    public void setParkingNum(String parkingNum) {
        ParkingNum = parkingNum;
    }

    public int getImageParkingLot() {
        return ImageParkingLot;
    }

    public void setImageParkingLot(int imageParkingLot) {
        ImageParkingLot = imageParkingLot;
    }
}
