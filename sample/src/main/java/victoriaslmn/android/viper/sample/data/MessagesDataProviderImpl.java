package victoriaslmn.android.viper.sample.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Notification;
import rx.Observable;
import rx.Scheduler;
import victoriaslmn.android.viper.sample.domain.contacts.Contact;
import victoriaslmn.android.viper.sample.domain.messages.Message;
import victoriaslmn.android.viper.sample.domain.messages.MessagesDataProvider;

public class MessagesDataProviderImpl implements MessagesDataProvider {

    public static long PERIOD_UPDATE_IN_SECOND = 3;
    public static long NOW = new Date().getTime();

    @Override
    public Observable<Notification<List<Message>>> getAllMessages(Scheduler scheduler) {
        return Observable.interval(0, PERIOD_UPDATE_IN_SECOND, TimeUnit.SECONDS, scheduler)
                .flatMap(this::getMessages)
                .materialize();
    }

    private synchronized Observable<List<Message>> getMessages(long times) {
        List<Message> result = new ArrayList<>();
        int contactId = 0;
        for (int i = 0; i < times + 5; i++) {
            result.add(new Message(i, new Contact(contactId, "Contact " + contactId), "Message " + i, NOW + i*10000));
            if (contactId < Contact.SAMPLE_MAX_CONTACT_COUNT - 1) {
                contactId++;
            }else {
                contactId = 0;
            }
        }
        return Observable.just(result);
    }
}
