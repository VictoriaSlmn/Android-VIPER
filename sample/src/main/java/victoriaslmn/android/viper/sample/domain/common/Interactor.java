package victoriaslmn.android.viper.sample.domain.common;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import victoriaslmn.android.viper.sample.domain.injection.DaggerInteractorComponent;
import victoriaslmn.android.viper.sample.domain.injection.DataModule;
import victoriaslmn.android.viper.sample.domain.injection.InteractorComponent;


public abstract class Interactor<ResultType, ParameterType> {
    protected static InteractorComponent injectionComponent = DaggerInteractorComponent.builder()
            .dataModule(new DataModule())
            .build();

    private CompositeSubscription subscription = new CompositeSubscription();

    public void execute(ParameterType parameter, Subscriber<ResultType> subscriber) {
        subscription.add(buildObservable(parameter)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

    protected abstract Observable<ResultType> buildObservable(ParameterType parameter);

    protected abstract void inject();

    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        subscription = new CompositeSubscription();
    }
}
