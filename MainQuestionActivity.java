package com.example.sleep_buster;

import java.util.Random;

import android.R;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainQuestionActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_question);
		/* Hnin's code*/
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
	        }
	}
	/*Hnin's code end*/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_question, menu);
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
}
