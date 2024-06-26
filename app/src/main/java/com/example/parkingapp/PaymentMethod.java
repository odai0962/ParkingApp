package com.example.parkingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.parkingapp.databinding.ActivityPaymentMethodBinding;
import java.util.ArrayList;
import java.util.List;

public class PaymentMethod extends AppCompatActivity implements itemCardClickListener {

    private ArrayList<AddCardContent> cardContents = new ArrayList<>();
    private AddCardAdapter cardAdapter;
    private ActivityPaymentMethodBinding paymentMethodBinding;
    private AddNewCardClickHandler clickHandler;
    private int selectedItemPosition = -1; // Track selected item position
    Button ButtonPayNow;
    ImageView backArrowPaymentMethod;

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
        cardAdapter.setClickListener(this);
        recyclerView.setAdapter(cardAdapter);







        AddCardModel cardModel = new ViewModelProvider(this).get(AddCardModel.class);
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                AddCardContent cardContent = cardContents.get(position);

                // Show confirmation dialog
                new AlertDialog.Builder(PaymentMethod.this)
                        .setTitle("Delete Card")
                        .setMessage("Are you sure you want to delete this card?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Delete the card
                                cardModel.deleteContent(cardContent);
                                cardContents.remove(position);
                                cardAdapter.notifyItemRemoved(position);
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Cancel the deletion and notify the adapter
                                cardAdapter.notifyItemChanged(position);
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        }).attachToRecyclerView(recyclerView);

        backArrowPaymentMethod = findViewById(R.id.backArrowPaymentMethod);
        backArrowPaymentMethod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaymentMethod.this, TermsAndConditions.class);
                startActivity(intent);
            }
        });

        ButtonPayNow = findViewById(R.id.ButtonPayNow);
        ButtonPayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPayNowDialog();
            }
        });

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

        setPayNowButtonEnabled(false); // Disable Pay Now button initially
    }

    private void setPayNowButtonEnabled(boolean enabled) {
        paymentMethodBinding.ButtonPayNow.setEnabled(enabled);
        paymentMethodBinding.ButtonPayNow.setAlpha(enabled ? 1.0f : 0.5f); // Adjust transparency for visual feedback
    }

    @Override
    public void onClick(View v, int position) {
        Log.d("PaymentMethod", "Item clicked at position: " + position);
        AddCardContent clickedCard = cardContents.get(position);
        Log.d("PaymentMethod", "Clicked card: " + clickedCard.getCardName());
        Toast.makeText(getApplicationContext(), "Clicked card: " + clickedCard.getCardName(), Toast.LENGTH_SHORT).show();

        selectedItemPosition = position; // Update selected item position
        setPayNowButtonEnabled(true); // Enable Pay Now button when an item is clicked
    }

    @Override
    protected void onResume() {
        super.onResume();
        setPayNowButtonEnabled(selectedItemPosition != -1); // Enable/disable button based on selection
    }

    private void showPayNowDialog() {

        Intent intent1 = getIntent();
        String timeDifference = intent1.getStringExtra("timeDifference");
        String selectedItem  = intent1.getStringExtra("selectedItem");

        // Inflate custom layout
        LayoutInflater inflater = LayoutInflater.from(this);
        View customDialogView = inflater.inflate(R.layout.dialog_custom, null);

        // Build the dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(customDialogView);

        AlertDialog dialog = builder.create();
        dialog.show();

        // Get buttons from the custom layout
        Button buttonYes = customDialogView.findViewById(R.id.dialogButtonYes);
        Button buttonNo = customDialogView.findViewById(R.id.dialogButtonNo);

        // Set click listeners for the buttons
        // Inside PaymentMethod activity
        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PaymentMethod.this, "Payment processing...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(PaymentMethod.this, MainHomePage.class);
                intent.putExtra("buttonYes", true);
                intent.putExtra("timeDifference",timeDifference);
                intent.putExtra("selectedItem",selectedItem);
                startActivity(intent);
                dialog.dismiss();
            }
        });

        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}
