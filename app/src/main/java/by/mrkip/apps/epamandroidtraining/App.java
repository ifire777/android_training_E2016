package by.mrkip.apps.epamandroidtraining;

import android.app.Application;
import android.os.AsyncTask;

import by.mrkip.apps.epamandroidtraining.helpObjects.AppContextIns;
import by.mrkip.apps.epamandroidtraining.imageLoader.SimpleImageLoader;

public class App extends Application {

	private static SimpleImageLoader simpleImageLoader;

	public static SimpleImageLoader getSimpleImageLoader() {
		if (simpleImageLoader == null) {
		 	simpleImageLoader = SimpleImageLoader.Impl.newInstance();
		}
		return simpleImageLoader;
	}

	@Override
	public void onCreate() {
		super.onCreate();

		AsyncTask.SERIAL_EXECUTOR.execute(new Runnable() {

			@Override
			public void run() {
				//init libraries
			}
		});

		AppContextIns.set(this);

	}

	@Override
	public void unregisterActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
		super.unregisterActivityLifecycleCallbacks(callback);
	}
}