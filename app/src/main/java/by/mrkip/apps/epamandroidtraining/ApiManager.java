package by.mrkip.apps.epamandroidtraining;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.io.IOException;

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
			MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
					JacksonFactory.getDefaultInstance(), null)
					.setApplicationName(BuildConfig.APPLICATION_ID)
					.setRootUrl(APP_ENGINE_BASE_URL)
					.setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
						@Override
						public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
							abstractGoogleClientRequest.setDisableGZipContent(true);
						}
					});
			appEngineApi = builder.build();
		}
		return appEngineApi;
	}
}
