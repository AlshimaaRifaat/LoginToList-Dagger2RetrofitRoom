package unilever.it.org.actualsample.viewmodel;

import javax.inject.Inject;

import unilever.it.org.actualsample.base.BaseViewModelFactory;

public class LoginVMFactory extends BaseViewModelFactory {


    @Inject
    public LoginVMFactory(LoginViewModel myViewModel) {
        currentViewModel = myViewModel;
    }

}
