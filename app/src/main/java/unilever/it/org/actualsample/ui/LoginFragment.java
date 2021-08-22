package unilever.it.org.actualsample.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;


import unilever.it.org.actualsample.Data;
import unilever.it.org.actualsample.R;
import unilever.it.org.actualsample.User;
import unilever.it.org.actualsample.base.BaseFragment;
import unilever.it.org.actualsample.viewmodel.LoginViewModel;


public class LoginFragment extends BaseFragment {


    private LoginViewModel mViewModel;
    private AppCompatEditText etEmail, etPassword,etForgetMe;
    private Button btnServerLogin;
    private ProgressBar loading_Bar;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    protected int setProperFragmentView() {
        return R.layout.fragment_login;
    }


    @Override
    protected void OnCreateViewJob(View view) {
        super.OnCreateViewJob(view);
        btnServerLogin = view.findViewById(R.id.btnServerLogin);
        etEmail = view.findViewById(R.id.etEmail);
        etPassword = view.findViewById(R.id.etPassword);
        etForgetMe = view.findViewById(R.id.etForgetme);
        loading_Bar = view.findViewById(R.id.loading_Bar);
        btnServerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnServerLogin.setEnabled(false);
                closeKeyBoard();

                    loading_Bar.setVisibility(View.VISIBLE);



                    mViewModel.loginAction("ahmedateya47@gmail.com","111111",1);
                /* else {
                    *//*CommonUtils.showSnackbar(mContext, LoginFragment.this.getView(),
                            getString(R.string.login_msg_validation));*//*
                    Toast.makeText(mContext, "user name or password error", Toast.LENGTH_SHORT).show();
                    btnServerLogin.setEnabled(true);
                }*/
            }
        });

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this, mViewModelFactory).get(LoginViewModel.class);
        mViewModel.getUser().observe(getViewLifecycleOwner(), new Observer<Data>() {
            @Override
            public void onChanged(@Nullable Data loginUser) {
                if (loginUser != null) {
                 /*   Intent intent = new Intent(mContext, HomeActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    (mContext).startActivity(intent);
                    ((LoginActivity) mContext).finish();*/

                    Toast.makeText(mContext, loginUser.getAccessToken(), Toast.LENGTH_SHORT).show();

                } else {
                    btnServerLogin.setEnabled(true);
                 /*   CommonUtils.showSnackbar(mContext, LoginFragment.this.getView(),
                            getString(R.string.login_msg_failed));*/
                    Toast.makeText(mContext, "login failed", Toast.LENGTH_SHORT).show();
                }
                loading_Bar.setVisibility(View.GONE);
            }
        });


    }

    private void closeKeyBoard() {
        try {
            InputMethodManager inputManager = (InputMethodManager) getActivity()
                    .getSystemService(Context.INPUT_METHOD_SERVICE);

            // check if no view has focus:
            View currentFocusedView = getActivity().getCurrentFocus();
            if (currentFocusedView != null) {
                inputManager.hideSoftInputFromWindow(currentFocusedView.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        } catch (Exception Ex) {

        }

    }

}
