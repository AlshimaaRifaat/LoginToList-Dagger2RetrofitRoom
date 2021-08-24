package unilever.it.org.actualsample.repository.list;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import unilever.it.org.actualsample.DAOs.ProductDao;
import unilever.it.org.actualsample.Data;
import unilever.it.org.actualsample.base.Repository;
import unilever.it.org.actualsample.base.ServiceWrapper;
import unilever.it.org.actualsample.database.DataHolderDTO;
import unilever.it.org.actualsample.database.Product;
import unilever.it.org.actualsample.repository.login.LocalLoginData;
import unilever.it.org.actualsample.repository.login.RemoteLoginData;

public class ProductDataSource  {

    private  LocalProductData localProductData;

    @Inject
    public ProductDataSource(LocalProductData localProductData) {
        this.localProductData = localProductData;
    }



    public Observable<ServiceWrapper<DataHolderDTO<Product>>> getData(Object dataFilter) {
        return localProductData.findAll(dataFilter);
    }
    public Observable<ServiceWrapper<DataHolderDTO<Product>>> searchByTitle(Object dataFilter) {
        return localProductData.searchByTitle((String) dataFilter);
    }

    public Observable<ServiceWrapper<String>> deleteAllProducts(final Object dataFilter) {
        return localProductData.deleteAllProducts(dataFilter);
    }

}
