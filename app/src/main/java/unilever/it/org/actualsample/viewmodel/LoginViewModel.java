package unilever.it.org.actualsample.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import unilever.it.org.actualsample.Data;

import unilever.it.org.actualsample.database.User;
import unilever.it.org.actualsample.base.ServiceWrapper;
import unilever.it.org.actualsample.usecase.LoginUseCase;
import unilever.it.org.actualsample.usecase.UseCaseObserver;

import unilever.it.org.di.scope.LoginScope;

public class LoginViewModel extends ViewModel {

  /*  @Inject
    SharedPreferences sharedPerf;*/
    // TODO: Implement the ViewModel
    private MutableLiveData<Data> userMutableLiveData;
    @LoginScope
    private final LoginUseCase loginUseCase;
    private static final String TAG = "LoginViewModel";

    @Inject
    public LoginViewModel(LoginUseCase login) {
        this.loginUseCase = login;
    }

    public MutableLiveData<Data> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }

    public void loginAction(String email,String password,int remember_me) {
        //SecurityUtil util = new SecurityUtil();
        User user=new User(email,password,remember_me);
        loginUseCase.execute(new UseCaseObserver<ServiceWrapper<Data>>() {
                                 @Override
                                 public void onSuccess(ServiceWrapper<Data> salesmanDTOServiceWrapper) {
                                     //sharedPerf.edit().putString("'key'",encryptData(value)).apply();
                                    // if (salesmanDTOServiceWrapper.isSuccess()) {
                                       /*  SharedPreferencesUtils.putString(sharedPerf, Constants.Usertoken,
                                                 salesmanDTOServiceWrapper.getData().getUsertToken());
                                         SharedPreferencesUtils.putString(sharedPerf, Constants.BRANCH_NO,
                                                 salesmanDTOServiceWrapper.getData().getUserBranchNo());*/
                                         userMutableLiveData.setValue(salesmanDTOServiceWrapper.getData());

                                    // Log.d(TAG, "onSuccess: "+salesmanDTOServiceWrapper.getMsg().toString());

                                    /* } else {
                                         userMutableLiveData.setValue(null);
                                     }*/
                                 }

                                 @Override
                                 public void onFailed(String errorModel) {
                                     userMutableLiveData.setValue(null);


                                 }
                             },user);
              // new User(userName.trim(), util.encrypt(password.trim(), userName.trim())));


    }

    @Override
    protected void onCleared() {
        super.onCleared();
        loginUseCase.clear();
    }
}

