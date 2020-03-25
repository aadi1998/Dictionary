package com.example.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button insert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insert = (Button) findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openInsertActivity();
            }
        });
    }

    public void openInsertActivity(){
        Intent intent = new Intent(this, InsertWordActivity.class);
        startActivity(intent);
    }

}
