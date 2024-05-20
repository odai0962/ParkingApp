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

public class RightLotAdapterC extends RecyclerView.Adapter<RightLotAdapterC.RightViewHolderC> {
    private List<RightListLotItemC> RightListC;
    RightItemClickListenerC clickListenerC;
    LeftLotAdapterC leftLotAdapterC;
    private int selectedPositionC = RecyclerView.NO_POSITION;

    public void setRightClickListenerC(RightItemClickListenerC clickListenerC){
        this.clickListenerC = clickListenerC;
    }
    public void setLeftLotAdapterC(LeftLotAdapterC leftLotAdapterC) {
        this.leftLotAdapterC = leftLotAdapterC;
    }


    public RightLotAdapterC(List<RightListLotItemC> rightListC) {
        RightListC = rightListC;
    }

    @Override
    public void onBindViewHolder(@NonNull RightViewHolderC holder, int position) {
        RightListLotItemC rightListLotItemC = RightListC.get(position);
        holder.RightImageC.setImageResource(rightListLotItemC.getImageParkingLotC());
        holder.RightTextC.setText(rightListLotItemC.getParkingNumC());

        if (selectedPositionC == position){
            holder.carSelectedRightFrameC.setVisibility(View.VISIBLE);
        }else {
            holder.carSelectedRightFrameC.setVisibility(View.GONE);
        }

    }

    @NonNull
    @Override
    public RightViewHolderC onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View RightItemViewC = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.parkinglot_right_c,
                parent,
                false
        );
        return new RightViewHolderC(RightItemViewC);
    }

    @Override
    public int getItemCount() {
        return RightListC.size();
    }





    public  class  RightViewHolderC extends  RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView RightImageC;
        TextView RightTextC;
        FrameLayout carSelectedRightFrameC;
        public RightViewHolderC(@NonNull View itemView) {
            super(itemView);
            RightImageC = itemView.findViewById(R.id.imageLotRightC);
            RightTextC = itemView.findViewById(R.id.RightTextC);
            carSelectedRightFrameC = itemView.findViewById(R.id.carSelectedRightFrameC); // Initialize FrameLayout

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int previousPositionC = selectedPositionC;
                    selectedPositionC = getAdapterPosition();
                    notifyItemChanged(previousPositionC); // Notify previous item to reset the visibility
                    notifyItemChanged(selectedPositionC); // Notify the current item to change the visibility

                    Log.d("RightLotAdapterC", "onClick: Right item clicked");
                    if (clickListenerC != null) {
                        clickListenerC.RightOnClickC(view, getAdapterPosition());
                    }

                    if (leftLotAdapterC != null) {
                        leftLotAdapterC.resetSelectionC();
                    }

                }
            });

        }

        @Override
        public void onClick(View view) {
            if(clickListenerC != null){
                clickListenerC.RightOnClickC(view,getAdapterPosition());
            }
        }
    }
    public void resetSelectionC() {
        int previousPositionC = selectedPositionC;
        selectedPositionC = RecyclerView.NO_POSITION;
        notifyItemChanged(previousPositionC);
    }
}