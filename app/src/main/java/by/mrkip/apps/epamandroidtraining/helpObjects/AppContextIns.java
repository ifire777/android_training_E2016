package by.mrkip.apps.epamandroidtraining.helpObjects;

import android.content.Context;


public enum AppContextIns {

	INSTANCE;

	private Context mContext;

	/*public Context getContext() {
		return mContext;
	}

	public void setContext(final Context pContext) {
		mContext = pContext;
	}
*/
	public static Context get() {
		return INSTANCE.mContext;
	}

	public static void set(final Context pContext) {
		INSTANCE.mContext = pContext;
	}
}
