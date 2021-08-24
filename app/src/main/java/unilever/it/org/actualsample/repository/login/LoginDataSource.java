package unilever.it.org.actualsample.repository.login;

import javax.inject.Inject;

import io.reactivex.Observable;
import unilever.it.org.actualsample.Data;

import unilever.it.org.actualsample.base.ServiceWrapper;
import unilever.it.org.actualsample.base.Repository;

public class LoginDataSource extends Repository {


    private final LocalLoginData loginLocalDataSource;

    private final RemoteLoginData loginRemoteDataSource;

    @Inject
    public LoginDataSource(LocalLoginData loginLocalDataSource,
                           RemoteLoginData loginRemoteDataSource) {
        this.loginLocalDataSource = loginLocalDataSource;
        this.loginRemoteDataSource = loginRemoteDataSource;
    }

    @Override
    public Observable<ServiceWrapper<Data>> getData(Object dataFilter) {
        return loginRemoteDataSource.login(dataFilter);

    }
}
