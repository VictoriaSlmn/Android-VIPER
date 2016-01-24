package victoriaslmn.android.viper.sample.presentation.messages.common;


import android.os.Bundle;
import android.support.annotation.StringRes;
import android.widget.Toast;

import victoriaslmn.android.viper.sample.presentation.common.BaseFragment;

public abstract class BaseMessagesFragment<Presenter extends BaseMessagesPresenter> extends BaseFragment<Presenter> implements BaseMessagesView {

    public abstract int getTitle();

    @Override
    public void showError(@StringRes int message) {
        Toast.makeText(getContext(), getString(message), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
        //noinspection unchecked
        getPresenter().setRouter(getActivity());
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //noinspection unchecked
        getPresenter().setRouter(null);
    }
}
