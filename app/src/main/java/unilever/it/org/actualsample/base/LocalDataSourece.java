package unilever.it.org.actualsample.base;


//import unilever.it.org.storekeeper.database.orm.DatabaseHelper;

public abstract class LocalDataSourece<T> {
 /*   @Inject
    protected DatabaseHelper databaseHelper;*/

    protected ServiceWrapper<T> simulateORMToRX(T data) {
        return new ServiceWrapper<T>(200, data, "");
    }

    protected ServiceWrapper<String> simulateRX(String data) {
        return new ServiceWrapper<>(200, data, "");
    }

    protected ServiceWrapper<T> simulateORMToRX(Boolean isSuccess, T data, String exceptionMessage) {
        return new ServiceWrapper<T>(200, data, exceptionMessage);
    }

}

