package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.myapplication.MainActivity.check1;
import static com.example.myapplication.MainActivity.constraintLayout;


public class image_recycler_adapter extends RecyclerView.Adapter<image_recycler_adapter.image_cell_recycler_adapter_class> {
    class image_cell_recycler_adapter_class extends RecyclerView.ViewHolder {
        ImageView image_cell;
        TextView image_cell_title;

        image_cell_recycler_adapter_class(@NonNull View itemView) {
            super(itemView);
            image_cell = itemView.findViewById(R.id.image_cell);
            image_cell_title = itemView.findViewById(R.id.image_cell_title);
        }
    }

    private ArrayList<Image_Cell> personArrayList;
    private Activity activity;
    private ArrayList<MyCustomImage> addedImages;

    image_recycler_adapter(ArrayList<Image_Cell> personArrayList, Activity activity, CheckBox r) {
        this.personArrayList = personArrayList;
        this.activity = activity;
        addedImages = new ArrayList<>();
        r.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                for (int i = 0; i < addedImages.size(); i++) {
                    addedImages.get(i).minus.setAlpha(0);
                    addedImages.get(i).plus.setAlpha(0);
                    addedImages.get(i).turnImage.setAlpha(0);
                    addedImages.get(i).deleteImage.setAlpha(0);
                    check1 = isChecked;
                }
            } else {
                for (int i = 0; i < addedImages.size(); i++) {
                    addedImages.get(i).minus.setAlpha(255);
                    addedImages.get(i).plus.setAlpha(255);
                    addedImages.get(i).turnImage.setAlpha(255);
                    addedImages.get(i).deleteImage.setAlpha(255);
                    check1 = isChecked;
                }
            }
            System.out.println("asd" + isChecked);
        });
    }

    @NonNull
    @Override
    public image_cell_recycler_adapter_class onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_cell, parent, false);
        image_recycler_adapter.image_cell_recycler_adapter_class myAdapter = new image_cell_recycler_adapter_class(v);
        return myAdapter;
    }

    @Override
    public void onBindViewHolder(@NonNull final image_cell_recycler_adapter_class holder, int position) {
        holder.image_cell.setImageResource(personArrayList.get(position).imade_cell_id);
        holder.image_cell_title.setText(personArrayList.get(position).image_cell_title);
        holder.itemView.setOnClickListener(v -> {
            MyCustomImage img = new MyCustomImage(holder.itemView.getContext(), personArrayList.get(position).imade_cell_id, constraintLayout);
            addedImages.add(img);
        });
    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }

}