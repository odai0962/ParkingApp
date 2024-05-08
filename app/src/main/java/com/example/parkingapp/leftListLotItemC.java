package com.example.parkingapp;

public class leftListLotItemC {
    private  String ParkingNumC ;
    private  int ImageParkingLotC;

    public leftListLotItemC(String parkingNumC, int imageParkingLotC) {
        ParkingNumC = parkingNumC;
        ImageParkingLotC = imageParkingLotC;
    }

    public String getParkingNumC() {
        return ParkingNumC;
    }

    public void setParkingNumC(String parkingNumC) {
        ParkingNumC = parkingNumC;
    }

    public int getImageParkingLotC() {
        return ImageParkingLotC;
    }

    public void setImageParkingLotC(int imageParkingLotC) {
        ImageParkingLotC = imageParkingLotC;
    }
}
