package unilever.it.org.actualsample.viewmodel;

import javax.inject.Inject;

import unilever.it.org.actualsample.base.BaseViewModelFactory;

public class ProductListVMFactory extends BaseViewModelFactory {


    @Inject
    public ProductListVMFactory(ProductListViewModel myViewModel) {
        currentViewModel = myViewModel;
    }

}
