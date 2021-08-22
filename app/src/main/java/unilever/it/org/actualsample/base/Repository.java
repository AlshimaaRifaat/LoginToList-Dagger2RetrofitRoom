package unilever.it.org.actualsample.base;


import io.reactivex.Observable;
import unilever.it.org.actualsample.api.ServiceWrapper;

public abstract class Repository<T extends DTO> /*extends BaseRepository */{

    public abstract Observable<ServiceWrapper<T>> getData(final Object dataFilter);

 /*   protected boolean checkOfflineMode() {
        return SharedPreferencesUtils.getBoolean(sharedPreferences, Constants.OfflineMode, false);

    }*/

}
