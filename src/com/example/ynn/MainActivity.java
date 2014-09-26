package com.example.ynn;

import java.util.Random;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity {
	private Button choise;
	private Button Choose;
	int min = 1;
	int max = 100;
	Random r = new Random();
	int YnN = r.nextInt(max - min + 1) + min;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		choise= (Button) findViewById(R.id.button1);
		Choose= (Button) findViewById(R.id.button2);
		choise.setOnClickListener(new Button.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	if(YnN<=50)
            	{

            		setContentView(R.layout.yes);
            	}
            	else
            	{

            		setContentView(R.layout.no);
            	
            	}
            }         
        });     
		Choose.setOnClickListener(new Button.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	Intent intent = new Intent();
            	intent.setClass(MainActivity.this, ManyChoises.class);
            	startActivity(intent); 
            	MainActivity.this.finish(); 
            }         
        });    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
