package victoriaslmn.android.viper.sample.presentation.common;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.lang.reflect.ParameterizedType;

public abstract class BaseFragment<Presenter extends BasePresenter> extends Fragment {
    private static long lastFragmentId = 0;
    private final long fragmentId;

    private Presenter presenter;

    public BaseFragment() {
        lastFragmentId++;
        fragmentId = lastFragmentId;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
            initPresenter();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //noinspection unchecked
        presenter.setView(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @SuppressWarnings("unchecked")
    private void initPresenter() throws ClassNotFoundException,
            IllegalAccessException, java.lang.InstantiationException {
        ParameterizedType pt
                = (ParameterizedType) getClass().getGenericSuperclass();
        String parameterClassName
                = pt.getActualTypeArguments()[0].toString().split("\\s")[1];
        presenter = (Presenter) Class.forName(parameterClassName).newInstance();
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.onStop();
    }

    public String getFragmentName() {
        return Long.toString(fragmentId);
    }

    protected Presenter getPresenter() {
        return presenter;
    }
}
