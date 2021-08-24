package unilever.it.org.actualsample.repository.list;

import androidx.lifecycle.LiveData;

import java.util.List;

import io.reactivex.Observable;
import unilever.it.org.actualsample.base.ServiceWrapper;
import unilever.it.org.actualsample.database.DataHolderDTO;
import unilever.it.org.actualsample.database.Product;

public  interface IProductData {

   // LiveData<Product> findById(int id);

 Observable<ServiceWrapper<DataHolderDTO<Product>>> findAll(Object map);

   /* long insert(Product product);

    int delete(Product product);*/

}