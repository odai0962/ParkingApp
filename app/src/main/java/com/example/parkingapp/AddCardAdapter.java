package com.example.parkingapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parkingapp.databinding.AddCardItemBinding;

import java.util.ArrayList;
public class AddCardAdapter extends RecyclerView.Adapter<AddCardAdapter.ContentViewHolder> {
    private ArrayList<AddCardContent> addCardContentArrayList;
    private itemCardClickListener clickListener;
    private int selectedItemPosition = -1;

    public void setClickListener(itemCardClickListener itemCardClickListener) {
        this.clickListener = itemCardClickListener;
    }

    public AddCardAdapter(ArrayList<AddCardContent> addCardContentArrayList) {
        this.addCardContentArrayList = addCardContentArrayList;
    }

    @Override
    public void onBindViewHolder(@NonNull ContentViewHolder holder, int position) {
        AddCardContent addCardContent = addCardContentArrayList.get(position);
        holder.bind(addCardContent, position);
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

        return new ContentViewHolder(cardItemBinding, clickListener);
    }

    @Override
    public int getItemCount() {
        return (addCardContentArrayList != null) ? addCardContentArrayList.size() : 0;
    }

    public void setAddCardContentArrayList(ArrayList<AddCardContent> addCardContentArrayList) {
        this.addCardContentArrayList = addCardContentArrayList;
        notifyDataSetChanged();
    }

    class ContentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final AddCardItemBinding itemBinding;
        private final itemCardClickListener clickListener;

        ContentViewHolder(@NonNull AddCardItemBinding itemBinding, itemCardClickListener clickListener) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
            this.clickListener = clickListener;
            itemBinding.getRoot().setOnClickListener(this);
        }

        void bind(AddCardContent addCardContent, int position) {
            itemBinding.setContent(addCardContent);
            if (selectedItemPosition == position) {
                itemBinding.checkedCard.setVisibility(View.VISIBLE);
            } else {
                itemBinding.checkedCard.setVisibility(View.GONE);
            }
            itemBinding.executePendingBindings(); // Ensure bindings are executed
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                notifyItemChanged(selectedItemPosition); // Hide previously selected item's checkedCard
                selectedItemPosition = position;
                notifyItemChanged(selectedItemPosition); // Show newly selected item's checkedCard
                if (clickListener != null) {
                    clickListener.onClick(view, position);
                }
            }
        }
    }
}
