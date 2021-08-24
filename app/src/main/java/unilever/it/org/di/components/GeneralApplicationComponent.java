package unilever.it.org.di.components;

import dagger.Component;
import unilever.it.org.actualsample.utils.SecureAndroidConnectionSource;
import unilever.it.org.di.modules.ApplicationModule;
import unilever.it.org.di.modules.RoomModule;

@Component(dependencies = {},modules = {

        ApplicationModule.class,

        //DeviceSerialModule.class

})
public interface GeneralApplicationComponent {
    void inject(SecureAndroidConnectionSource context);
}


