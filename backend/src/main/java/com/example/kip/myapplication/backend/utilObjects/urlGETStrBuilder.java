package com.example.kip.myapplication.backend.utilObjects;

/**
 * Created by kip on 15.10.2016.
 */

public class urlGETStrBuilder {
	private static final String URL_PARAMS_SEPARATOR = "?";
	private static final String PARAMETER_SEPARATOR = "&";
	private static final String NAME_VALUE_SEPARATOR = "=";
	private String url;

	public urlGETStrBuilder(final String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public urlGETStrBuilder addParam(final String name, final String value) {
		if(url.contains(URL_PARAMS_SEPARATOR)){
			this.url=this.url+PARAMETER_SEPARATOR+name+NAME_VALUE_SEPARATOR+value;
		}else{
			this.url=this.url+URL_PARAMS_SEPARATOR+name+NAME_VALUE_SEPARATOR+value;
		}

		return this;
	}


}
