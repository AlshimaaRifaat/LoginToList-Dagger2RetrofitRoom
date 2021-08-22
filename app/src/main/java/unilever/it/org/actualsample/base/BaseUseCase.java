package unilever.it.org.actualsample.base;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

public abstract class BaseUseCase<T> {

    // CompositeDisposable (observable)mange multi request
    private final CompositeDisposable compositeDisposable;
    private final Scheduler executorThread;
    private final Scheduler uiThread;
    //private static final int LOADING_PATCH_THRESHOLD = 12;


    public BaseUseCase(Scheduler executorThread, Scheduler uiThread) {
        this.executorThread = executorThread;
        this.uiThread = uiThread;
        compositeDisposable = new CompositeDisposable();
    }

    //observer
    public void execute(DisposableObserver<T> disposableObserver, Object map) {
        if (disposableObserver == null) {
            throw new IllegalArgumentException("observer must not be null");
        }
        final Observable<T> observable =
                this.createObservableUseCase(map)
                        .subscribeOn(executorThread)
                        .observeOn(uiThread);
        DisposableObserver observer =
                observable
                        .subscribeWith(disposableObserver);
        compositeDisposable.add(observer);
    }

    public void clear() {
        compositeDisposable.clear();
    }

    protected abstract Observable<T> createObservableUseCase(Object map);

//    public int getLoadingPatchThreshold() {
//        return LOADING_PATCH_THRESHOLD;
//    }
}

