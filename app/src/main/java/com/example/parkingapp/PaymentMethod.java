package com.example.parkingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.parkingapp.databinding.ActivityPaymentMethodBinding;

import java.util.ArrayList;
import java.util.List;

public class PaymentMethod extends AppCompatActivity {

    private ArrayList<AddCardContent> cardContents = new ArrayList<>();
    private AddCardAdapter cardAdapter;
    private ActivityPaymentMethodBinding paymentMethodBinding;
    private AddNewCardClickHandler clickHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        paymentMethodBinding = DataBindingUtil.setContentView(this, R.layout.activity_payment_method);
        clickHandler = new AddNewCardClickHandler(this);
        paymentMethodBinding.setAddNewCardClickHandler(clickHandler);

        RecyclerView recyclerView = paymentMethodBinding.cardRecycleView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        cardAdapter = new AddCardAdapter(cardContents);
        recyclerView.setAdapter(cardAdapter);
        AddCardModel cardModel = new ViewModelProvider(this).get(AddCardModel.class);
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
             AddCardContent cardContent =cardContents.get(viewHolder.getAdapterPosition());
                cardModel.deleteContent(cardContent);
            }
        }).attachToRecyclerView(recyclerView);



        cardModel.getAllContent().observe(this, new Observer<List<AddCardContent>>() {
            @Override
            public void onChanged(List<AddCardContent> addCardContents) {
                cardContents.clear();
                if (addCardContents != null) {
                    cardContents.addAll(addCardContents);
                    Log.v("TAGY", "Card contents updated: " + cardContents.size());
                } else {
                    Log.v("TAGY", "No card contents found");
                }
                cardAdapter.notifyDataSetChanged();
            }
        });

        // Test data addition (ensure this is not redundant)


    }
}
