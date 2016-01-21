package victoriaslmn.android.viper.sample.presentation.common;

public abstract class BasePresenter<View extends BaseView> {
    private View view;

    /**
     * Default constructor.  <strong>Every</strong> presenter must have an
     * empty constructor, so it can be instantiated when Fragment.onActivityCreated()
     * It is strongly recommended that subclasses do not
     * have other constructors with parameters
     **/
    public BasePresenter() {
    }

    public abstract void onStart();

    public abstract void onStop();

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}


