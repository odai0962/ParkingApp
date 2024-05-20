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

public class ParkingLotB extends AppCompatActivity  implements  RightItemClickListenerB ,LeftItemClickListenerB{

    RecyclerView recyclerViewLeftB;
    List<leftListLotItemB> leftListB;
    LeftLotAdapterB leftLotAdapterB;


    RecyclerView recyclerViewRightB;
    List<RightListLotItemB> RightListB;
    RightLotAdapterB rightLotAdapterB;

    RecyclerView recyclerViewCenterB;
    List<ArrowImageItemB> CenterlistB;
    ArrowImageAdapterB arrowImageAdapterB;

    ImageButton rightClickArrowB;
    ImageButton LeftClickArrowB;

    public ParkingLotB() {
        super();
    }

    @Override
    public void LeftOnClickB(View v, int pos) {
        leftListLotItemB leftClickedItemB = leftListB.get(pos);
        Log.d("OnClick", "Left RecyclerView clicked at position: " + pos);
        Toast.makeText(this, "Left RecyclerView: " + leftClickedItemB.getParkingNumB(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void RightOnClickB(View v, int pos) {
        RightListLotItemB rightClickedItemB = RightListB.get(pos);
        Log.d("OnClick", "Right RecyclerView clicked at position: " + pos);
        Toast.makeText(this, "Right RecyclerView: " + rightClickedItemB.getParkingNumB(), Toast.LENGTH_SHORT).show();
    }















    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_lot_b);


        recyclerViewLeftB = findViewById(R.id.leftRecyclerViewB);
        leftListB = new ArrayList<>();
        callLeftlistB();
        leftLotAdapterB = new LeftLotAdapterB(leftListB);
        recyclerViewLeftB.setAdapter(leftLotAdapterB);
        LinearLayoutManager layoutManagerB =new LinearLayoutManager(this);
        recyclerViewLeftB.setLayoutManager(layoutManagerB);


        recyclerViewRightB =findViewById(R.id.RightRecyclerViewB);
        RightListB = new ArrayList<>();
        callRightlistB();
        rightLotAdapterB =new RightLotAdapterB(RightListB);
        recyclerViewRightB.setAdapter(rightLotAdapterB);
        LinearLayoutManager layoutManagerRightB = new LinearLayoutManager(this);
        recyclerViewRightB.setLayoutManager(layoutManagerRightB);

        CenterlistB = new ArrayList<>();
        callCenterListB();
        recyclerViewCenterB = findViewById(R.id.centerRecyclerViewB);
        arrowImageAdapterB = new ArrowImageAdapterB(CenterlistB);
        recyclerViewCenterB.setAdapter(arrowImageAdapterB);
        LinearLayoutManager layoutManagerCenterB =new LinearLayoutManager(this);
        recyclerViewCenterB.setLayoutManager(layoutManagerCenterB);



        rightClickArrowB = findViewById(R.id.rightClickArrowB);
        LeftClickArrowB = findViewById(R.id.leftClickArrowB);

        LeftClickArrowB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ParkingLotB.this,ParkingLot.class);
                startActivity(i);
            }
        });
        rightClickArrowB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ParkingLotB.this,ParkingLotC.class);
                startActivity(intent);
            }
        });

        rightLotAdapterB.setRightClickListenerB(this);
        leftLotAdapterB.setLeftClickListenerB(this);

        leftLotAdapterB.setRightLotAdapterB(rightLotAdapterB);
        rightLotAdapterB.setLeftLotAdapterB(leftLotAdapterB);

    }



    void callCenterListB(){
        ArrowImageItemB arrowImageItem1 = new ArrowImageItemB(R.drawable.arrowimage);
        ArrowImageItemB arrowImageItem2 = new ArrowImageItemB(R.drawable.arrowimage);
        ArrowImageItemB arrowImageItem3 = new ArrowImageItemB(R.drawable.arrowimage);
        ArrowImageItemB arrowImageItem4 = new ArrowImageItemB(R.drawable.arrowimage);
        CenterlistB.add(arrowImageItem1);
        CenterlistB.add(arrowImageItem2);
        CenterlistB.add(arrowImageItem3);
        CenterlistB.add(arrowImageItem4);

    }


    void callRightlistB(){
        RightListLotItemB rightListLotItem1 = new RightListLotItemB("B16",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItem2 = new RightListLotItemB("B17",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItem3 = new RightListLotItemB("B18",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItem4 = new RightListLotItemB("B19",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItem5 = new RightListLotItemB("B20",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItem6 = new RightListLotItemB("B21",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItem7 = new RightListLotItemB("B22",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItem8 = new RightListLotItemB("B23",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItem9 = new RightListLotItemB("B24",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItem10 = new RightListLotItemB("B25",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItem11 = new RightListLotItemB("B26",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItem12 = new RightListLotItemB("B27",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItem13 = new RightListLotItemB("B28",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItem14 = new RightListLotItemB("B29",R.drawable.parkinglotright);
        RightListLotItemB rightListLotItem15 = new RightListLotItemB("B30",R.drawable.parkinglotright);
        RightListB.add(rightListLotItem1);
        RightListB.add(rightListLotItem2);
        RightListB.add(rightListLotItem3);
        RightListB.add(rightListLotItem4);
        RightListB.add(rightListLotItem5);
        RightListB.add(rightListLotItem6);
        RightListB.add(rightListLotItem7);
        RightListB.add(rightListLotItem8);
        RightListB.add(rightListLotItem9);
        RightListB.add(rightListLotItem10);
        RightListB.add(rightListLotItem11);
        RightListB.add(rightListLotItem12);
        RightListB.add(rightListLotItem13);
        RightListB.add(rightListLotItem14);
        RightListB.add(rightListLotItem15);
    }

    void callLeftlistB(){
        leftListLotItemB leftListLotItem1 = new leftListLotItemB("B01",R.drawable.parkinglot);
        leftListLotItemB leftListLotItem2 = new leftListLotItemB("B02",R.drawable.parkinglot);
        leftListLotItemB leftListLotItem3 = new leftListLotItemB("B03",R.drawable.parkinglot);
        leftListLotItemB leftListLotItem4 = new leftListLotItemB("B04",R.drawable.parkinglot);
        leftListLotItemB leftListLotItem5 = new leftListLotItemB("B05",R.drawable.parkinglot);
        leftListLotItemB leftListLotItem6 = new leftListLotItemB("B06",R.drawable.parkinglot);
        leftListLotItemB leftListLotItem7 = new leftListLotItemB("B07",R.drawable.parkinglot);
        leftListLotItemB leftListLotItem8 = new leftListLotItemB("B08",R.drawable.parkinglot);
        leftListLotItemB leftListLotItem9 = new leftListLotItemB("B09",R.drawable.parkinglot);
        leftListLotItemB leftListLotItem10 = new leftListLotItemB("B10",R.drawable.parkinglot);
        leftListLotItemB leftListLotItem11 = new leftListLotItemB("B11",R.drawable.parkinglot);
        leftListLotItemB leftListLotItem12 = new leftListLotItemB("B12",R.drawable.parkinglot);
        leftListLotItemB leftListLotItem13 = new leftListLotItemB("B13",R.drawable.parkinglot);
        leftListLotItemB leftListLotItem14 = new leftListLotItemB("B14",R.drawable.parkinglot);
        leftListLotItemB leftListLotItem15 = new leftListLotItemB("B15",R.drawable.parkinglot);
        leftListB.add(leftListLotItem1);
        leftListB.add(leftListLotItem2);
        leftListB.add(leftListLotItem3);
        leftListB.add(leftListLotItem4);
        leftListB.add(leftListLotItem5);
        leftListB.add(leftListLotItem6);
        leftListB.add(leftListLotItem7);
        leftListB.add(leftListLotItem8);
        leftListB.add(leftListLotItem9);
        leftListB.add(leftListLotItem10);
        leftListB.add(leftListLotItem11);
        leftListB.add(leftListLotItem12);
        leftListB.add(leftListLotItem13);
        leftListB.add(leftListLotItem14);
        leftListB.add(leftListLotItem15);
    }
}