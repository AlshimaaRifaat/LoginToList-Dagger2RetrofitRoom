package unilever.it.org.actualsample.repository.login;

import javax.inject.Inject;

import io.reactivex.Observable;
import unilever.it.org.actualsample.Data;

import unilever.it.org.actualsample.base.ServiceWrapper;
import unilever.it.org.actualsample.base.LocalDataSourece;

public class LocalLoginData extends LocalDataSourece<Data> implements ILoginData {

    @Inject
    public LocalLoginData() {
    }

    @Override
    public Observable<ServiceWrapper<Data>> login(Object map) {
        Data salesman = new Data();

        return Observable.just(simulateORMToRX(salesman));
    }
}