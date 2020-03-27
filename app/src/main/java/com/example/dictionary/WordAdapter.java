package com.example.dictionary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {
    private ArrayList<WordItem> myWordList;

    public WordAdapter(ArrayList<WordItem> wordList) {

        myWordList = wordList;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_items, parent, false);
        WordViewHolder wvh = new WordViewHolder(v);
        return wvh;
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        WordItem currentItem = myWordList.get(position);

        holder.myTextView.setText(currentItem.getWord());
    }

    @Override
    public int getItemCount() {
        return myWordList.size();
    }

    public static class WordViewHolder extends RecyclerView.ViewHolder {
        public TextView myTextView;

        //public Button myButton;
        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.aWord);
//            myTextView = itemView.findViewById(R.id.delete);
        }
    }
}
