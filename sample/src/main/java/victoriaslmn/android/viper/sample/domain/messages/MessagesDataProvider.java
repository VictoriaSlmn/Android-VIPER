package victoriaslmn.android.viper.sample.domain.messages;

import java.util.List;

import rx.Notification;
import rx.Observable;
import rx.Scheduler;

public interface MessagesDataProvider {
    Observable<List<Message>> getAllMessages(Scheduler scheduler);
}
