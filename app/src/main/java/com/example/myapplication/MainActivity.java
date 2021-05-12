package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Image_Cell> personArrayList = new ArrayList<>();
    RecyclerView cell;
    ImageView image;
    static ConstraintLayout constraintLayout;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = new ImageView(getApplicationContext());
        cell = findViewById(R.id.cell);
        constraintLayout = findViewById(R.id.constraintlayout);
        String name_array_cell[] = {"СКАМЕЙКА","ДЕРЕВО","УРНА","ТРОТУАР","КАЧЕЛИ"};
        int id_array_cell[] = {R.drawable.bench_top, R.drawable.tree_top, R.drawable.rab_top, R.drawable.pavement, R.drawable.swing};
        for (int i = 0; i < 5; i++) {
            personArrayList.add(new Image_Cell(id_array_cell[i], name_array_cell[i]));
        }
        image_recycler_adapter adapter = new image_recycler_adapter(personArrayList, this);
        layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL, false);
        cell.setLayoutManager(layoutManager);
        cell.setAdapter(adapter);
    }
}
