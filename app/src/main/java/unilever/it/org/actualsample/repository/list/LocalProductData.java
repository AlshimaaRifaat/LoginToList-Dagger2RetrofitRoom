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

public class LocalProductData extends LocalDataSourece<DataHolderDTO<Product>>
        implements IProductData {
    private ProductDao productDao;

   @Inject
    public LocalProductData(ProductDao productDao) {
       this.productDao=productDao;

    }




    @Override
    public Observable<ServiceWrapper<DataHolderDTO<Product>>> searchByTitle(String title) {
        List<Product> productList=productDao.searchByTitle(title);
        DataHolderDTO<Product> dataHolder = new DataHolderDTO<>();
        dataHolder.setListData(productList);
        return Observable.just(simulateORMToRX(dataHolder));
    }

    @Override
    public Observable<ServiceWrapper<DataHolderDTO<Product>>> findAll(Object map) {
        List<Product> productList=productDao.findAll();
        DataHolderDTO<Product> dataHolder = new DataHolderDTO<>();
        dataHolder.setListData(productList);
        return Observable.just(simulateORMToRX(dataHolder));
    }

    @Override
    public Observable<ServiceWrapper<String>> deleteAllProducts(Object map) {
        try {

          /*  List<Product> transactionData = (List<Product>) map;
            for (Product details:transactionData) {
                details.getTransactionDetails().get(0).deleteAll(databaseHelper);
            }*/
           productDao.deleteAll();
            return Observable.just(simulateRX("success"));
        } catch (Exception e) {
            return Observable.just(simulateRX(e.getMessage()));
        }
    }


}