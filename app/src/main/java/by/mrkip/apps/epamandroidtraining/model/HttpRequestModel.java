package by.mrkip.apps.epamandroidtraining.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class HttpRequestModel {
	private String url;

	private Map<String, String> headers;

	private String body;


	public void setUrl(String url) {
		this.url = url;
	}

	public HttpRequestModel addHeaders(String key, String value) {
		if (this.headers == null) {
			this.headers = new ConcurrentHashMap<String, String>();
		}
		this.headers.put(key, value);
		return this;
	}



	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getUrl() {
		return url;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public String getBody() {
		return body;
	}
}
