package victoriaslmn.android.viper.sample.presentation.main.common;

import android.support.annotation.StringRes;

public interface BaseMainView {
    void showError(@StringRes int message);
    void showNewMessagesNotification();
}


