package com.example.parkingapp;
import android.util.Log;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.parkingapp.AddCarModel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.parkingapp.databinding.FragmentHomeBinding;
import com.example.parkingapp.databinding.RvItemBinding;

import java.util.ArrayList;
import java.util.List;
public class HomeFragment extends Fragment   {
  private  AddCarContactsDataBase carContactsDataBase;
  private ArrayList<AddCarContacts> addCarContactsArrayList = new ArrayList<>();

  private  MyAdapter myAdapter;

  private FragmentHomeBinding fragmentHomeBinding;
  private  FragmentHomeClickHandler clickHandler;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        View view = fragmentHomeBinding.getRoot();

        clickHandler =new FragmentHomeClickHandler(getContext());
        fragmentHomeBinding.setClickHandler(clickHandler);

        RecyclerView recyclerView = fragmentHomeBinding.HorizontalRV;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        myAdapter = new MyAdapter(addCarContactsArrayList);

        carContactsDataBase = AddCarContactsDataBase.getInstance(getContext());

        AddCarModel addCarModel = new ViewModelProvider(this).get(AddCarModel.class);
        AddCarContacts addCar1 = new AddCarContacts(1,"ferrari","Red");
        addCarModel.addNewContact(addCar1);

        addCarModel.getAllContacts().observe(getViewLifecycleOwner(), new Observer<List<AddCarContacts>>() {
            @Override
            public void onChanged(List<AddCarContacts> addCarContacts) {
                for (AddCarContacts c : addCarContacts) {
                    Log.v("TAGY", c.getType());
                }
            }
        });

        recyclerView.setAdapter(myAdapter);
           return view;
    }




}
