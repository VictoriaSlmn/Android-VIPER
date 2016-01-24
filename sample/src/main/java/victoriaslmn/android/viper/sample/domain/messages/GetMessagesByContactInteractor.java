package victoriaslmn.android.viper.sample.domain.messages;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Scheduler;
import victoriaslmn.android.viper.sample.domain.common.Interactor;
import victoriaslmn.android.viper.sample.domain.contacts.Contact;

public class GetMessagesByContactInteractor extends Interactor<List<Message>, Contact> {
    private final MessagesDataProvider messagesDataProvider;

    @Inject
    public GetMessagesByContactInteractor(Scheduler jobScheduler, Scheduler iuScheduler, MessagesDataProvider messagesDataProvider) {
        super(jobScheduler, iuScheduler);
        this.messagesDataProvider = messagesDataProvider;
    }

    @Override
    protected Observable<List<Message>> buildObservable(Contact parameter) {
        return messagesDataProvider.getAllMessages(jobScheduler)
                .flatMap(listNotification -> Observable.from(listNotification.getValue()))
                .filter(r -> r.getContact().equals(parameter))
                .toSortedList((message1, message2) -> {
                    if (message1.getTimestamp() == message2.getTimestamp()) {
                        return 0;
                    }
                    return message1.getTimestamp() > message2.getTimestamp() ? 1 : -1;
                });
    }
}
