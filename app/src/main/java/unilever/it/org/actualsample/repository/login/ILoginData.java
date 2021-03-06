package unilever.it.org.actualsample.repository.login;

import io.reactivex.Observable;
import unilever.it.org.actualsample.Data;

import unilever.it.org.actualsample.base.ServiceWrapper;

public interface ILoginData {
    Observable<ServiceWrapper<Data>> login (Object map);
}
