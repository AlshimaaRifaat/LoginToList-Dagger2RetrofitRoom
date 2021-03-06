package unilever.it.org.actualsample.repository.list;

import androidx.lifecycle.LiveData;

import java.util.List;

import io.reactivex.Observable;
import unilever.it.org.actualsample.base.ServiceWrapper;
import unilever.it.org.actualsample.database.DataHolderDTO;
import unilever.it.org.actualsample.database.Product;

public  interface IProductData {

   Observable<ServiceWrapper<DataHolderDTO<Product>>> searchByTitle(String title);

 Observable<ServiceWrapper<DataHolderDTO<Product>>> findAll(Object map);

   //long insert(Product product);

   // Observable<ServiceWrapper<Integer>> delete(Product product);
   Observable<ServiceWrapper<String>> deleteAllProducts(Object map);

}