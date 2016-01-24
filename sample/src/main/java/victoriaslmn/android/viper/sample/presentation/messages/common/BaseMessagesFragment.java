package victoriaslmn.android.viper.sample.presentation.messages.common;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import victoriaslmn.android.viper.sample.R;
import victoriaslmn.android.viper.sample.presentation.common.BaseFragment;
import victoriaslmn.android.viper.sample.presentation.messages.MessagesActivity;

public abstract class BaseMessagesFragment<Presenter extends BaseMessagesPresenter> extends BaseFragment<Presenter> implements BaseMessagesView {

    public abstract String getTitle();

    @DrawableRes
    public abstract int getFabButtonIcon();

    @Override
    public void showError(@StringRes int message) {
        Toast.makeText(getContext(), getString(message), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
        MessagesActivity messagesActivity = (MessagesActivity)getActivity();
        //noinspection unchecked
        getPresenter().setRouter(messagesActivity);
        messagesActivity.resolveToolbar(this);
        messagesActivity.resolveFab(this);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //noinspection unchecked
        getPresenter().setRouter(null);
    }

    @Override
    public void showNewMessagesNotification() {
        Snackbar.make(getView(), R.string.new_message_comming, Snackbar.LENGTH_LONG).show();
    }


    public abstract View.OnClickListener getFabButtonAction();
}
