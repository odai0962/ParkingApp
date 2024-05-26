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

public class ParkingLot extends AppCompatActivity implements RightItemClickListenerA, LeftItemClickListenerA {

  RecyclerView recyclerViewLeft;
  List<leftListLotItem> leftList;
  LeftLotAdapter leftLotAdapter;

  RecyclerView recyclerViewRight;
  List<RightListLotItem> RightList;
  RightLotAdapter rightLotAdapter;

  RecyclerView recyclerViewCenter;
  List<ArrowImageItem> Centerlist;
  ArrowImageAdapter arrowImageAdapter;

  ImageButton rightClickArrowA;
  Button nextButtonA;

  RightListLotItem rightClickedItem;
  leftListLotItem leftClickedItem;

  long leftLastSelectedTime;
  long rightLastSelectedTime;
  boolean isItemSelected = false; // Flag to track whether any item is selected
  public ParkingLot() {
    super();
    leftLastSelectedTime = 0;
    rightLastSelectedTime = 0;
  }

  @Override
  public void LeftOnClickA(View v, int pos) {
    leftClickedItem = leftList.get(pos);
    leftLastSelectedTime = System.currentTimeMillis();
    isItemSelected = true;
    Log.d("OnClick", "Left RecyclerView clicked at position: " + pos);
    Toast.makeText(this, "Left RecyclerView: " + leftClickedItem.getParkingNum(), Toast.LENGTH_SHORT).show();
  }

  @Override
  public void RightOnClickA(View v, int pos) {
    rightClickedItem = RightList.get(pos);
    rightLastSelectedTime = System.currentTimeMillis();
    isItemSelected = true;
    Log.d("OnClick", "Right RecyclerView clicked at position: " + pos);
    Toast.makeText(this, "Right RecyclerView: " + rightClickedItem.getParkingNum(), Toast.LENGTH_SHORT).show();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_parking_lot);

    // Retrieve the data from the intent
    Intent intent = getIntent();
    int contactId = intent.getIntExtra("CONTACT_ID", 0);
    String contactColor = intent.getStringExtra("CONTACT_COLOR");
    String contactType = intent.getStringExtra("CONTACT_TYPE");
    // Retrieve other details as necessary

    recyclerViewLeft = findViewById(R.id.leftRecyclerViewA);
    leftList = new ArrayList<>();
    callLeftlist();
    leftLotAdapter = new LeftLotAdapter(leftList);
    recyclerViewLeft.setAdapter(leftLotAdapter);
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    recyclerViewLeft.setLayoutManager(layoutManager);

    recyclerViewRight = findViewById(R.id.RightRecyclerViewA);
    RightList = new ArrayList<>();
    callRightlist();
    rightLotAdapter = new RightLotAdapter(RightList);
    recyclerViewRight.setAdapter(rightLotAdapter);
    LinearLayoutManager layoutManagerRight = new LinearLayoutManager(this);
    recyclerViewRight.setLayoutManager(layoutManagerRight);

    Centerlist = new ArrayList<>();
    callCenterList();
    recyclerViewCenter = findViewById(R.id.centerRecyclerView);
    arrowImageAdapter = new ArrowImageAdapter(Centerlist);
    recyclerViewCenter.setAdapter(arrowImageAdapter);
    LinearLayoutManager layoutManagerCenter = new LinearLayoutManager(this);
    recyclerViewCenter.setLayoutManager(layoutManagerCenter);

    rightClickArrowA = findViewById(R.id.rightClickArrowA);
    rightClickArrowA.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(ParkingLot.this, ParkingLotB.class);
        startActivity(intent);
      }
    });

    nextButtonA = findViewById(R.id.NextButtonA);
    nextButtonA.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        if (isItemSelected) {
          Intent intent = new Intent(ParkingLot.this, CarParkDetailes.class);
          intent.putExtra("CONTACT_ID", contactId);
          intent.putExtra("CONTACT_COLOR", contactColor);
          intent.putExtra("CONTACT_TYPE", contactType);
          intent.putExtra("parkingSectionA", "A");

          // Check which item was selected last
          if (leftLastSelectedTime > rightLastSelectedTime) {
            if (leftClickedItem != null) {
              intent.putExtra("SELECTED_LEFT_ITEM", leftClickedItem.getParkingNum());
            }
          } else {
            if (rightClickedItem != null) {
              intent.putExtra("SELECTED_RIGHT_ITEM", rightClickedItem.getParkingNum());
            }
          }

          Log.d("ParkingLot", "CONTACT_ID: " + contactId);
          Log.d("ParkingLot", "CONTACT_COLOR: " + contactColor);
          Log.d("ParkingLot", "CONTACT_TYPE: " + contactType);
          startActivity(intent);

        } else {

          Toast.makeText(ParkingLot.this, "Please select an item first", Toast.LENGTH_SHORT).show();
        }

      }
    });

    rightLotAdapter.setRightClickListenerA(this);
    leftLotAdapter.setLeftClickListenerA(this);

    leftLotAdapter.setRightLotAdapter(rightLotAdapter);
    rightLotAdapter.setLeftLotAdapter(leftLotAdapter);
  }

  void callCenterList() {
    ArrowImageItem arrowImageItem1 = new ArrowImageItem(R.drawable.arrowimage);
    ArrowImageItem arrowImageItem2 = new ArrowImageItem(R.drawable.arrowimage);
    ArrowImageItem arrowImageItem3 = new ArrowImageItem(R.drawable.arrowimage);
    ArrowImageItem arrowImageItem4 = new ArrowImageItem(R.drawable.arrowimage);
    Centerlist.add(arrowImageItem1);
    Centerlist.add(arrowImageItem2);
    Centerlist.add(arrowImageItem3);
    Centerlist.add(arrowImageItem4);
  }

  void callRightlist() {
    RightListLotItem rightListLotItem1 = new RightListLotItem("A16", R.drawable.parkinglotright);
    RightListLotItem rightListLotItem2 = new RightListLotItem("A17", R.drawable.parkinglotright);
    RightListLotItem rightListLotItem3 = new RightListLotItem("A18", R.drawable.parkinglotright);
    RightListLotItem rightListLotItem4 = new RightListLotItem("A19", R.drawable.parkinglotright);
    RightListLotItem rightListLotItem5 = new RightListLotItem("A20", R.drawable.parkinglotright);
    RightListLotItem rightListLotItem6 = new RightListLotItem("A21", R.drawable.parkinglotright);
    RightListLotItem rightListLotItem7 = new RightListLotItem("A22", R.drawable.parkinglotright);
    RightListLotItem rightListLotItem8 = new RightListLotItem("A23", R.drawable.parkinglotright);
    RightListLotItem rightListLotItem9 = new RightListLotItem("A24", R.drawable.parkinglotright);
    RightListLotItem rightListLotItem10 = new RightListLotItem("A25", R.drawable.parkinglotright);
    RightListLotItem rightListLotItem11 = new RightListLotItem("A26", R.drawable.parkinglotright);
    RightListLotItem rightListLotItem12 = new RightListLotItem("A27", R.drawable.parkinglotright);
    RightListLotItem rightListLotItem13 = new RightListLotItem("A28", R.drawable.parkinglotright);
    RightListLotItem rightListLotItem14 = new RightListLotItem("A29", R.drawable.parkinglotright);
    RightListLotItem rightListLotItem15 = new RightListLotItem("A30", R.drawable.parkinglotright);
    RightList.add(rightListLotItem1);
    RightList.add(rightListLotItem2);
    RightList.add(rightListLotItem3);
    RightList.add(rightListLotItem4);
    RightList.add(rightListLotItem5);
    RightList.add(rightListLotItem6);
    RightList.add(rightListLotItem7);
    RightList.add(rightListLotItem8);
    RightList.add(rightListLotItem9);
    RightList.add(rightListLotItem10);
    RightList.add(rightListLotItem11);
    RightList.add(rightListLotItem12);
    RightList.add(rightListLotItem13);
    RightList.add(rightListLotItem14);
    RightList.add(rightListLotItem15);
  }

  void callLeftlist() {
    leftListLotItem leftListLotItem1 = new leftListLotItem("A01", R.drawable.parkinglot);
    leftListLotItem leftListLotItem2 = new leftListLotItem("A02", R.drawable.parkinglot);
    leftListLotItem leftListLotItem3 = new leftListLotItem("A03", R.drawable.parkinglot);
    leftListLotItem leftListLotItem4 = new leftListLotItem("A04", R.drawable.parkinglot);
    leftListLotItem leftListLotItem5 = new leftListLotItem("A05", R.drawable.parkinglot);
    leftListLotItem leftListLotItem6 = new leftListLotItem("A06", R.drawable.parkinglot);
    leftListLotItem leftListLotItem7 = new leftListLotItem("A07", R.drawable.parkinglot);
    leftListLotItem leftListLotItem8 = new leftListLotItem("A08", R.drawable.parkinglot);
    leftListLotItem leftListLotItem9 = new leftListLotItem("A09", R.drawable.parkinglot);
    leftListLotItem leftListLotItem10 = new leftListLotItem("A10", R.drawable.parkinglot);
    leftListLotItem leftListLotItem11 = new leftListLotItem("A11", R.drawable.parkinglot);
    leftListLotItem leftListLotItem12 = new leftListLotItem("A12", R.drawable.parkinglot);
    leftListLotItem leftListLotItem13 = new leftListLotItem("A13", R.drawable.parkinglot);
    leftListLotItem leftListLotItem14 = new leftListLotItem("A14", R.drawable.parkinglot);
    leftListLotItem leftListLotItem15 = new leftListLotItem("A15", R.drawable.parkinglot);
    leftList.add(leftListLotItem1);
    leftList.add(leftListLotItem2);
    leftList.add(leftListLotItem3);
    leftList.add(leftListLotItem4);
    leftList.add(leftListLotItem5);
    leftList.add(leftListLotItem6);
    leftList.add(leftListLotItem7);
    leftList.add(leftListLotItem8);
    leftList.add(leftListLotItem9);
    leftList.add(leftListLotItem10);
    leftList.add(leftListLotItem11);
    leftList.add(leftListLotItem12);
    leftList.add(leftListLotItem13);
    leftList.add(leftListLotItem14);
    leftList.add(leftListLotItem15);
  }
}
