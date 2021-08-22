package unilever.it.org.actualsample.base;

import android.app.Activity;

import androidx.fragment.app.Fragment;

public interface IActivityCallBack {

    void replaceFragment(Fragment newFragment, boolean addToBackStack, String tag);

    void addFragment(Fragment newFragment, boolean addToBackStack, String tag);

    void removeFragment(Fragment newFragment, boolean addToBackStack, String tag);

    Fragment getFragment(String fragmentTag);

    void startNewActivity(Class<? extends Activity> newActivity, Object ExstraIntentData);

    void FinishHolderActivity();

    void handleFragmentBackButton();
    void popBackStack();
}

