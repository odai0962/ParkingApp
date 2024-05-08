package com.example.parkingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ArrowImageAdapterB extends RecyclerView.Adapter<ArrowImageAdapterB.ArrowViewHolderB> {
    List<ArrowImageItemB> arrowlistB;

    public ArrowImageAdapterB(List<ArrowImageItemB> arrowlistB) {
        this.arrowlistB = arrowlistB;
    }

    @Override
    public void onBindViewHolder(@NonNull ArrowViewHolderB holder, int position) {
        ArrowImageItemB imageItemB = arrowlistB.get(position);
        holder.ArrowImageB.setImageResource(imageItemB.getArrowImageB());
    }

    @NonNull
    @Override
    public ArrowViewHolderB onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View arrowViewB = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.arrowimage_b,
                parent,
                false
        );
        return new ArrowImageAdapterB.ArrowViewHolderB(arrowViewB);
    }

    @Override
    public int getItemCount() {
        return arrowlistB.size();
    }

    public  class ArrowViewHolderB extends  RecyclerView.ViewHolder{
        ImageView ArrowImageB;
        public ArrowViewHolderB(@NonNull View itemView) {
            super(itemView);
            ArrowImageB = itemView.findViewById(R.id.arrowimageB);
        }
    }
}
