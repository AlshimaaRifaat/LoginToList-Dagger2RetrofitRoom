package unilever.it.org.actualsample.base;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public abstract class BaseViewModelFactory implements ViewModelProvider.Factory {

    protected ViewModel currentViewModel;

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) currentViewModel;
    }
}
