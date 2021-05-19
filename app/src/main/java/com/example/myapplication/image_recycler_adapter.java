package com.example.myapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static com.example.myapplication.MainActivity.constraintLayout;

//import static com.example.myapplication.MainActivity.constraintLayout;

public class image_recycler_adapter extends RecyclerView.Adapter<image_recycler_adapter.image_cell_recycler_adapter_class> {
    public class image_cell_recycler_adapter_class extends RecyclerView.ViewHolder {
        ImageView image_cell;
        TextView image_cell_title;

        public image_cell_recycler_adapter_class(@NonNull View itemView) {
            super(itemView);
            image_cell = itemView.findViewById(R.id.image_cell);
            image_cell_title = itemView.findViewById(R.id.image_cell_title);
        }
    }

    ArrayList<Image_Cell> personArrayList;
    Activity activity;

    public image_recycler_adapter(ArrayList<Image_Cell> personArrayList, Activity activity) {
        this.personArrayList = personArrayList;
        this.activity = activity;
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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                MyCustomImage img = new MyCustomImage(holder.itemView.getContext(), holder.image_cell.getId(), constraintLayout);
            }
        });
    }

    @Override
    public int getItemCount() {
        return personArrayList.size();
    }

   /* public class image_builder extends AppCompatActivity {
        ImageView img;

        //int img_id;
        // public image_builder(int img_id) {
        // this.img_id = img_id;
        //  }
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            System.out.println("weaewg");
            img = new ImageView(getApplicationContext());
            img.setImageResource(R.drawable.chines);
            img.setX(100);
            img.setY(100);
            constraintLayout.addView(img);
        }
    }*/
}