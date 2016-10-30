package by.mrkip.apps.epamandroidtraining.util;

import android.content.Context;

/**
 * Use <tt><AppContextIns></tt>
 */
@Deprecated
public final class ContextHolder {

	private static ContextHolder sContextHolder;

	private Context mContext;

	private ContextHolder() {

	}

	public static ContextHolder getInstance() {
		if (sContextHolder == null) {
			sContextHolder = new ContextHolder();
		}

		return sContextHolder;
	}

	public Context getContext() {
		return mContext;
	}

	public void setContext(final Context pContext) {
		mContext = pContext;
	}
}
