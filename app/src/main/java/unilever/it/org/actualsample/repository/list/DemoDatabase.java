package unilever.it.org.actualsample.repository.list;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import unilever.it.org.actualsample.DAOs.ProductDao;
import unilever.it.org.actualsample.database.Product;

@Database(entities = {Product.class}, version = DemoDatabase.VERSION)
public abstract class DemoDatabase extends RoomDatabase {

    static final int VERSION = 1;

    public abstract ProductDao getProductDao();

}
