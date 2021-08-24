package unilever.it.org.actualsample.api;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;
import unilever.it.org.actualsample.Data;
import unilever.it.org.actualsample.database.User;
import unilever.it.org.actualsample.base.ServiceWrapper;

public interface RetrofitPostAPI {

  /*  @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @Streaming
    @POST("webservice/user/login")
    Observable<ServiceWrapper<Merchandiser>> userLogin(@Body User objUser);*/

    @POST("/api/login")
    Observable<ServiceWrapper<Data>> userLogin(@Body User objUser);
}
