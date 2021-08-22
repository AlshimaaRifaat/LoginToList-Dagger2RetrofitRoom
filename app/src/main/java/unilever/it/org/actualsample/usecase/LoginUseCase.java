package unilever.it.org.actualsample.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import unilever.it.org.actualsample.Data;

import unilever.it.org.actualsample.api.ServiceWrapper;
import unilever.it.org.actualsample.base.BaseUseCase;
import unilever.it.org.actualsample.repository.login.LoginDataSource;

public class LoginUseCase extends BaseUseCase<ServiceWrapper<Data>> {


    private final LoginDataSource loginRepository;

    @Inject
    public LoginUseCase(LoginDataSource loginRepository) {
        super(io.reactivex.schedulers.Schedulers.io(), AndroidSchedulers.mainThread());
        this.loginRepository=loginRepository;
    }

    @Override
    protected Observable<ServiceWrapper<Data>> createObservableUseCase(Object map) {
        return loginRepository.getData(map);
    }
}
