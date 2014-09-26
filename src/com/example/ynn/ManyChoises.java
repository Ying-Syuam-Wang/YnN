package com.example.ynn;

import java.util.Random;


import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

public class ManyChoises extends Activity {
	private Button Choose;
	private Spinner many_choises;
	private TextView Show_ThoOne;
	private String[] list = {"3","4","5","6","7","8","9","10"};
    private ArrayAdapter<String> listAdapter;
    
	int min = 1;
	int max = 1;
	Random r = new Random();
	string pick;
	int TheOne=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.many_choises);
		many_choises= (Spinner) findViewById(R.id.spinner1);
		Choose= (Button) findViewById(R.id.button3);
		listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
		many_choises.setAdapter(listAdapter);
		
		many_choises.setOnItemSelectedListener(new OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> arg0, View arg1,int position, long arg3) {
            	max=position+3;
        }
            public void onNothingSelected(AdapterView<?> arg0) {
               // TODO Auto-generated method stub
            }
        });
		Choose.setOnClickListener(new Button.OnClickListener(){ 
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
            	TheOne= r.nextInt(max - min + 1) + min;
            	setContentView(R.layout.the_one);
        		Show_ThoOne= (TextView) findViewById(R.id.textView1);
            	Show_ThoOne.setText(String.valueOf(TheOne));
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
