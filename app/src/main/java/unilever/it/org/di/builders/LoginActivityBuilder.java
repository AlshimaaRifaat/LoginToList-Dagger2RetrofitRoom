package unilever.it.org.di.builders;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import unilever.it.org.actualsample.ui.fragment.ProductListFragment;
import unilever.it.org.actualsample.ui.fragment.LoginFragment;
import unilever.it.org.di.modules.LoginFragmentModule;
import unilever.it.org.di.modules.ProductListFragmentModule;


@Module
public abstract class LoginActivityBuilder {

    @ContributesAndroidInjector(modules = {LoginFragmentModule.class})
    abstract LoginFragment loginFragmentModule();

    @ContributesAndroidInjector(modules = {ProductListFragmentModule.class})
    abstract ProductListFragment provideListFragment();
}
