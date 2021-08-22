package unilever.it.org.actualsample;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Streaming;
import unilever.it.org.actualsample.api.ServiceWrapper;

public interface RetrofitPostAPI {

  /*  @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @Streaming
    @POST("webservice/user/login")
    Observable<ServiceWrapper<Merchandiser>> userLogin(@Body User objUser);*/

    @POST("/api/login")
    Observable<ServiceWrapper<Data>> userLogin(@Body User objUser);
}
