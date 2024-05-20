package com.example.parkingapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RightLotAdapterB extends RecyclerView.Adapter<RightLotAdapterB.RightViewHolderB> {
    private List<RightListLotItemB> RightListB;
    RightItemClickListenerB clickListenerB;
    LeftLotAdapterB leftLotAdapterB;
    private int selectedPositionB = RecyclerView.NO_POSITION;

    public void setRightClickListenerB(RightItemClickListenerB clickListenerB){
        this.clickListenerB = clickListenerB;
    }
    public void setLeftLotAdapterB(LeftLotAdapterB leftLotAdapterB) {
        this.leftLotAdapterB = leftLotAdapterB;
    }


    public RightLotAdapterB(List<RightListLotItemB> rightListB) {
        RightListB = rightListB;
    }

    @Override
    public void onBindViewHolder(@NonNull RightViewHolderB holder, int position) {
        RightListLotItemB rightListLotItemB = RightListB.get(position);
        holder.RightImageB.setImageResource(rightListLotItemB.getImageParkingLotB());
        holder.RightTextB.setText(rightListLotItemB.getParkingNumB());

        if (selectedPositionB == position){
            holder.carSelectedRightFrameB.setVisibility(View.VISIBLE);
        }else {
            holder.carSelectedRightFrameB.setVisibility(View.GONE);
        }

    }

    @NonNull
    @Override
    public RightViewHolderB onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View RightItemViewB = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.parkinglot_right_b,
                parent,
                false
        );
        return new RightViewHolderB(RightItemViewB);
    }

    @Override
    public int getItemCount() {
        return RightListB.size();
    }





    public  class  RightViewHolderB extends  RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView RightImageB;
        TextView RightTextB;
        FrameLayout carSelectedRightFrameB;
        public RightViewHolderB(@NonNull View itemView) {
            super(itemView);
            RightImageB = itemView.findViewById(R.id.imageLotRightB);
            RightTextB = itemView.findViewById(R.id.RightTextB);
            carSelectedRightFrameB = itemView.findViewById(R.id.carSelectedRightFrameB); // Initialize FrameLayout

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int previousPositionB = selectedPositionB;
                    selectedPositionB = getAdapterPosition();
                    notifyItemChanged(previousPositionB); // Notify previous item to reset the visibility
                    notifyItemChanged(selectedPositionB); // Notify the current item to change the visibility

                    Log.d("RightLotAdapterB", "onClick: Right item clicked");
                    if (clickListenerB != null) {
                        clickListenerB.RightOnClickB(view, getAdapterPosition());
                    }

                    if (leftLotAdapterB != null) {
                        leftLotAdapterB.resetSelectionB();
                    }

                }
            });

        }

        @Override
        public void onClick(View view) {
            if(clickListenerB != null){
                clickListenerB.RightOnClickB(view,getAdapterPosition());
            }
        }
    }
    public void resetSelectionB() {
        int previousPositionB = selectedPositionB;
        selectedPositionB = RecyclerView.NO_POSITION;
        notifyItemChanged(previousPositionB);
    }
}