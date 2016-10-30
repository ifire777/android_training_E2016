package by.mrkip.apps.epamandroidtraining.threads;


import by.mrkip.apps.epamandroidtraining.threads.operations.WorkerOperation;

public interface OnResultCallbackObject {
	void onSuccess(WorkerOperation.Result result);

	void onError(Exception e);
}
