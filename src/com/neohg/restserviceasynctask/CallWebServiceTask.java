package com.neohg.restserviceasynctask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

public class CallWebServiceTask extends AsyncTask<Void, Void, String> {
	private ProgressDialog dialog;
	protected Context applicationContext;
	protected TextView textView;

	@Override
	protected void onPreExecute() {
		this.dialog = ProgressDialog.show(applicationContext, "Calling", "Time Service...", true);
	}

	@Override
	protected String doInBackground(Void... params) {

		return Start.getTimeStampFromYahooService();

	}

	@Override
	protected void onPostExecute(String result) {
		this.dialog.cancel();
		String timestamp = Start.parseJSONResponse(result);
		timestamp = Start.UnixTimeStampToDateTime(timestamp);
		textView.setText(timestamp);
	}
}
