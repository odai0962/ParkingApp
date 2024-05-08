package com.example.parkingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LeftLotAdapterC extends RecyclerView.Adapter<LeftLotAdapterC.LeftViewHolderC> {
    List<leftListLotItemC> leftListC;

    public LeftItemClickListenerC leftItemClickListenerC;
    public  void setLeftItemClickListenerC(LeftItemClickListenerC leftItemClickListenerC){
        this.leftItemClickListenerC = leftItemClickListenerC;
    }
    public LeftLotAdapterC(List<leftListLotItemC> leftListC) {
        this.leftListC = leftListC;
    }

    @Override
    public void onBindViewHolder(@NonNull LeftViewHolderC holder, int position) {
        leftListLotItemC listLotItemC = leftListC.get(position);
        holder.LeftimageC.setImageResource(listLotItemC.getImageParkingLotC());
        holder.LeftTextC.setText(listLotItemC.getParkingNumC());
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
    public int getItemCount() {
        return leftListC.size();
    }

    public  class LeftViewHolderC extends RecyclerView.ViewHolder implements  View.OnClickListener{
        ImageView LeftimageC;
        TextView LeftTextC;
        public LeftViewHolderC(@NonNull View itemView) {
            super(itemView);
            LeftimageC = itemView.findViewById(R.id.imageLotLeftC);
            LeftTextC = itemView.findViewById(R.id.LeftTextC);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (leftItemClickListenerC != null){
                leftItemClickListenerC.LeftOnClickC(view,getAdapterPosition());
            }
        }
    }
}
