package by.mrkip.apps.epamandroidtraining;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import by.mrkip.backend.weather.myApi.MyApi;

/**
 * Created by kip on 13.10.2016.
 */

public class ApiManager {


	private static ApiManager sInstance;
	private static MyApi appEngineApi = null;

	public static ApiManager get() {
		if (sInstance == null) {
			sInstance = new ApiManager();
		}
		return sInstance;
	}

	private ApiManager() {
	}

	public MyApi trainingsApi() {
		if (appEngineApi == null) {
			MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
					.setRootUrl(BuildConfig.BACKEND_URL);
			appEngineApi = builder.build();
		}
		return appEngineApi;
	}
}
