package by.mrkip.apps.epamandroidtraining;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import by.mrkip.backend.weather.myApi.MyApi;

/**
 * Created by kip on 13.10.2016.
 */

public class ApiManager {

	public static final String APP_ENGINE_BASE_URL = "http://10.0.2.2:8080/_ah/api/";

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
					.setRootUrl("https://weatherhistorybackup.appspot.com/_ah/api/");
			appEngineApi = builder.build();
		}
		return appEngineApi;
	}
}
