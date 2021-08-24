package unilever.it.org.actualsample.utils;

import android.app.Activity;
import android.util.Log;

import androidx.multidex.MultiDexApplication;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.DaggerApplication;
import unilever.it.org.actualsample.BuildConfig;


import unilever.it.org.di.components.ApplicationComponent;
import unilever.it.org.di.components.DaggerApplicationComponent;
import unilever.it.org.di.components.DaggerGeneralApplicationComponent;
import unilever.it.org.di.components.GeneralApplicationComponent;
import unilever.it.org.di.modules.ApplicationModule;
import unilever.it.org.di.modules.RoomModule;

public class StoreKeeperApplication extends MultiDexApplication implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
    public static String BASE_URL;
    private static GeneralApplicationComponent applicationComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        DaggerApplicationComponent.builder().application(this).build().inject(this);

        BASE_URL = BuildConfig.BASE_URL;
        applicationComponent = DaggerGeneralApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

      /*  Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread paramThread, Throwable paramThrowable) {
                saveCaughtException(paramThrowable);
                paramThrowable.printStackTrace();
                throw new RuntimeException(paramThrowable);
            }
        });*/

    }

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    public static GeneralApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

  /*  public void saveCaughtException(Throwable paramThrowable) {
        try {
            Writer objWriter = new StringWriter();
            PrintWriter objPrintWriter = new PrintWriter(objWriter);
            paramThrowable.printStackTrace(objPrintWriter);
            String strMessage = objWriter.toString();
            paramThrowable.printStackTrace();
            Log objLog = new Log();
            objLog.setErrorMessage(strMessage);
            objLog.save(SecureOpenHelperManager.getHelper(this,
                    DatabaseHelper.class));

            //Clean Up
            objPrintWriter.close();
            objWriter.close();
            paramThrowable.printStackTrace();
            throw new RuntimeException();
        } catch (Throwable e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }*/
}
