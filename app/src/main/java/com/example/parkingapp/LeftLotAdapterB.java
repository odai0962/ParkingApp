package com.example.parkingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LeftLotAdapterB extends RecyclerView.Adapter<LeftLotAdapterB.LeftViewHolderB> {
    List<leftListLotItemB> leftListB;

    public  LeftItemClickListenerB leftClickListenerB;
    public  void  setLeftClickListenerB(LeftItemClickListenerB leftClickListenerB){
        this.leftClickListenerB= leftClickListenerB;
    }

    public LeftLotAdapterB(List<leftListLotItemB> leftListB) {
        this.leftListB = leftListB;
    }

    @Override
    public void onBindViewHolder(@NonNull LeftViewHolderB holder, int position) {
       leftListLotItemB listLotItemB = leftListB.get(position);
       holder.LeftimageB.setImageResource(listLotItemB.getImageParkingLotB());
       holder.LeftTextB.setText(listLotItemB.getParkingNumB());
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
    public int getItemCount() {
        return leftListB.size();
    }

    public  class LeftViewHolderB extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView LeftimageB;
        TextView LeftTextB;
        public LeftViewHolderB(@NonNull View itemView) {
            super(itemView);
            LeftimageB = itemView.findViewById(R.id.imageLotLeftB);
            LeftTextB = itemView.findViewById(R.id.LeftTextB);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(leftClickListenerB != null){
                leftClickListenerB.LeftOnClickB(view,getAdapterPosition());
            }
        }
    }
}
