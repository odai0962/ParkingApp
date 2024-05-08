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

public class ParkingLotC extends AppCompatActivity implements  RightItemClickListenerC ,LeftItemClickListenerC{
    RecyclerView recyclerViewLeftC;
    List<leftListLotItemC> leftListC;
    LeftLotAdapterC leftLotAdapterC;


    RecyclerView recyclerViewRightC;
    List<RightListLotItemC> RightListC;
    RightLotAdapterC rightLotAdapterC;

    RecyclerView recyclerViewCenterC;
    List<ArrowImageItemC> CenterlistC;
    ArrowImageAdapterC arrowImageAdapterC;

    ImageButton leftClickArrowC;
    ImageButton rightClickArrowC;


    @Override
    public void RightOnClickC(View v, int pos) {
        Toast.makeText(this, "right lest : "+RightListC.get(pos).getParkingNumC(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LeftOnClickC(View v, int pos) {
        Toast.makeText(this, "right lest : "+leftListC.get(pos).getParkingNumC(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_lot_c);

        recyclerViewCenterC = findViewById(R.id.centerRecyclerViewC);
        recyclerViewLeftC = findViewById(R.id.leftRecyclerViewC);
        recyclerViewRightC= findViewById(R.id.RightRecyclerViewC);


        leftListC = new  ArrayList<>();
        RightListC = new  ArrayList<>();
        CenterlistC = new  ArrayList<>();

        callLeftlistC();
        callRightlistC();
        callCenterListC();

        leftLotAdapterC =new LeftLotAdapterC(leftListC);
        rightLotAdapterC = new RightLotAdapterC(RightListC);
        arrowImageAdapterC =new ArrowImageAdapterC(CenterlistC);

        recyclerViewLeftC.setAdapter(leftLotAdapterC);
        recyclerViewCenterC.setAdapter(arrowImageAdapterC);
        recyclerViewRightC.setAdapter(rightLotAdapterC);


        LinearLayoutManager layoutManagerRightC = new LinearLayoutManager(this);
        LinearLayoutManager layoutManagerCenterC = new LinearLayoutManager(this);
        LinearLayoutManager layoutManagerLeftC = new LinearLayoutManager(this);


        recyclerViewRightC.setLayoutManager(layoutManagerRightC);
        recyclerViewCenterC.setLayoutManager(layoutManagerCenterC);
        recyclerViewLeftC.setLayoutManager(layoutManagerLeftC);

        leftClickArrowC =findViewById(R.id.leftClickArrowC);
        leftClickArrowC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ParkingLotC.this,ParkingLotB.class);
                startActivity(intent);
            }
        });
        rightLotAdapterC.setRightClickListenerC(this);
        leftLotAdapterC.setLeftItemClickListenerC(this);



    }

    void callCenterListC(){
        ArrowImageItemC arrowImageItemC1 = new ArrowImageItemC(R.drawable.arrowimage);
        ArrowImageItemC arrowImageItemC2 = new ArrowImageItemC(R.drawable.arrowimage);
        ArrowImageItemC arrowImageItemC3 = new ArrowImageItemC(R.drawable.arrowimage);
        ArrowImageItemC arrowImageItemC4 = new ArrowImageItemC(R.drawable.arrowimage);
        CenterlistC.add(arrowImageItemC1);
        CenterlistC.add(arrowImageItemC2);
        CenterlistC.add(arrowImageItemC3);
        CenterlistC.add(arrowImageItemC4);

    }


    void callRightlistC(){
        RightListLotItemC rightListLotItemC1 = new RightListLotItemC("C16",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItemC2 = new RightListLotItemC("C17",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItemC3 = new RightListLotItemC("C18",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItemC4 = new RightListLotItemC("C19",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItemC5 = new RightListLotItemC("C20",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItemC6 = new RightListLotItemC("C21",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItemC7 = new RightListLotItemC("C22",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItemC8 = new RightListLotItemC("C23",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItemC9 = new RightListLotItemC("C24",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItemC10 = new RightListLotItemC("C25",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItemC11 = new RightListLotItemC("C26",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItemC12 = new RightListLotItemC("C27",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItemC13 = new RightListLotItemC("C28",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItemC14 = new RightListLotItemC("C29",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItemC15 = new RightListLotItemC("C30",R.drawable.parkinglotright);
        RightListC.add(rightListLotItemC1);
        RightListC.add(rightListLotItemC2);
        RightListC.add(rightListLotItemC3);
        RightListC.add(rightListLotItemC4);
        RightListC.add(rightListLotItemC5);
        RightListC.add(rightListLotItemC6);
        RightListC.add(rightListLotItemC7);
        RightListC.add(rightListLotItemC8);
        RightListC.add(rightListLotItemC9);
        RightListC.add(rightListLotItemC10);
        RightListC.add(rightListLotItemC11);
        RightListC.add(rightListLotItemC12);
        RightListC.add(rightListLotItemC13);
        RightListC.add(rightListLotItemC14);
        RightListC.add(rightListLotItemC15);
    }

    void callLeftlistC(){
        leftListLotItemC leftListLotItemC1 = new leftListLotItemC("C01",R.drawable.parkinglot);
        leftListLotItemC leftListLotItemC2 = new leftListLotItemC("C02",R.drawable.parkinglot);
        leftListLotItemC leftListLotItemC3 = new leftListLotItemC("C03",R.drawable.parkinglot);
        leftListLotItemC leftListLotItemC4 = new leftListLotItemC("C04",R.drawable.parkinglot);
        leftListLotItemC leftListLotItemC5 = new leftListLotItemC("C05",R.drawable.parkinglot);
        leftListLotItemC leftListLotItemC6 = new leftListLotItemC("C06",R.drawable.parkinglot);
        leftListLotItemC leftListLotItemC7 = new leftListLotItemC("C07",R.drawable.parkinglot);
        leftListLotItemC leftListLotItemC8 = new leftListLotItemC("C08",R.drawable.parkinglot);
        leftListLotItemC leftListLotItemC9 = new leftListLotItemC("C09",R.drawable.parkinglot);
        leftListLotItemC leftListLotItemC10 = new leftListLotItemC("C10",R.drawable.parkinglot);
        leftListLotItemC leftListLotItemC11 = new leftListLotItemC("C11",R.drawable.parkinglot);
        leftListLotItemC leftListLotItemC12 = new leftListLotItemC("C12",R.drawable.parkinglot);
        leftListLotItemC leftListLotItemC13 = new leftListLotItemC("C13",R.drawable.parkinglot);
        leftListLotItemC leftListLotItemC14 = new leftListLotItemC("C14",R.drawable.parkinglot);
        leftListLotItemC leftListLotItemC15 = new leftListLotItemC("C15",R.drawable.parkinglot);
        leftListC.add(leftListLotItemC1);
        leftListC.add(leftListLotItemC2);
        leftListC.add(leftListLotItemC3);
        leftListC.add(leftListLotItemC4);
        leftListC.add(leftListLotItemC5);
        leftListC.add(leftListLotItemC6);
        leftListC.add(leftListLotItemC7);
        leftListC.add(leftListLotItemC8);
        leftListC.add(leftListLotItemC9);
        leftListC.add(leftListLotItemC10);
        leftListC.add(leftListLotItemC11);
        leftListC.add(leftListLotItemC12);
        leftListC.add(leftListLotItemC13);
        leftListC.add(leftListLotItemC14);
        leftListC.add(leftListLotItemC15);
    }
}