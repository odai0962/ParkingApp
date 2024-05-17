package com.example.parkingapp;

public class SignupModel {
    String firstName,LastName,email,password,ConfirmPassword,studentID,phoneNumber;


    public SignupModel(String firstName, String lastName, String email, String password, String confirmPassword, String studentID, String phoneNumber) {
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
        this.password = password;
        ConfirmPassword = confirmPassword;
        this.studentID = studentID;
        this.phoneNumber = phoneNumber;
    }

    public SignupModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
