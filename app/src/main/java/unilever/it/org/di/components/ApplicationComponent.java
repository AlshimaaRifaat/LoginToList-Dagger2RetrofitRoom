package unilever.it.org.di.components;


import android.app.Application;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import unilever.it.org.actualsample.utils.StoreKeeperApplication;
import unilever.it.org.di.builders.ActivityBuilder;
import unilever.it.org.di.modules.ContextModule;
import unilever.it.org.di.modules.RetrofitModule;

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        ContextModule.class,
        ActivityBuilder.class,
      /*  ServiceModule.class,
        ConnectionCheckerModule.class,
        DeviceSerialModule.class,
        SharedPreferencesModule.class,*/
        RetrofitModule.class,
       // DataBaseModule.class

        /* DBConnectionModule.class*/

})
public interface ApplicationComponent {
    void inject(StoreKeeperApplication context);

    @Component.Builder
    interface Builder{
        @BindsInstance
       Builder application(Application application);

        ApplicationComponent build();
    }
}



