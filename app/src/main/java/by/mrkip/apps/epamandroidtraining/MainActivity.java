package by.mrkip.apps.epamandroidtraining;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import by.mrkip.apps.epamandroidtraining.util.SharedPrefManager;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
	public static final String STATUS = "status";

	private String msg = "MyAppLogTag";
	private TextView tv;
	private RelativeLayout cl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		String i = new SharedPrefManager("appStoreg", this).getStringParam(STATUS);


		cl = (RelativeLayout) findViewById(R.id.content_main);
		FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
		tv = (TextView) findViewById(R.id.mm_txView);

		cl.setOnTouchListener(this);
		// tv.setOnTouchListener(this);

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}


	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// Log.d(msg, " event_UP");
		tv.setX(event.getX());
		tv.setY(event.getY());
		return true;

	}


	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		tv.setX(savedInstanceState.getFloat("tv_X"));
		tv.setY(savedInstanceState.getFloat("tv_Y"));
	}


	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putFloat("tv_X", tv.getY());
		outState.putFloat("tv_Y", tv.getX());
	}

	protected class mDragManager implements View.OnDragListener {


		public mDragManager() {
			Log.d(msg, "ACTION_DROP event1");
		}


		@Override
		public boolean onDrag(View v, DragEvent event) {
			return false;
		}
	}
}

