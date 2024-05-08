package com.example.parkingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ArrowImageAdapter extends RecyclerView.Adapter<ArrowImageAdapter.ArrowViewHolder> {
    List<ArrowImageItem> arrowlist;

    public ArrowImageAdapter(List<ArrowImageItem> arrowlist) {
        this.arrowlist = arrowlist;
    }

    @NonNull
    @Override
    public ArrowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View arrowView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.arrowimage,
                parent,
                false
        );
        return new ArrowViewHolder(arrowView);
    }

    @Override
    public void onBindViewHolder(@NonNull ArrowViewHolder holder, int position) {
        ArrowImageItem imageItem = arrowlist.get(position);
        holder.ArrowImage.setImageResource(imageItem.getArrowImage());
    }

    @Override
    public int getItemCount() {
        return arrowlist.size();
    }

    public class ArrowViewHolder extends RecyclerView.ViewHolder {
        ImageView ArrowImage;

        public ArrowViewHolder(@NonNull View itemView) {
            super(itemView);
            ArrowImage = itemView.findViewById(R.id.arrowimage);
        }
    }
}
