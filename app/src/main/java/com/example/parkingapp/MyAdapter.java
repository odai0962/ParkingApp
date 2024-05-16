package com.example.parkingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkingapp.databinding.ActivityAddNewCarBinding;
import com.example.parkingapp.databinding.RvItemBinding;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<AddCarContacts> addCarContactsArrayList;

    public MyAdapter(ArrayList<AddCarContacts> addCarContactsArrayList) {
        this.addCarContactsArrayList = addCarContactsArrayList;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AddCarContacts currentContacts = addCarContactsArrayList.get(position);
        holder.rvItemBinding.setAddcarcontacts(currentContacts);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RvItemBinding rvItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.rv_item,
                parent,
                false
        );
        return new MyViewHolder(rvItemBinding);
    }


    @Override
    public int getItemCount() {
          if(addCarContactsArrayList != null){
             return addCarContactsArrayList.size();
          }else {
              return 0;
          }
    }
    public void setaddCarContactsArrayList(ArrayList<AddCarContacts> contacts){
        this.addCarContactsArrayList =contacts;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {
       private RvItemBinding rvItemBinding;

        public MyViewHolder(@NonNull  RvItemBinding rvItemBinding) {
            super(rvItemBinding.getRoot());
            this.rvItemBinding = rvItemBinding;
        }
    }
}
