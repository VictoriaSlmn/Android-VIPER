package victoriaslmn.android.viper.sample.presentation.main.common;

import android.support.annotation.StringRes;

import victoriaslmn.android.viper.sample.presentation.injection.MainActivityComponent;

public interface BaseMainView {
    void showError(@StringRes int message);
    void showNewMessagesNotification();
    MainActivityComponent getMainActivityComponent();
}


