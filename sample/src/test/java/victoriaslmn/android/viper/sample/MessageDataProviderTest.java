package victoriaslmn.android.viper.sample;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Notification;
import rx.Observable;
import rx.functions.Action1;
import rx.observers.TestSubscriber;
import rx.schedulers.Schedulers;
import rx.schedulers.TestScheduler;
import victoriaslmn.android.viper.sample.data.MessagesDataProviderImpl;
import victoriaslmn.android.viper.sample.domain.contacts.Contact;
import victoriaslmn.android.viper.sample.domain.messages.GetLastMessagesByContactsInteractor;
import victoriaslmn.android.viper.sample.domain.messages.Message;
import victoriaslmn.android.viper.sample.domain.messages.MessagesDataProvider;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MessageDataProviderTest {


    @Test
    public void testPeriod() {
        MessagesDataProvider messagesDataProvider = new MessagesDataProviderImpl();
        int times = 10;
        TestScheduler testScheduler = Schedulers.test();
        TestSubscriber<List<Message>> testSubscriber = new TestSubscriber<>();

        messagesDataProvider.getAllMessages(testScheduler).subscribe(listNotification -> {
            listNotification.accept(testSubscriber);
        });
        testScheduler.advanceTimeBy(MessagesDataProviderImpl.PERIOD_UPDATE_IN_SECOND * times, TimeUnit.SECONDS);

        testSubscriber.assertNoErrors();
        Assert.assertEquals(times + 1, testSubscriber.getOnNextEvents().size());//one first and 0ne per second
    }

}