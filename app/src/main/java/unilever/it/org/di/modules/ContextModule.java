package unilever.it.org.di.modules;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    @Provides
    Context provideContext(Application application) {
        return application;
    }

}
