package unilever.it.org.actualsample.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public abstract class BaseFragment extends Fragment {

    @Inject
    protected BaseViewModelFactory mViewModelFactory;
    protected Context mContext;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidSupportInjection.inject(this);
        OnCreateJob();
    }

    protected void OnCreateJob() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(setProperFragmentView(), container, false);
        OnCreateViewJob(view);
        return view;
    }

    protected void OnCreateViewJob(View view) {

    }

    protected abstract int setProperFragmentView();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }


    @Override
    public void onDetach() {
        super.onDetach();
        this.mContext = null;
    }

/*
    public void setUpToolBarHomeBtn(Toolbar toolbar,View.OnClickListener onClickListener,Integer drawableId )
    {

        if(drawableId!=null)
        toolbar.setNavigationIcon(getResources().getDrawable(drawableId));
        if(onClickListener!=null)
        toolbar.setNavigationOnClickListener(onClickListener);
    }
*/
    /*
    public void setToolBarHeaderTitle(Toolbar toolbar,Integer toolBarHeader)
    {
        TextView textView = toolbar.findViewById(R.id.fragment_title);
        textView.setText(toolBarHeader);
    }
    */
    /*
    public void setupNavigationDrawer(NavigationView navigationView,Toolbar toolbar,DrawerLayout mDrawerLayout)
    {
        //navigationView.setVisibility(View.VISIBLE);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        setupDrawerContent(navigationView);
        mDrawerLayout.addDrawerListener( new ActionBarDrawerToggle(getActivity(), mDrawerLayout,toolbar, R.string.s1,  R.string.s2));

        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
    */

/*
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }
*/
/*
    public void selectDrawerItem(MenuItem menuItem) {
        switch(menuItem.getItemId()) {
            case R.id.nav_drawer_reports:
                ((IActivityCallBack) mContext).startNewActivity(ReportActivity.class,null);
                break;
            case R.id.nav_drawer_plan:
                ((IActivityCallBack) mContext).addFragment(PlanFragment.newInstance(),true,PlanFragment.class.getSimpleName());
                break;
            case R.id.nav_drawer_competitor_reports:
                break;
            default:
                break;
        }


    }
*/


    public void startActivityForResult(Class<? extends Activity> newActivity, Object ExstraIntentData) {
        Intent intent = new Intent(getActivity(), newActivity);
        if (ExstraIntentData != null)
            intent.putExtras((Bundle) ExstraIntentData);
        startActivityForResult(intent, 1);


    }


}

