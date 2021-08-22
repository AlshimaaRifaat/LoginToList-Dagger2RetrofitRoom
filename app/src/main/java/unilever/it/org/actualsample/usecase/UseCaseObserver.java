package unilever.it.org.actualsample.usecase;

import io.reactivex.observers.DisposableObserver;

public abstract class  UseCaseObserver<T> extends DisposableObserver<T> {

    @Override
    public void onComplete() {
    }

    @Override
    public void onNext(T t) {

        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {

        onFailed(e.getMessage());
    }

    public abstract void onSuccess(T t);

    public abstract void onFailed(String errorModel);
}
