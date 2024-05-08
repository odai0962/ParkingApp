package com.example.parkingapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LeftLotAdapter extends RecyclerView.Adapter<LeftLotAdapter.LeftViewHolder> {
        List<leftListLotItem> leftList;

        LeftItemClickListenerA clickListenerA;
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
    public void onBindViewHolder(@NonNull LeftViewHolder holder, int position ) {
       leftListLotItem leftListItem = leftList.get(position);
       holder.LeftText.setText(leftListItem.getParkingNum());
       holder.Leftimage.setImageResource(leftListItem.getImageParkingLot());
    }

    @Override
    public int getItemCount() {
        return leftList.size();
    }



    public   class  LeftViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView Leftimage;
        TextView LeftText;

        public LeftViewHolder(@NonNull View itemView ) {
            super(itemView);

            Leftimage = itemView.findViewById(R.id.imageLotLeft);
            LeftText = itemView.findViewById(R.id.LeftText);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (clickListenerA != null) {
                        clickListenerA.LeftOnClickA(view, getAdapterPosition());
                    }
                }
            });


        }

        @Override
        public void onClick(View view) {
            Log.d("LeftLotAdapter", "onClick: Left item clicked");
            if(clickListenerA != null){
                clickListenerA.LeftOnClickA(view,getAdapterPosition());
            }
        }
    }
}
