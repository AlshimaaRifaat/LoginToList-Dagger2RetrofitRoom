package unilever.it.org.di.builders;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import unilever.it.org.actualsample.ui.HomeActivity;
import unilever.it.org.actualsample.ui.MainActivity;
import unilever.it.org.di.modules.RetrofitModule;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {
            LoginActivityBuilder.class
    })
    abstract MainActivity mainHolderActivity();



}
