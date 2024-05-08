package com.example.parkingapp;
import android.util.Log;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
public class HomeFragment extends Fragment implements  itemCarClickListener{
    RecyclerView recyclerView;
    List<ItemList> list;
    MyAdapter myAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.HorizontalRV);
        list = new ArrayList<>();
        ItemList list1 = new ItemList("tesla", 5);
        ItemList list2 = new ItemList("ferrari", 5);
        ItemList list3 = new ItemList("lamborghini", 5);
        list.add(list1);
        list.add(list2);
        list.add(list3);

        // Set the LinearLayoutManager orientation to horizontal
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        myAdapter = new MyAdapter(list);
        recyclerView.setAdapter(myAdapter);

        myAdapter.setClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v, int pos) {
        Log.d("HomeFragment", "Item clicked at position: " + pos);
        Toast.makeText(getContext(), "Your car is: " + list.get(pos).getCarModel(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(), ParkingLot.class);
        startActivity(intent);
    }


}
