package unilever.it.org.di.builders;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import unilever.it.org.actualsample.ui.activity.MainActivity;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {
            LoginActivityBuilder.class
    })
    abstract MainActivity mainHolderActivity();



}
