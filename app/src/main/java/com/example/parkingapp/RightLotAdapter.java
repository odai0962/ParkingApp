package com.example.parkingapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RightLotAdapter extends RecyclerView.Adapter<RightLotAdapter.RightViewHolder> {
    private List<RightListLotItem> RightList;



    RightItemClickListenerA clickListenerA;
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
        public RightViewHolder(@NonNull View itemView) {
            super(itemView);
            RightImage = itemView.findViewById(R.id.imageLotRight);
            RightText = itemView.findViewById(R.id.RightText);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
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
