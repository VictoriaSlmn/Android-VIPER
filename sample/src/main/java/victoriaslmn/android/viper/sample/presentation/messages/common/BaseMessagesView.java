package victoriaslmn.android.viper.sample.presentation.messages.common;

import android.support.annotation.StringRes;

public interface BaseMessagesView {
    void showError(@StringRes int message);
    void showNewMessagesNotification();
}


