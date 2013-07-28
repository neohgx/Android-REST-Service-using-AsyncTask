package com.neohg.restserviceasynctask;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView txtTime;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.txtTime = (TextView) findViewById(R.id.txtTime);

		// add a click event handler for the button
		
		final Button btnCallWebService = (Button) findViewById(R.id.btnCallWebService);
		btnCallWebService.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				CallWebServiceTask task = new CallWebServiceTask();
				task.textView = txtTime;
				task.applicationContext = MainActivity.this;
				task.execute();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
}
