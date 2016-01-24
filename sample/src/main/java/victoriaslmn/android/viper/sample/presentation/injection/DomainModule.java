package victoriaslmn.android.viper.sample.presentation.injection;

import java.util.List;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import victoriaslmn.android.viper.sample.data.ContactsDataProviderImpl;
import victoriaslmn.android.viper.sample.data.MessagesDataProviderImpl;
import victoriaslmn.android.viper.sample.domain.common.Interactor;
import victoriaslmn.android.viper.sample.domain.contacts.Contact;
import victoriaslmn.android.viper.sample.domain.contacts.ContactsDataProvider;
import victoriaslmn.android.viper.sample.domain.contacts.GetContactsInteractor;
import victoriaslmn.android.viper.sample.domain.messages.GetLastMessagesByContactsInteractor;
import victoriaslmn.android.viper.sample.domain.messages.GetMessagesByContactInteractor;
import victoriaslmn.android.viper.sample.domain.messages.Message;
import victoriaslmn.android.viper.sample.domain.messages.MessagesDataProvider;

@Module
public class DomainModule {
    public static final String LAST_MESSAGE = "LAST_MESSAGE";
    public static final String MESSAGE_BY_CONTACT = "MESSAGE_BY_CONTACT";
    public static final String CONTACT = "CONTACT";

    @Provides
    @Named(LAST_MESSAGE)
    public Interactor<List<Message>, Void> provideGetLastMessageInteractor(@Named(PresentationModule.JOB) Scheduler jobScheduler,
                                                      @Named(PresentationModule.UI) Scheduler uiScheduler,
                                                      MessagesDataProvider messagesDataProvider) {
        return new GetLastMessagesByContactsInteractor(jobScheduler, uiScheduler, messagesDataProvider);
    }

    @Provides
    @Named(MESSAGE_BY_CONTACT)
    public Interactor<List<Message>, Contact> provideGetMessageByContactIntaractor(@Named(PresentationModule.JOB) Scheduler jobScheduler,
                                                           @Named(PresentationModule.UI) Scheduler uiScheduler,
                                                           MessagesDataProvider messagesDataProvider){
        return new GetMessagesByContactInteractor(jobScheduler, uiScheduler, messagesDataProvider);
    }

    @Provides
    @Named(CONTACT)
    public Interactor<List<Contact>, Void> provideGetContactsIntaractor(@Named(PresentationModule.JOB) Scheduler jobScheduler,
                                                           @Named(PresentationModule.UI) Scheduler uiScheduler,
                                                           ContactsDataProvider contactsDataProvider){
        return new GetContactsInteractor(jobScheduler, uiScheduler, contactsDataProvider);
    }
}
