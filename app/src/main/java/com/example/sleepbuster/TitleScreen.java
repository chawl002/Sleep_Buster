package com.example.sleepbuster;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.Random;


class TitleScreen extends ActionBarActivity implements
OnClickListener, OnInitListener
{

    private TextToSpeech tts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);


        tts = new TextToSpeech(this, this);
        findViewById(R.id.button1.setOnClickListener(this));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.title_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
            public void onClick(View v) {
            if( tts != null) {
                String text =
                        (( EditText) findViewById( R.id.editText1)).getText().toString();
                if( text != null ) {
                    if( (!tts.isSpeaking()) {
                        tts.speak( text, TextToSpeech.QUEUE_FLUSH, null);
                    }
                }
            }
        }


    @Override
    protected void onDestroy() {
        if( tts != null ) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    public void Questions(View v) {
        while (true){
            new CountDownTimer(2000, 1000) {

                String question;
                int ans;
                public void onTick(long millisUntilFinished) {
                    Random rand = new Random();
                    // nextInt is normally exclusive of the top value,
                    // so add 1 to make it inclusive
                    int num1 = rand.nextInt((100) + 1);
                    int num2 = rand.nextInt((100) + 1);

                    question = String.format("What is %d plus %d", num1, num2);
                    ans = num1 + num2;
                }

                public void onFinish() {
                    Intent answers = new Intent(getBaseContext(), Answers.class); //what is getBasedContext
                    answers.putExtra("ans", ans);
                    startActivity(answers);

                }
            }.start();

        }
    }

}