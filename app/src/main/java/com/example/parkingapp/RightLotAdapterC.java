package com.example.parkingapp;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RightLotAdapterC extends RecyclerView.Adapter<RightLotAdapterC.RightViewHolderC> {
    private List<RightListLotItemC> RightListC;

    public RightItemClickListenerC rightClickListenerC;
    public void setRightClickListenerC(RightItemClickListenerC rightClickListenerC){
        this.rightClickListenerC = rightClickListenerC;
    }

    public RightLotAdapterC(List<RightListLotItemC> rightListC) {
        RightListC = rightListC;
    }

    @Override
    public void onBindViewHolder(@NonNull RightViewHolderC holder, int position) {
        RightListLotItemC rightListLotItemC = RightListC.get(position);
        holder.RightTextC.setText(rightListLotItemC.getParkingNumC());
        holder.RightImageC.setImageResource(rightListLotItemC.getImageParkingLotC());
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

    public class RightViewHolderC extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView RightImageC;
        TextView RightTextC;
        public RightViewHolderC(@NonNull View itemView) {
            super(itemView);
            RightImageC = itemView.findViewById(R.id.imageLotRightC);
            RightTextC = itemView.findViewById(R.id.RightTextC);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(rightClickListenerC != null){
                rightClickListenerC.RightOnClickC(view,getAdapterPosition());
            }
        }
    }
}
