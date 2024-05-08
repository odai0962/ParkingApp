package com.example.parkingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ArrowImageAdapterC extends RecyclerView.Adapter<ArrowImageAdapterC.ArrowViewHolderC> {
    List<ArrowImageItemC> arrowlistC;

    public ArrowImageAdapterC(List<ArrowImageItemC> arrowlistC) {
        this.arrowlistC = arrowlistC;
    }

    @Override
    public void onBindViewHolder(@NonNull ArrowViewHolderC holder, int position) {
        ArrowImageItemC imageItemC = arrowlistC.get(position);
        holder.ArrowImageC.setImageResource(imageItemC.getArrowImageC());
    }

    @NonNull
    @Override
    public ArrowViewHolderC onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View arrowViewC = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.arrowimage_c,
                parent,
                false
        );
        return new ArrowImageAdapterC.ArrowViewHolderC(arrowViewC);
    }

    @Override
    public int getItemCount() {
        return arrowlistC.size();
    }

    public  class ArrowViewHolderC extends  RecyclerView.ViewHolder{
        ImageView ArrowImageC;
        public ArrowViewHolderC(@NonNull View itemView) {
            super(itemView);
            ArrowImageC = itemView.findViewById(R.id.arrowimageC);
        }
    }
}
