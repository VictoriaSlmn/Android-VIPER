package victoriaslmn.android.viper.sample.domain.common;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;


public abstract class Interactor<ResultType, ParameterType> {
    private CompositeSubscription subscription = new CompositeSubscription();
    protected final Scheduler jobScheduler;
    private final Scheduler iuScheduler;

    public Interactor(Scheduler jobScheduler, Scheduler iuScheduler) {
        this.jobScheduler = jobScheduler;
        this.iuScheduler = iuScheduler;
    }

//    public Interactor() {
//        this(Schedulers.computation(), AndroidSchedulers.mainThread());
//    }

    protected abstract Observable<ResultType> buildObservable(ParameterType parameter);

    public void execute(ParameterType parameter, Subscriber<ResultType> subscriber) {
        subscription.add(buildObservable(parameter)
                .subscribeOn(jobScheduler)
                .observeOn(iuScheduler)
                .subscribe(subscriber));
    }

    public void execute(Subscriber<ResultType> subscriber) {
        execute(null, subscriber);
    }

    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        subscription = new CompositeSubscription();
    }
}
