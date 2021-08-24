package unilever.it.org.di.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(/*subcomponents = DatabaseComponent.class*/)
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

   @Provides @Singleton
    Application provideApplication() {
        return application;
    }


}
