package com.example.parkingapp;



public class RightListLotItemC {
    private String ParkingNumC;
    private  int imageParkingLotC;

    public RightListLotItemC(String parkingNumC, int imageParkingLotC) {
        ParkingNumC = parkingNumC;
        this.imageParkingLotC = imageParkingLotC;
    }

    public String getParkingNumC() {
        return ParkingNumC;
    }

    public void setParkingNumC(String parkingNumC) {
        ParkingNumC = parkingNumC;
    }

    public int getImageParkingLotC() {
        return imageParkingLotC;
    }

    public void setImageParkingLotC(int imageParkingLotC) {
        this.imageParkingLotC = imageParkingLotC;
    }
}
