package com.example.parkingapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotB extends AppCompatActivity implements RightItemClickListenerB , LeftItemClickListenerB{
    RecyclerView recyclerViewLeftB;
    List<leftListLotItemB> leftListB;
    LeftLotAdapterB leftLotAdapterB;


    RecyclerView recyclerViewRightB;
    List<RightListLotItemB> RightListB;
    RightLotAdapterB rightLotAdapterB;

    RecyclerView recyclerViewCenterB;
    List<ArrowImageItemB> CenterlistB;
    ArrowImageAdapterB arrowImageAdapterB;

    ImageButton leftClickArrowB;
    ImageButton rightClickArrowB;


    @Override
    public void RightOnClickB(View v, int pos) {
        Toast.makeText(this, "rightLot : "+RightListB.get(pos).getParkingNumB(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LeftOnClickB(View v, int pos) {
        Toast.makeText(this, "rightLot : "+leftListB.get(pos).getParkingNumB(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_lot_b);


        recyclerViewCenterB = findViewById(R.id.centerRecyclerViewB);
        recyclerViewLeftB = findViewById(R.id.leftRecyclerViewB);
        recyclerViewRightB= findViewById(R.id.RightRecyclerViewB);


        leftListB = new  ArrayList<>();
        RightListB = new  ArrayList<>();
        CenterlistB = new  ArrayList<>();

        callLeftlistB();
        callRightlistB();
        callCenterListB();

        leftLotAdapterB =new LeftLotAdapterB(leftListB);
        rightLotAdapterB = new RightLotAdapterB(RightListB);
        arrowImageAdapterB =new ArrowImageAdapterB(CenterlistB);

        recyclerViewLeftB.setAdapter(leftLotAdapterB);
        recyclerViewCenterB.setAdapter(arrowImageAdapterB);
        recyclerViewRightB.setAdapter(rightLotAdapterB);


        LinearLayoutManager layoutManagerRightB = new LinearLayoutManager(this);
        LinearLayoutManager layoutManagerCenterB = new LinearLayoutManager(this);
        LinearLayoutManager layoutManagerLeftB = new LinearLayoutManager(this);


        recyclerViewRightB.setLayoutManager(layoutManagerRightB);
        recyclerViewCenterB.setLayoutManager(layoutManagerCenterB);
        recyclerViewLeftB.setLayoutManager(layoutManagerLeftB);

        leftClickArrowB =findViewById(R.id.leftClickArrowB);
        rightClickArrowB =findViewById(R.id.rightClickArrowB);

        leftClickArrowB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ParkingLotB.this,ParkingLot.class);
                startActivity(intent);
            }
        });
        rightClickArrowB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentright = new Intent(ParkingLotB.this,ParkingLotC.class);
                startActivity(intentright);
            }
        });

        rightLotAdapterB.setRightClickListenerB(this);
        leftLotAdapterB.setLeftClickListenerB(this);


    }

    void callCenterListB(){
        ArrowImageItemB arrowImageItemB1 = new ArrowImageItemB(R.drawable.arrowimage);
        ArrowImageItemB arrowImageItemB2 = new ArrowImageItemB(R.drawable.arrowimage);
        ArrowImageItemB arrowImageItemB3 = new ArrowImageItemB(R.drawable.arrowimage);
        ArrowImageItemB arrowImageItemB4 = new ArrowImageItemB(R.drawable.arrowimage);
        CenterlistB.add(arrowImageItemB1);
        CenterlistB.add(arrowImageItemB2);
        CenterlistB.add(arrowImageItemB3);
        CenterlistB.add(arrowImageItemB4);

    }


    void callRightlistB(){
        RightListLotItemB rightListLotItemB1 = new RightListLotItemB("B16",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItemB2 = new RightListLotItemB("B17",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItemB3 = new RightListLotItemB("B18",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItemB4 = new RightListLotItemB("B19",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItemB5 = new RightListLotItemB("B20",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItemB6 = new RightListLotItemB("B21",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItemB7 = new RightListLotItemB("B22",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItemB8 = new RightListLotItemB("B23",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItemB9 = new RightListLotItemB("B24",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItemB10 = new RightListLotItemB("B25",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItemB11 = new RightListLotItemB("B26",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItemB12 = new RightListLotItemB("B27",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItemB13 = new RightListLotItemB("B28",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItemB14 = new RightListLotItemB("B29",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItemB15 = new RightListLotItemB("B30",R.drawable.parkinglotright);
        RightListB.add(rightListLotItemB1);
        RightListB.add(rightListLotItemB2);
        RightListB.add(rightListLotItemB3);
        RightListB.add(rightListLotItemB4);
        RightListB.add(rightListLotItemB5);
        RightListB.add(rightListLotItemB6);
        RightListB.add(rightListLotItemB7);
        RightListB.add(rightListLotItemB8);
        RightListB.add(rightListLotItemB9);
        RightListB.add(rightListLotItemB10);
        RightListB.add(rightListLotItemB11);
        RightListB.add(rightListLotItemB12);
        RightListB.add(rightListLotItemB13);
        RightListB.add(rightListLotItemB14);
        RightListB.add(rightListLotItemB15);
    }

    void callLeftlistB(){
        leftListLotItemB leftListLotItemB1 = new leftListLotItemB("B01",R.drawable.parkinglot);
        leftListLotItemB leftListLotItemB2 = new leftListLotItemB("B02",R.drawable.parkinglot);
        leftListLotItemB leftListLotItemB3 = new leftListLotItemB("B03",R.drawable.parkinglot);
        leftListLotItemB leftListLotItemB4 = new leftListLotItemB("B04",R.drawable.parkinglot);
        leftListLotItemB leftListLotItemB5 = new leftListLotItemB("B05",R.drawable.parkinglot);
        leftListLotItemB leftListLotItemB6 = new leftListLotItemB("B06",R.drawable.parkinglot);
        leftListLotItemB leftListLotItemB7 = new leftListLotItemB("B07",R.drawable.parkinglot);
        leftListLotItemB leftListLotItemB8 = new leftListLotItemB("B08",R.drawable.parkinglot);
        leftListLotItemB leftListLotItemB9 = new leftListLotItemB("B09",R.drawable.parkinglot);
        leftListLotItemB leftListLotItemB10 = new leftListLotItemB("B10",R.drawable.parkinglot);
        leftListLotItemB leftListLotItemB11 = new leftListLotItemB("B11",R.drawable.parkinglot);
        leftListLotItemB leftListLotItemB12 = new leftListLotItemB("B12",R.drawable.parkinglot);
        leftListLotItemB leftListLotItemB13 = new leftListLotItemB("B13",R.drawable.parkinglot);
        leftListLotItemB leftListLotItemB14 = new leftListLotItemB("B14",R.drawable.parkinglot);
        leftListLotItemB leftListLotItemB15 = new leftListLotItemB("B15",R.drawable.parkinglot);
        leftListB.add(leftListLotItemB1);
        leftListB.add(leftListLotItemB2);
        leftListB.add(leftListLotItemB3);
        leftListB.add(leftListLotItemB4);
        leftListB.add(leftListLotItemB5);
        leftListB.add(leftListLotItemB6);
        leftListB.add(leftListLotItemB7);
        leftListB.add(leftListLotItemB8);
        leftListB.add(leftListLotItemB9);
        leftListB.add(leftListLotItemB10);
        leftListB.add(leftListLotItemB11);
        leftListB.add(leftListLotItemB12);
        leftListB.add(leftListLotItemB13);
        leftListB.add(leftListLotItemB14);
        leftListB.add(leftListLotItemB15);
    }
}