package unilever.it.org.actualsample.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;
import unilever.it.org.actualsample.R;
import unilever.it.org.actualsample.ui.LoginFragment;
import unilever.it.org.actualsample.utils.SecureAndroidConnectionSource;

public class MainActivity  extends AppCompatActivity implements HasSupportFragmentInjector {
    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    SecureAndroidConnectionSource connectionSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          connectionSource =
                new SecureAndroidConnectionSource();
        //((StoreKeeperApplication)getApplication()).getApplicationComponent().inject(this);
        StartInstantiateProccess();
    }

    private void StartInstantiateProccess() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, LoginFragment.newInstance())
                .commitNow();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}