package com.example.parkingapp;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.AndroidViewModel;
import com.example.parkingapp.AddCarContacts;
import com.example.parkingapp.Repository;

import java.util.List;

public class AddCarModel extends AndroidViewModel {
    private Repository repository;
    private LiveData<List<AddCarContacts>> allContacts;

    public AddCarModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
    }

    public LiveData<List<AddCarContacts>> getAllContacts() {
        allContacts = repository.getAllContactes();
        return allContacts;
    }

    public void addNewContact(AddCarContacts addCarContacts){
        repository.addContects(addCarContacts);
    }

    public void deleteContact(AddCarContacts addCarContacts){
        repository.deleteContects(addCarContacts);
    }
}

