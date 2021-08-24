package unilever.it.org.di.modules;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import unilever.it.org.actualsample.base.BaseViewModelFactory;
import unilever.it.org.actualsample.ui.fragment.ProductListFragment;
import unilever.it.org.actualsample.viewmodel.ProductListVMFactory;
import unilever.it.org.di.scope.ProductListScope;

@Module
public abstract class ProductListFragmentModule {

    @ProductListScope
    @ContributesAndroidInjector
    public abstract ProductListFragment bindProductListFragment();



    @Binds
    public abstract BaseViewModelFactory bindBaseFragmentPresenter
            (ProductListVMFactory productListVMFactory);


}
