package by.mrkip.apps.epamandroidtraining.threads;

public interface OnResultCallback<Result, Progress> extends ProgressCallback<Progress> {

	void onSuccess(Result result);

	void onError(Exception e);
}
