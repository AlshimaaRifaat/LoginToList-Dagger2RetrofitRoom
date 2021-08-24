package unilever.it.org.actualsample.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;

import unilever.it.org.actualsample.base.ServiceWrapper;
import unilever.it.org.actualsample.database.DataHolderDTO;
import unilever.it.org.actualsample.database.Product;
import unilever.it.org.actualsample.usecase.ProductDeletionUseCase;
import unilever.it.org.actualsample.usecase.ProductListUseCase;
import unilever.it.org.actualsample.usecase.ProductSearchUseCase;
import unilever.it.org.actualsample.usecase.UseCaseObserver;

public class ProductListViewModel extends ViewModel {
    private MutableLiveData<DataHolderDTO<Product>> listMutableLiveData;
    private ProductListUseCase productListUseCase;

    private MutableLiveData<DataHolderDTO<Product>> productSearchMutableLiveData;
    private ProductSearchUseCase productSearchUseCase;
    private ProductDeletionUseCase productDeletionUseCase;
    private static final String TAG = "ListViewModel";
    private MutableLiveData<String> deleteAllMutableLiveData;

    @Inject
    public ProductListViewModel(ProductListUseCase productListUseCase
    ,ProductSearchUseCase productSearchUseCase,
     ProductDeletionUseCase productDeletionUseCase) {
        this.productListUseCase = productListUseCase;
        this.productSearchUseCase=productSearchUseCase;
        this.productDeletionUseCase=productDeletionUseCase;
    }

    public LiveData<DataHolderDTO<Product>> getList() {
        if (listMutableLiveData == null) {
            listMutableLiveData = new MutableLiveData<>();
        }
        return listMutableLiveData;
    }

    public LiveData<DataHolderDTO<Product>> searchList() {
        if (productSearchMutableLiveData == null) {
            productSearchMutableLiveData = new MutableLiveData<>();
        }
        return productSearchMutableLiveData;
    }
    public MutableLiveData<String> getDeleteAllProducts() {
        if (deleteAllMutableLiveData == null) {
            deleteAllMutableLiveData = new MutableLiveData<>();
        }
        return deleteAllMutableLiveData;
    }


    public void getProductList(){
        productListUseCase.execute(new UseCaseObserver<ServiceWrapper<DataHolderDTO<Product>>>() {
                            @Override
                            public void onSuccess(ServiceWrapper<DataHolderDTO<Product>>
                                                          result) {
                                listMutableLiveData.setValue(result.getData());
                            }

                            @Override
                            public void onFailed(String errorModel) {
                                listMutableLiveData.setValue(null);
                            }
                        },
                null);

    }

    public void getSearchResultList(String title){
        productSearchUseCase.execute(new UseCaseObserver<ServiceWrapper<DataHolderDTO<Product>>>() {
                                       @Override
                                       public void onSuccess(ServiceWrapper<DataHolderDTO<Product>>
                                                                     result) {
                                           productSearchMutableLiveData.setValue(result.getData());
                                       }

                                       @Override
                                       public void onFailed(String errorModel) {
                                           productSearchMutableLiveData.setValue(null);
                                       }
                                   },
                title);

    }


    public void deleteAllProducts(List<Product> data) {

        productDeletionUseCase.execute(new UseCaseObserver<ServiceWrapper<String>>() {
                                          @Override
                                          public void onSuccess(ServiceWrapper<String> result) {
                                              deleteAllMutableLiveData.setValue(result.getData());
                                          }

                                          @Override
                                          public void onFailed(String errorModel) {
                                              deleteAllMutableLiveData.setValue(errorModel);
                                          }
                                      },
                data);


    }

}
