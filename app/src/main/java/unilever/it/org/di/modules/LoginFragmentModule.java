package unilever.it.org.di.modules;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import unilever.it.org.actualsample.ui.LoginFragment;
import unilever.it.org.actualsample.base.BaseViewModelFactory;
import unilever.it.org.actualsample.viewmodel.LoginVMFactory;
import unilever.it.org.di.scope.LoginScope;

@Module
public abstract class LoginFragmentModule {

    @LoginScope
    @ContributesAndroidInjector
    public abstract LoginFragment bindLoginFragment();

    @Binds
    public abstract BaseViewModelFactory bindBaseFragmentPresenter
            (LoginVMFactory loginFragmentViewModel);


}
