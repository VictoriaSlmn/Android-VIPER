package victoriaslmn.android.viper.sample.domain.messages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;
import victoriaslmn.android.viper.sample.domain.common.Interactor;
import victoriaslmn.android.viper.sample.presentation.injection.PresentationModule;

public class GetLastMessagesByContactsInteractor extends Interactor<List<Message>, Void> {

    private final MessagesDataProvider messagesDataProvider;

    @Inject
    public GetLastMessagesByContactsInteractor(@Named(PresentationModule.JOB) Scheduler jobScheduler,
                                               @Named(PresentationModule.UI) Scheduler iuScheduler,
                                               MessagesDataProvider messagesDataProvider) {
        super(jobScheduler, iuScheduler);
        this.messagesDataProvider = messagesDataProvider;
    }

    @Override
    protected Observable<List<Message>> buildObservable(Void parametr) {
        return messagesDataProvider.getAllMessages(jobScheduler)
                .concatMap(listNotification -> Observable.from(listNotification.getValue())
                        .toMultimap(Message::getContact)
                        .concatMap(multimap -> Observable.from(multimap.values()))
                        .concatMap(messages -> {
                            List<Message> messageList = new ArrayList<>(messages);
                            Collections.sort(messageList, this::compareMessageTimestamp);
                            return Observable.from(messageList).first();
                        })
                        .toSortedList(this::compareMessageTimestamp));
    }

    private int compareMessageTimestamp(Message message1, Message message2) {
        if (message1.getTimestamp() == message2.getTimestamp()) {
            return 0;
        }
        return message1.getTimestamp() > message2.getTimestamp() ? -1 : 1;
    }
}
