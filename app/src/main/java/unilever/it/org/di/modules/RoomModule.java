package unilever.it.org.di.modules;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import unilever.it.org.actualsample.DAOs.ProductDao;
import unilever.it.org.actualsample.repository.list.DemoDatabase;
import unilever.it.org.actualsample.repository.list.IProductData;
import unilever.it.org.actualsample.repository.list.LocalProductData;
import unilever.it.org.actualsample.repository.list.ProductDataSource;

@Module
public class RoomModule {
    private DemoDatabase demoDatabase;

   /* public RoomModule(Context context) {
        demoDatabase = Room.databaseBuilder(context, DemoDatabase.class, "demo-db")
                .allowMainThreadQueries().build();
    }*/

   // @Singleton
    @Provides
    DemoDatabase providesRoomDatabase(Context context) {
        demoDatabase = Room.databaseBuilder(context,DemoDatabase.class, "demo-db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries().build();
        return demoDatabase;
    }

   @Singleton
    @Provides
    ProductDao providesProductDao(DemoDatabase demoDatabase) {
        return demoDatabase.getProductDao();
    }

/*
    @Singleton
    @Provides
    ProductDataSource productRepository(LocalProductData localProductData) {
        return  new ProductDataSource(localProductData);
    }*/
}
