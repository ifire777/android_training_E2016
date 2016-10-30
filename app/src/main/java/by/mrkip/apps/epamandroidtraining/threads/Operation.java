package by.mrkip.apps.epamandroidtraining.threads;

public interface Operation<Params,Progress,Result> {
	Result doing(Params params, ProgressCallback<Progress> progressCallback) throws Exception;
}
