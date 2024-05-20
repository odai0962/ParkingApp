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
public class LeftLotAdapterC extends RecyclerView.Adapter<LeftLotAdapterC.LeftViewHolderC> {
    List<leftListLotItemC> leftListC;
    LeftItemClickListenerC clickListenerC;
    RightLotAdapterC rightLotAdapterC;

    private int selectedPositionC = RecyclerView.NO_POSITION; // to keep track of the selected item position

    public void setLeftClickListenerC(LeftItemClickListenerC clickListenerC){
        this.clickListenerC = clickListenerC;
    }

    public LeftLotAdapterC(List<leftListLotItemC> leftListC) {
        this.leftListC = leftListC;
    }

    public void setRightLotAdapterC(RightLotAdapterC rightLotAdapterC) {
        this.rightLotAdapterC = rightLotAdapterC;
    }

    @NonNull
    @Override
    public LeftViewHolderC onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View LeftItemViewC = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.parkinglot_left_c,
                parent,
                false
        );
        return new LeftViewHolderC(LeftItemViewC);
    }

    @Override
    public void onBindViewHolder(@NonNull LeftViewHolderC holder, int position) {
        leftListLotItemC leftListItemC = leftListC.get(position);
        holder.LeftTextC.setText(leftListItemC.getParkingNumC());
        holder.LeftimageC.setImageResource(leftListItemC.getImageParkingLotC());

        // Set the visibility based on the selected position
        if (selectedPositionC == position) {
            holder.carSelectedLeftFrameC.setVisibility(View.VISIBLE);
        } else {
            holder.carSelectedLeftFrameC.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return leftListC.size();
    }

    public class LeftViewHolderC extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView LeftimageC;
        TextView LeftTextC;
        FrameLayout carSelectedLeftFrameC;

        public LeftViewHolderC(@NonNull View itemView) {
            super(itemView);
            LeftimageC = itemView.findViewById(R.id.imageLotLeftC);
            LeftTextC = itemView.findViewById(R.id.LeftTextC);
            carSelectedLeftFrameC = itemView.findViewById(R.id.carSelectedLeftFrameC); // Initialize FrameLayout

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int previousPositionC = selectedPositionC;
            selectedPositionC = getAdapterPosition();
            notifyItemChanged(previousPositionC); // Notify previous item to reset the visibility
            notifyItemChanged(selectedPositionC); // Notify the current item to change the visibility

            Log.d("LeftLotAdapterC", "onClick: Left item clicked");
            if (clickListenerC != null) {
                clickListenerC.LeftOnClickC(view, getAdapterPosition());
            }

            if (rightLotAdapterC != null) {
                rightLotAdapterC.resetSelectionC();
            }
        }

    }
    public void resetSelectionC() {
        int previousPositionC = selectedPositionC;
        selectedPositionC = RecyclerView.NO_POSITION;
        notifyItemChanged(previousPositionC);
    }
}