package com.example.testmanagedquery;

import android.os.Bundle;
import android.os.Debug;
import android.provider.MediaStore;
import android.app.Activity;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Cursor c = managedQuery(
				MediaStore.Images.Media.EXTERNAL_CONTENT_URI /* uri */,
				new String[]{"DISTINCT " + MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME} /* projection */ ,
				null /* selection */ ,
				null,
				null);
		
		c.moveToFirst();
		do {
			String bucketDisplayName = c.getString(c.getColumnIndex(MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME));
			Log.e("HOGEHOGE", "bucketDisplayName = " + bucketDisplayName);
		}while(c.moveToNext());
	}

}
