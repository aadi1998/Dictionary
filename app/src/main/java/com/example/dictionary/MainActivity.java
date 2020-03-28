package com.example.dictionary;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<WordItem> myWordList;
    public static WordAdapter myAdapter;
    public RecyclerView myRecyclerView;
    public Button insert;
    public Button remove;
    public SearchView searchView;
    public RecyclerView.LayoutManager myLayoutManager;

    public static int arraySize() {
        return myWordList.size();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myWordList = new ArrayList<>();
        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

//                if (!searchView.isIconified()) {
//                    searchView.setIconified(true);
//                }
//                searchView.onActionViewCollapsed();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //                Run search query program by sending the query string to the search query class
//                search(newText);
                return false;
            }
        });
        createWordList();

        setButtons();

        buildRecyclerView();
    }


    public void removeItem(int position) {
        myWordList.remove(position);
        myAdapter.notifyItemRemoved(position);
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
        myAdapter.setOnItemClickListener(new WordAdapter.OnItemClickListener() {
            @Override
            public void onDeleteClick(int position) {
                removeItem(position);

            }
        });
    }

    public void setButtons() {
        //        instantiate the insert and remove buttons. Insert opens a new activity. Remove deletes a word
        insert = findViewById(R.id.insert);
//        remove = findViewById(R.id.delete);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInsertActivity();
            }
        });

    }

    public void openInsertActivity() {
        Intent intent = new Intent(this, InsertWordActivity.class);
        startActivity(intent);
    }

}
