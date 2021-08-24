package unilever.it.org.actualsample.usecase;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import unilever.it.org.actualsample.base.BaseUseCase;
import unilever.it.org.actualsample.base.ServiceWrapper;
import unilever.it.org.actualsample.database.DataHolderDTO;
import unilever.it.org.actualsample.database.Product;
import unilever.it.org.actualsample.repository.list.ProductDataSource;

public class ProductSearchUseCase extends BaseUseCase<ServiceWrapper<DataHolderDTO<Product>>> {


    private final ProductDataSource productDataSource;

    @Inject
    public ProductSearchUseCase(
            ProductDataSource productDataSource) {
        super(io.reactivex.schedulers.Schedulers.io(), AndroidSchedulers.mainThread());
        this.productDataSource = productDataSource;
    }

    @Override
    protected Observable<ServiceWrapper<DataHolderDTO<Product>>> createObservableUseCase(Object map) {
        return productDataSource.searchByTitle(map);
    }
}