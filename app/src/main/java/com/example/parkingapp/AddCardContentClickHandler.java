// AddCardContentClickHandler.java
package com.example.parkingapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class AddCardContentClickHandler {

    AddCardContent addCardContent;
    Context context;
    AddCardModel cardModel;

    public AddCardContentClickHandler(AddCardContent addCardContent, Context context, AddCardModel cardModel) {
        this.addCardContent = addCardContent;
        this.context = context;
        this.cardModel = cardModel;
    }

    public void onSubmitBTNClicked(View view) {
        if (addCardContent.getCardNumber() == -1 || addCardContent.getCardName() == null || addCardContent.getUserName() == null || addCardContent.getExpiryDate() == -1 || addCardContent.getCVV() == -1) {
            Toast.makeText(context, "Fields can't be empty", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(context, PaymentMethod.class);
            AddCardContent cardContent = new AddCardContent(
                    addCardContent.getCardName(),
                    addCardContent.getCardNumber()
            );
            cardModel.addNewContent(cardContent);
            context.startActivity(i);
        }
    }
}
