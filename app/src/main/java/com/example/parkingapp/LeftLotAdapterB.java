package com.example.parkingapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class LeftLotAdapterB extends RecyclerView.Adapter<LeftLotAdapterB.LeftViewHolderB> {
    List<leftListLotItemB> leftListB;
    LeftItemClickListenerB clickListenerB;
    RightLotAdapterB rightLotAdapterB;

    private int selectedPositionB = RecyclerView.NO_POSITION; // to keep track of the selected item position

    public void setLeftClickListenerB(LeftItemClickListenerB clickListenerB){
        this.clickListenerB = clickListenerB;
    }

    public LeftLotAdapterB(List<leftListLotItemB> leftListB) {
        this.leftListB = leftListB;
    }

    public void setRightLotAdapterB(RightLotAdapterB rightLotAdapterB) {
        this.rightLotAdapterB = rightLotAdapterB;
    }

    @NonNull
    @Override
    public LeftViewHolderB onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View LeftItemViewB = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.parkinglot_left_b,
                parent,
                false
        );
        return new LeftViewHolderB(LeftItemViewB);
    }

    @Override
    public void onBindViewHolder(@NonNull LeftViewHolderB holder, int position) {
        leftListLotItemB leftListItemB = leftListB.get(position);
        holder.LeftTextB.setText(leftListItemB.getParkingNumB());
        holder.LeftimageB.setImageResource(leftListItemB.getImageParkingLotB());

        // Set the visibility based on the selected position
        if (selectedPositionB == position) {
            holder.carSelectedLeftFrameB.setVisibility(View.VISIBLE);
        } else {
            holder.carSelectedLeftFrameB.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return leftListB.size();
    }

    public class LeftViewHolderB extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView LeftimageB;
        TextView LeftTextB;
        FrameLayout carSelectedLeftFrameB;

        public LeftViewHolderB(@NonNull View itemView) {
            super(itemView);
            LeftimageB = itemView.findViewById(R.id.imageLotLeftB);
            LeftTextB = itemView.findViewById(R.id.LeftTextB);
            carSelectedLeftFrameB = itemView.findViewById(R.id.carSelectedLeftFrameB); // Initialize FrameLayout

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int previousPositionB = selectedPositionB;
            selectedPositionB = getAdapterPosition();
            notifyItemChanged(previousPositionB); // Notify previous item to reset the visibility
            notifyItemChanged(selectedPositionB); // Notify the current item to change the visibility

            Log.d("LeftLotAdapterB", "onClick: Left item clicked");
            if (clickListenerB != null) {
                clickListenerB.LeftOnClickB(view, getAdapterPosition());
            }

            if (rightLotAdapterB != null) {
                rightLotAdapterB.resetSelectionB();
            }
        }

    }
    public void resetSelectionB() {
        int previousPositionB = selectedPositionB;
        selectedPositionB = RecyclerView.NO_POSITION;
        notifyItemChanged(previousPositionB);
    }
}