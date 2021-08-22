package unilever.it.org.di.builders;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import unilever.it.org.actualsample.ui.LoginFragment;
import unilever.it.org.di.modules.LoginFragmentModule;

@Module
public abstract class LoginActivityBuilder {


  /*  @ContributesAndroidInjector(modules = {SplashFragmentModule.class})
    abstract SplashFragment splashFragmentModule();*/

    @ContributesAndroidInjector(modules = {LoginFragmentModule.class})
    abstract LoginFragment loginFragmentModule();


}
