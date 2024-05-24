package com.example.parkingapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AddCardModel extends AndroidViewModel {
    private AddCardRepository cardRepository;
    private LiveData<List<AddCardContent>> allContent;

    public AddCardModel(@NonNull Application application) {
        super(application);
        this.cardRepository = new AddCardRepository(application);
        this.allContent = cardRepository.getAllContent(); // Initialize allContent here
    }

    public LiveData<List<AddCardContent>> getAllContent() {
        return allContent;
    }

    public void addNewContent(AddCardContent addCardContent) {
        cardRepository.addCardContent(addCardContent);
    }

    public void deleteContent(AddCardContent addCardContent) { // Corrected method name
        cardRepository.deleteContent(addCardContent);
    }
}
