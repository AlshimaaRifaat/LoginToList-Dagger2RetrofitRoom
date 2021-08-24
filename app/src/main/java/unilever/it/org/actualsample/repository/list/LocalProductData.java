package unilever.it.org.actualsample.repository.list;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import unilever.it.org.actualsample.DAOs.ProductDao;
import unilever.it.org.actualsample.base.LocalDataSourece;
import unilever.it.org.actualsample.base.ServiceWrapper;
import unilever.it.org.actualsample.database.DataHolderDTO;
import unilever.it.org.actualsample.database.Product;

public class LocalProductData extends LocalDataSourece<DataHolderDTO<Product>> implements IProductData {
    private ProductDao productDao;

   @Inject
    public LocalProductData(ProductDao productDao) {
       this.productDao=productDao;

    }

  /*  @Override
    public Observable<List<Product>> findList(Object map) {
        Product salesman = new Product();

        return Observable.just(simulateORMToRX(salesman));
    }*/

    @Override
    public Observable<ServiceWrapper<DataHolderDTO<Product>>> findAll(Object map) {
        List<Product> productList=productDao.findAll();
//check function
        DataHolderDTO<Product> dataHolder = new DataHolderDTO<>();
        dataHolder.setListData(productList);
        return Observable.just(simulateORMToRX(dataHolder));
    }


}