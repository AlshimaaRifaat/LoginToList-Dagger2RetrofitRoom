package unilever.it.org.actualsample.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import unilever.it.org.actualsample.base.BaseUseCase;
import unilever.it.org.actualsample.base.ServiceWrapper;
import unilever.it.org.actualsample.repository.list.ProductDataSource;

public class ProductDeletionUseCase extends BaseUseCase<ServiceWrapper<String>> {


    private final ProductDataSource productDataSource;

    @Inject
    public ProductDeletionUseCase(
            ProductDataSource productDataSource) {
        super(io.reactivex.schedulers.Schedulers.io(), AndroidSchedulers.mainThread());
        this.productDataSource=productDataSource;
    }


    @Override
    protected Observable<ServiceWrapper<String>> createObservableUseCase(Object map) {
        return productDataSource.deleteAllProducts(map);
    }
}
