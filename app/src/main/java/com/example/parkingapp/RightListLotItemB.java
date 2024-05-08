package com.example.parkingapp;



public class RightListLotItemB {
    private String ParkingNumB;
    private  int imageParkingLotB;

    public RightListLotItemB(String parkingNumB, int imageParkingLotB) {
        ParkingNumB = parkingNumB;
        this.imageParkingLotB = imageParkingLotB;
    }

    public String getParkingNumB() {
        return ParkingNumB;
    }

    public void setParkingNumB(String parkingNumB) {
        ParkingNumB = parkingNumB;
    }

    public int getImageParkingLotB() {
        return imageParkingLotB;
    }

    public void setImageParkingLotB(int imageParkingLotB) {
        this.imageParkingLotB = imageParkingLotB;
    }
}
