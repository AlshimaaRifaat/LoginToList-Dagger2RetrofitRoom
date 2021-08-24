package unilever.it.org.actualsample.usecase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import unilever.it.org.actualsample.Data;
import unilever.it.org.actualsample.base.BaseUseCase;
import unilever.it.org.actualsample.base.ServiceWrapper;
import unilever.it.org.actualsample.database.DataHolderDTO;
import unilever.it.org.actualsample.database.Product;
import unilever.it.org.actualsample.repository.list.ProductDataSource;

public class ProductListUseCase extends BaseUseCase<ServiceWrapper<DataHolderDTO<Product>>> {


    private final ProductDataSource productDataSource;

    @Inject
    public ProductListUseCase(
            ProductDataSource productDataSource) {
        super(io.reactivex.schedulers.Schedulers.io(), AndroidSchedulers.mainThread());
        this.productDataSource=productDataSource;
    }

    @Override
    protected Observable<ServiceWrapper<DataHolderDTO<Product>>> createObservableUseCase(Object map) {
        return productDataSource.getData(map);
    }
}
