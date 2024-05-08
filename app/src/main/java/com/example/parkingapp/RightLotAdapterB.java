package com.example.parkingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RightLotAdapterB extends RecyclerView.Adapter<RightLotAdapterB.RightViewHolderB> {
    private List<RightListLotItemB> RightListB;

    public  RightItemClickListenerB rightClickListenerB ;
    public void  setRightClickListenerB(RightItemClickListenerB rightClickListenerB){
        this.rightClickListenerB = rightClickListenerB;
    }

    public RightLotAdapterB(List<RightListLotItemB> rightListB) {
        RightListB = rightListB;
    }

    @Override
    public void onBindViewHolder(@NonNull RightViewHolderB holder, int position) {
        RightListLotItemB rightListLotItemB = RightListB.get(position);
        holder.RightTextB.setText(rightListLotItemB.getParkingNumB());
        holder.RightImageB.setImageResource(rightListLotItemB.getImageParkingLotB());
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

    public class RightViewHolderB extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView RightImageB;
        TextView RightTextB;
        public RightViewHolderB(@NonNull View itemView) {
            super(itemView);
            RightImageB = itemView.findViewById(R.id.imageLotRightB);
            RightTextB = itemView.findViewById(R.id.RightTextB);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(rightClickListenerB != null){
                rightClickListenerB.RightOnClickB(view,getAdapterPosition());
            }
        }
    }
}
