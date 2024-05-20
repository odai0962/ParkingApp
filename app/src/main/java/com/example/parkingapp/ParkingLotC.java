package com.example.parkingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotC extends AppCompatActivity  implements  RightItemClickListenerC ,LeftItemClickListenerC{

    RecyclerView recyclerViewLeftC;
    List<leftListLotItemC> leftListC;
    LeftLotAdapterC leftLotAdapterC;


    RecyclerView recyclerViewRightC;
    List<RightListLotItemC> RightListC;
    RightLotAdapterC rightLotAdapterC;

    RecyclerView recyclerViewCenterC;
    List<ArrowImageItemC> CenterlistC;
    ArrowImageAdapterC arrowImageAdapterC;

    ImageButton LeftClickArrowC;

    public ParkingLotC() {
        super();
    }

    @Override
    public void LeftOnClickC(View v, int pos) {
        leftListLotItemC leftClickedItemC = leftListC.get(pos);
        Log.d("OnClick", "Left RecyclerView clicked at position: " + pos);
        Toast.makeText(this, "Left RecyclerView: " + leftClickedItemC.getParkingNumC(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void RightOnClickC(View v, int pos) {
        RightListLotItemC rightClickedItemC = RightListC.get(pos);
        Log.d("OnClick", "Right RecyclerView clicked at position: " + pos);
        Toast.makeText(this, "Right RecyclerView: " + rightClickedItemC.getParkingNumC(), Toast.LENGTH_SHORT).show();
    }















    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_lot_c);


        recyclerViewLeftC = findViewById(R.id.leftRecyclerViewC);
        leftListC = new ArrayList<>();
        callLeftlistC();
        leftLotAdapterC = new LeftLotAdapterC(leftListC);
        recyclerViewLeftC.setAdapter(leftLotAdapterC);
        LinearLayoutManager layoutManagerC =new LinearLayoutManager(this);
        recyclerViewLeftC.setLayoutManager(layoutManagerC);


        recyclerViewRightC =findViewById(R.id.RightRecyclerViewC);
        RightListC = new ArrayList<>();
        callRightlistC();
        rightLotAdapterC =new RightLotAdapterC(RightListC);
        recyclerViewRightC.setAdapter(rightLotAdapterC);
        LinearLayoutManager layoutManagerRightC = new LinearLayoutManager(this);
        recyclerViewRightC.setLayoutManager(layoutManagerRightC);

        CenterlistC = new ArrayList<>();
        callCenterListC();
        recyclerViewCenterC = findViewById(R.id.centerRecyclerViewC);
        arrowImageAdapterC = new ArrowImageAdapterC(CenterlistC);
        recyclerViewCenterC.setAdapter(arrowImageAdapterC);
        LinearLayoutManager layoutManagerCenterC =new LinearLayoutManager(this);
        recyclerViewCenterC.setLayoutManager(layoutManagerCenterC);



        LeftClickArrowC = findViewById(R.id.leftClickArrowC);
        LeftClickArrowC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ParkingLotC.this, ParkingLotB.class);
                startActivity(intent);
            }
        });


        rightLotAdapterC.setRightClickListenerC(this);
        leftLotAdapterC.setLeftClickListenerC(this);

        leftLotAdapterC.setRightLotAdapterC(rightLotAdapterC);
        rightLotAdapterC.setLeftLotAdapterC(leftLotAdapterC);

    }



    void callCenterListC(){
        ArrowImageItemC arrowImageItem1 = new ArrowImageItemC(R.drawable.arrowimage);
        ArrowImageItemC arrowImageItem2 = new ArrowImageItemC(R.drawable.arrowimage);
        ArrowImageItemC arrowImageItem3 = new ArrowImageItemC(R.drawable.arrowimage);
        ArrowImageItemC arrowImageItem4 = new ArrowImageItemC(R.drawable.arrowimage);
        CenterlistC.add(arrowImageItem1);
        CenterlistC.add(arrowImageItem2);
        CenterlistC.add(arrowImageItem3);
        CenterlistC.add(arrowImageItem4);

    }


    void callRightlistC(){
        RightListLotItemC rightListLotItem1 = new RightListLotItemC("C16",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItem2 = new RightListLotItemC("C17",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItem3 = new RightListLotItemC("C18",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItem4 = new RightListLotItemC("C19",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItem5 = new RightListLotItemC("C20",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItem6 = new RightListLotItemC("C21",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItem7 = new RightListLotItemC("C22",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItem8 = new RightListLotItemC("C23",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItem9 = new RightListLotItemC("C24",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItem10 = new RightListLotItemC("C25",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItem11 = new RightListLotItemC("C26",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItem12 = new RightListLotItemC("C27",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItem13 = new RightListLotItemC("C28",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItem14 = new RightListLotItemC("C29",R.drawable.parkinglotright);
        RightListLotItemC rightListLotItem15 = new RightListLotItemC("C30",R.drawable.parkinglotright);
        RightListC.add(rightListLotItem1);
        RightListC.add(rightListLotItem2);
        RightListC.add(rightListLotItem3);
        RightListC.add(rightListLotItem4);
        RightListC.add(rightListLotItem5);
        RightListC.add(rightListLotItem6);
        RightListC.add(rightListLotItem7);
        RightListC.add(rightListLotItem8);
        RightListC.add(rightListLotItem9);
        RightListC.add(rightListLotItem10);
        RightListC.add(rightListLotItem11);
        RightListC.add(rightListLotItem12);
        RightListC.add(rightListLotItem13);
        RightListC.add(rightListLotItem14);
        RightListC.add(rightListLotItem15);
    }

    void callLeftlistC(){
        leftListLotItemC leftListLotItem1 = new leftListLotItemC("C01",R.drawable.parkinglot);
        leftListLotItemC leftListLotItem2 = new leftListLotItemC("C02",R.drawable.parkinglot);
        leftListLotItemC leftListLotItem3 = new leftListLotItemC("C03",R.drawable.parkinglot);
        leftListLotItemC leftListLotItem4 = new leftListLotItemC("C04",R.drawable.parkinglot);
        leftListLotItemC leftListLotItem5 = new leftListLotItemC("C05",R.drawable.parkinglot);
        leftListLotItemC leftListLotItem6 = new leftListLotItemC("C06",R.drawable.parkinglot);
        leftListLotItemC leftListLotItem7 = new leftListLotItemC("C07",R.drawable.parkinglot);
        leftListLotItemC leftListLotItem8 = new leftListLotItemC("C08",R.drawable.parkinglot);
        leftListLotItemC leftListLotItem9 = new leftListLotItemC("C09",R.drawable.parkinglot);
        leftListLotItemC leftListLotItem10 = new leftListLotItemC("C10",R.drawable.parkinglot);
        leftListLotItemC leftListLotItem11 = new leftListLotItemC("C11",R.drawable.parkinglot);
        leftListLotItemC leftListLotItem12 = new leftListLotItemC("C12",R.drawable.parkinglot);
        leftListLotItemC leftListLotItem13 = new leftListLotItemC("C13",R.drawable.parkinglot);
        leftListLotItemC leftListLotItem14 = new leftListLotItemC("C14",R.drawable.parkinglot);
        leftListLotItemC leftListLotItem15 = new leftListLotItemC("C15",R.drawable.parkinglot);
        leftListC.add(leftListLotItem1);
        leftListC.add(leftListLotItem2);
        leftListC.add(leftListLotItem3);
        leftListC.add(leftListLotItem4);
        leftListC.add(leftListLotItem5);
        leftListC.add(leftListLotItem6);
        leftListC.add(leftListLotItem7);
        leftListC.add(leftListLotItem8);
        leftListC.add(leftListLotItem9);
        leftListC.add(leftListLotItem10);
        leftListC.add(leftListLotItem11);
        leftListC.add(leftListLotItem12);
        leftListC.add(leftListLotItem13);
        leftListC.add(leftListLotItem14);
        leftListC.add(leftListLotItem15);
    }
}