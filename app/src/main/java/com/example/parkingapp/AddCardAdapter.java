package com.example.parkingapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkingapp.databinding.AddCardItemBinding;

import java.util.ArrayList;

public class AddCardAdapter extends RecyclerView.Adapter<AddCardAdapter.ContentViewHolder> {
    private ArrayList<AddCardContent> addCardContentArrayList;

    public AddCardAdapter(ArrayList<AddCardContent> addCardContentArrayList) {
        this.addCardContentArrayList = addCardContentArrayList;
    }

    @Override
    public void onBindViewHolder(@NonNull ContentViewHolder holder, int position) {
        AddCardContent addCardContent = addCardContentArrayList.get(position);
        holder.itemBinding.setContent(addCardContent);
        holder.itemBinding.executePendingBindings(); // Ensure bindings are executed
    }

    @NonNull
    @Override
    public ContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AddCardItemBinding cardItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.add_card_item,
                parent,
                false
        );
        return new ContentViewHolder(cardItemBinding);
    }

    @Override
    public int getItemCount() {
        return (addCardContentArrayList != null) ? addCardContentArrayList.size() : 0;
    }

    public void setAddCardContentArrayList(ArrayList<AddCardContent> addCardContentArrayList) {
        this.addCardContentArrayList = addCardContentArrayList;
        notifyDataSetChanged();
    }

    static class ContentViewHolder extends RecyclerView.ViewHolder {
        private final AddCardItemBinding itemBinding;

        public ContentViewHolder(@NonNull AddCardItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }
}
