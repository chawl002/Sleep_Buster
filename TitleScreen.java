package com.example.sleep_buster;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.util.Random;

public class TitleScreen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);
        
        Button start1 = (Button)findViewById(R.id.start1);
        Button end1 = (Button)findViewById(R.id.end1);
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
    /*Hnin's code*/
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
                    Intent answers = new Intent(getBaseContext(), MainQuestionActivity.class); //what is getBasedContext
                    answers.putExtra("ans", ans);
                    startActivity(answers);
 
                }
            }.start();
        }
    }
            /*Hnin's code end*/
    
/* public void toquestions(View view)//to next activity
    {
        Intent intent = new Intent(this, AskQuestionsTest.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }*/
}
    

