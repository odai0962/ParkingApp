package com.example.parkingapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
public class LeftLotAdapter extends RecyclerView.Adapter<LeftLotAdapter.LeftViewHolder> {
    List<leftListLotItem> leftList;
    LeftItemClickListenerA clickListenerA;
    private int selectedPosition = RecyclerView.NO_POSITION; // to keep track of the selected item position

    public void setLeftClickListenerA(LeftItemClickListenerA clickListenerA){
        this.clickListenerA = clickListenerA;
    }

    public LeftLotAdapter(List<leftListLotItem> leftList) {
        this.leftList = leftList;
    }

    @NonNull
    @Override
    public LeftViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View LeftItemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.parkinglot_left,
                parent,
                false
        );
        return new LeftViewHolder(LeftItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LeftViewHolder holder, int position) {
        leftListLotItem leftListItem = leftList.get(position);
        holder.LeftText.setText(leftListItem.getParkingNum());
        holder.Leftimage.setImageResource(leftListItem.getImageParkingLot());

        // Set the visibility based on the selected position
        if (selectedPosition == position) {
            holder.carSelectedLeftFrame.setVisibility(View.VISIBLE);
        } else {
            holder.carSelectedLeftFrame.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return leftList.size();
    }

    public class LeftViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView Leftimage;
        TextView LeftText;
        FrameLayout carSelectedLeftFrame;

        public LeftViewHolder(@NonNull View itemView) {
            super(itemView);
            Leftimage = itemView.findViewById(R.id.imageLotLeft);
            LeftText = itemView.findViewById(R.id.LeftText);
            carSelectedLeftFrame = itemView.findViewById(R.id.carSelectedLeftFrame); // Initialize FrameLayout

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int previousPosition = selectedPosition;
            selectedPosition = getAdapterPosition();
            notifyItemChanged(previousPosition); // Notify previous item to reset the visibility
            notifyItemChanged(selectedPosition); // Notify the current item to change the visibility

            Log.d("LeftLotAdapter", "onClick: Left item clicked");
            if (clickListenerA != null) {
                clickListenerA.LeftOnClickA(view, getAdapterPosition());
            }
        }
    }
}
