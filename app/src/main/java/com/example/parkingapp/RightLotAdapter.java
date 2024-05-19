package com.example.parkingapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RightLotAdapter extends RecyclerView.Adapter<RightLotAdapter.RightViewHolder> {
    private List<RightListLotItem> RightList;
    RightItemClickListenerA clickListenerA;

    private int selectedPosition = RecyclerView.NO_POSITION;

    public void setRightClickListenerA(RightItemClickListenerA clickListener){
      this.clickListenerA = clickListener;
    }



    public RightLotAdapter(List<RightListLotItem> rightList) {
        RightList = rightList;
    }

    @Override
    public void onBindViewHolder(@NonNull RightViewHolder holder, int position) {
       RightListLotItem rightListLotItem = RightList.get(position);
      holder.RightImage.setImageResource(rightListLotItem.getImageParkingLot());
      holder.RightText.setText(rightListLotItem.getParkingNum());

      if (selectedPosition == position){
          holder.carSelectedRightFrame.setVisibility(View.VISIBLE);
      }else {
          holder.carSelectedRightFrame.setVisibility(View.GONE);
      }

    }

    @NonNull
    @Override
    public RightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View RightItemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.parkinglot_right,
                parent,
                false
        );
        return new RightViewHolder(RightItemView);
    }

    @Override
    public int getItemCount() {
        return RightList.size();
    }





    public  class  RightViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
         ImageView RightImage;
         TextView RightText;
         FrameLayout carSelectedRightFrame;
        public RightViewHolder(@NonNull View itemView) {
            super(itemView);
            RightImage = itemView.findViewById(R.id.imageLotRight);
            RightText = itemView.findViewById(R.id.RightText);
            carSelectedRightFrame = itemView.findViewById(R.id.carSelectedRightFrame); // Initialize FrameLayout

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int previousPosition = selectedPosition;
                    selectedPosition = getAdapterPosition();
                    notifyItemChanged(previousPosition); // Notify previous item to reset the visibility
                    notifyItemChanged(selectedPosition); // Notify the current item to change the visibility
                    if (clickListenerA != null) {
                        clickListenerA.RightOnClickA(view, getAdapterPosition());
                    }
                }
            });

        }

        @Override
        public void onClick(View view) {
           if(clickListenerA != null){
               clickListenerA.RightOnClickA(view,getAdapterPosition());
           }
        }
    }
}
