package com.example.sleepbuster;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import java.util.Random;

/**
 * Created by Hnin on 10/25/2014.
 */
public class Answers extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.answer);
        Button t = (Button) findViewById(R.id.correct); //TRUE button
        Button f = (Button) findViewById(R.id.wrong); //FALSE button

        //get the correct answer passed through
        Bundle extras = getIntent().getExtras();
        String corr_val = extras.getString("ans");

        Random rand = new Random();
        int wrong_val = rand.nextInt((200) + 1); //a random wrong answer
        int index = (rand.nextInt((100)+1)) % 2;
        int[] choices = new int[]{Integer.parseInt(corr_val), wrong_val};

        //ask question
        String t_or_f = String.format("Is the answer %d", choices[index]);
        // text to speech

        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}