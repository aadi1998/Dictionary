package com.example.dictionary;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<WordItem> myWordList;
    public static RecyclerView.Adapter myAdapter;
    private RecyclerView myRecyclerView;
    private Button insert;
    private RecyclerView.LayoutManager myLayoutManager;

    public static int arraySize() {
        return myWordList.size();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insert = findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInsertActivity();
            }
        });


        myWordList = new ArrayList<>();
        createWordList();
        buildRecyclerView();

    }

    public void createWordList() {
        myWordList.add(new WordItem("Andrianampoinimerina's"));
        myWordList.add(new WordItem("These"));
        myWordList.add(new WordItem("Those"));
    }

    public void buildRecyclerView() {
        myRecyclerView = findViewById(R.id.recyclerView);
        myRecyclerView.setHasFixedSize(true);
        myLayoutManager = new LinearLayoutManager(this);
        myAdapter = new WordAdapter(myWordList);

        myRecyclerView.setLayoutManager(myLayoutManager);
        myRecyclerView.setAdapter(myAdapter);
    }

    public void openInsertActivity() {
        Intent intent = new Intent(this, InsertWordActivity.class);
        startActivity(intent);
    }

}
