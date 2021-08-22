package unilever.it.org.actualsample.repository.login;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import unilever.it.org.actualsample.Data;

import unilever.it.org.actualsample.RetrofitPostAPI;
import unilever.it.org.actualsample.User;
import unilever.it.org.actualsample.api.ServiceWrapper;

public class RemoteLoginData implements ILoginData {

    @Inject
    Retrofit retrofit;

    @Inject
    public RemoteLoginData(){

    }


    @Override
    public Observable<ServiceWrapper<Data>> login(Object map) {
        return retrofit.create(RetrofitPostAPI.class).userLogin((User) map);
    }
}
