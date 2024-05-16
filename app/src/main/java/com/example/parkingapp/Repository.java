package com.example.parkingapp;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Repository {

    private final AddCarContactsDAO addCarContactsDAO;
    ExecutorService executor;
    Handler handler;
    public Repository(Application application) {

         AddCarContactsDataBase addCarContactsDataBase =AddCarContactsDataBase.getInstance(application);
          this.addCarContactsDAO = addCarContactsDataBase.getContactsDAO();
         executor = Executors.newSingleThreadExecutor();
         handler = new Handler(Looper.getMainLooper());
    }

    public void  addContects(AddCarContacts addCarContacts){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                addCarContactsDAO.insert(addCarContacts);
            }
        });

    }
    public void deleteContects(AddCarContacts addCarContacts){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                addCarContactsDAO.delete(addCarContacts);
            }
        });


    }

    public LiveData<List<AddCarContacts>> getAllContactes(){
      return   addCarContactsDAO.getAllContacts();
    }
}
