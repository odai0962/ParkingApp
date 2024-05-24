package com.example.parkingapp;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AddCardRepository {
    private final AddCardContentDAO addCardContentDAO;
    private final ExecutorService executorService;

    public AddCardRepository(Application application) {
        AddCardContentDataBase contentDataBase = AddCardContentDataBase.getDbInstance(application);
        this.addCardContentDAO = contentDataBase.getContentDAO();
        this.executorService = Executors.newSingleThreadExecutor();
    }

    public void addCardContent(AddCardContent addCardContent) {
        executorService.execute(() -> addCardContentDAO.insert(addCardContent));
    }

    public void deleteContent(AddCardContent addCardContent) {
        executorService.execute(() -> addCardContentDAO.delete(addCardContent));
    }

    public LiveData<List<AddCardContent>> getAllContent() {
        return addCardContentDAO.getAllContent();
    }
}
