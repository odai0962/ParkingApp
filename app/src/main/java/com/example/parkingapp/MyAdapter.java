package com.example.parkingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_ITEM = 0;
    private static final int VIEW_TYPE_FOOTER = 1;

    private List<ItemList> itemLists;
    private itemCarClickListener itemClickListener;

    public MyAdapter(List<ItemList> itemLists) {
        this.itemLists = itemLists;
    }

    public void setClickListener(itemCarClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.rv_item, parent, false);
            return new MyViewHolder(itemView);
        } else {
            View footerView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.rv_addicar, parent, false);
            return new FooterViewHolder(footerView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyViewHolder) {
            ItemList itemList = itemLists.get(position);
            ((MyViewHolder) holder).parkingNum.setText(Integer.toString(itemList.getSpaceCarNum()));
            ((MyViewHolder) holder).carmodeltext.setText(itemList.getCarModel());
        }
    }

    @Override
    public int getItemCount() {
        return itemLists.size() + 1; // Add 1 for the footer view
    }

    @Override
    public int getItemViewType(int position) {
        if (position < itemLists.size()) {
            return VIEW_TYPE_ITEM;
        } else {
            return VIEW_TYPE_FOOTER;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView carmodeltext;
        TextView parkingNum;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            carmodeltext = itemView.findViewById(R.id.carmodeltext);
            parkingNum = itemView.findViewById(R.id.parkingNum);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null) {
                itemClickListener.onClick(view, getAdapterPosition());
            }
        }
    }

    public class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
