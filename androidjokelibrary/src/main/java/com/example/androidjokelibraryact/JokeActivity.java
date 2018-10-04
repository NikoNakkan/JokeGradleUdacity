package com.example.androidjokelibraryact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


//HERE WE TAKE THE STRING FROM THE HTTP RESPONSE.WE SET IT ONLY IF IT'S NOT NULL .THIS HELPS THE TEST FUNCTION AS WELL

public class JokeActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        setContentView(R.layout.joke_activity);
        if(intent.getStringExtra("Joke")!=null) {
            tv = findViewById(R.id.joke_text);
            tv.setText(intent.getStringExtra("Joke"));
        }

    }
}
