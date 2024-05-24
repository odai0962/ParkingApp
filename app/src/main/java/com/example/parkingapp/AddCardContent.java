// AddCardContent.java
package com.example.parkingapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Card")
public class AddCardContent {

    @ColumnInfo(name = "user_name")
    private String userName;

    @ColumnInfo(name = "card_name")
    private String cardName;

    @ColumnInfo(name = "card_number")
    private int cardNumber;

    @ColumnInfo(name = "unique_id")
    @PrimaryKey(autoGenerate = true)
    private int uniqueId;

    @ColumnInfo(name = "cvv")
    private int CVV;

    @ColumnInfo(name = "expiry_date")
    private int expiryDate;

    public AddCardContent() {
        // Initialize fields with default values
        this.userName = "";
        this.cardName = "";
        this.cardNumber = 0;
        this.CVV = 0;
        this.expiryDate = 0;
    }

    public AddCardContent(String userName, String cardName, int cardNumber, int CVV, int expiryDate) {
        this.userName = userName;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.CVV = CVV;
        this.expiryDate = expiryDate;
    }

    public AddCardContent(String cardName, int cardNumber) {
        this.userName = "";
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        this.CVV = 0;
        this.expiryDate = 0;
    }

    // Getters and setters
    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNumberAsString() {
        return String.valueOf(cardNumber);
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public String getCVVAsString() {
        return String.valueOf(CVV);
    }

    public int getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(int expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getExpiryDateAsString() {
        return String.valueOf(expiryDate);
    }
}
