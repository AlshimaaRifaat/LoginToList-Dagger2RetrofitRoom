package unilever.it.org.actualsample.utils;

import android.database.sqlite.SQLiteOpenHelper;

public class SecureAndroidConnectionSource {
    public SecureAndroidConnectionSource() {

        StoreKeeperApplication.getApplicationComponent().inject(this);
    }
}
