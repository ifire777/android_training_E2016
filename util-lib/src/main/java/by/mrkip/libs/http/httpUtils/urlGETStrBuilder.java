package by.mrkip.libs.http.httpUtils;

public class urlGETStrBuilder {
	private static final String URL_PARAMS_SEPARATOR = "?";
	private static final String PARAMETER_SEPARATOR = "&";
	private static final String NAME_VALUE_SEPARATOR = "=";
	private String url;

	public urlGETStrBuilder( final String url) {
		if(url!=null) {
			this.url = url;
		}
	}

	public String getUrl() {
		return url;
	}

	public urlGETStrBuilder addParam( final String name, final String value) {
		if (name!=null && value!=null) {
			if (url.contains(URL_PARAMS_SEPARATOR)) {
				this.url = this.url + PARAMETER_SEPARATOR + name + NAME_VALUE_SEPARATOR + value;
			} else {
				this.url = this.url + URL_PARAMS_SEPARATOR + name + NAME_VALUE_SEPARATOR + value;
			}
		}
		return this;
	}


}
