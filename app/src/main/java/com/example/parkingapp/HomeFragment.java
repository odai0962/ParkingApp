package com.example.parkingapp;
import android.content.Intent;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkingapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements ItemCarClickListener{
    private AddCarContactsDataBase carContactsDataBase;
    private ArrayList<AddCarContacts> addCarContactsArrayList = new ArrayList<>();
    private MyAdapter myAdapter;
    private FragmentHomeBinding fragmentHomeBinding;
    private FragmentHomeClickHandler clickHandler;
    private TextView emptyTextView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        View view = fragmentHomeBinding.getRoot();

        emptyTextView = view.findViewById(R.id.emptyTextView);

        clickHandler = new FragmentHomeClickHandler(getContext());
        fragmentHomeBinding.setClickHandler(clickHandler);

        RecyclerView recyclerView = fragmentHomeBinding.HorizontalRV;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHasFixedSize(true);

        carContactsDataBase = AddCarContactsDataBase.getInstance(getContext());

        AddCarModel addCarModel = new ViewModelProvider(this).get(AddCarModel.class);

        addCarModel.getAllContacts().observe(getViewLifecycleOwner(), new Observer<List<AddCarContacts>>() {
            @Override
            public void onChanged(List<AddCarContacts> addCarContacts) {
                addCarContactsArrayList.clear();
                for (AddCarContacts c : addCarContacts) {
                    Log.v("TAGY", c.getType());
                    addCarContactsArrayList.add(c);
                }
                myAdapter.notifyDataSetChanged();

                // Update visibility of TextView
                if (addCarContacts.isEmpty()) {
                    emptyTextView.setVisibility(View.VISIBLE);
                } else {
                    emptyTextView.setVisibility(View.GONE);
                }
            }
        });

        myAdapter = new MyAdapter(addCarContactsArrayList);
        recyclerView.setAdapter(myAdapter);



        myAdapter.setItemCarClickListener(this);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.UP) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                final AddCarContacts c = addCarContactsArrayList.get(viewHolder.getAdapterPosition());

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("Are you sure you want to delete this car?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                addCarModel.deleteContact(c);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // User cancelled the dialog, so we need to notify the adapter to refresh the view
                                myAdapter.notifyDataSetChanged();
                                dialog.dismiss();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        }).attachToRecyclerView(recyclerView);

        return view;
    }

    @Override
    public void onClick(View v, int position) {
        // Assuming you have a ParkingLotActivity class
        Intent intent = new Intent(getContext(), ParkingLot.class);


        startActivity(intent);
    }

}
