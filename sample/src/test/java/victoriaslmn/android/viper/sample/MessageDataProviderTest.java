package victoriaslmn.android.viper.sample;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.observers.TestSubscriber;
import rx.schedulers.Schedulers;
import rx.schedulers.TestScheduler;
import victoriaslmn.android.viper.sample.data.MessagesDataProviderImpl;
import victoriaslmn.android.viper.sample.domain.messages.Message;
import victoriaslmn.android.viper.sample.domain.messages.MessagesDataProvider;

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