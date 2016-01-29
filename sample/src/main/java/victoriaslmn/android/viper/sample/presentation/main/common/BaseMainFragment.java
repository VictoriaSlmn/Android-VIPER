package victoriaslmn.android.viper.sample.presentation.main.common;


import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import victoriaslmn.android.viper.sample.R;
import victoriaslmn.android.viper.sample.presentation.common.BaseFragment;
import victoriaslmn.android.viper.sample.presentation.injection.MainActivityComponent;
import victoriaslmn.android.viper.sample.presentation.main.MainActivity;

public abstract class BaseMainFragment<Presenter extends BaseMainPresenter> extends BaseFragment<Presenter> implements BaseMainView {

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
        MainActivity mainActivity = (MainActivity) getActivity();
        injectPresenter();
        //noinspection unchecked
        getPresenter().setRouter(mainActivity);
        mainActivity.resolveToolbar(this);
        mainActivity.resolveFab(this);
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


    protected abstract void injectPresenter();

    protected MainActivityComponent getMainActivityComponent() {
        return ((MainActivity)getActivity()).getMainActivityComponent();
    }

    public abstract View.OnClickListener getFabButtonAction();
}
