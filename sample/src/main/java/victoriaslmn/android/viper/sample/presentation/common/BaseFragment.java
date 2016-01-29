package victoriaslmn.android.viper.sample.presentation.common;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.util.concurrent.atomic.AtomicInteger;

import butterknife.ButterKnife;

public abstract class BaseFragment<Presenter extends BasePresenter> extends Fragment {
    private static final AtomicInteger lastFragmentId = new AtomicInteger(0);
    private final int fragmentId;

    private Presenter presenter;

    public BaseFragment() {
        fragmentId = lastFragmentId.incrementAndGet();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Class cls = getClass();
        if (!cls.isAnnotationPresent(Layout.class)) return null;
        Annotation annotation = cls.getAnnotation(Layout.class);
        Layout layout = (Layout) annotation;
        View view = inflater.inflate(layout.id(), null);
        ButterKnife.bind(this, view);
        return view;
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


    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    public String getFragmentName() {
        return Long.toString(fragmentId);
    }

    protected Presenter getPresenter() {
        return presenter;
    }
}
