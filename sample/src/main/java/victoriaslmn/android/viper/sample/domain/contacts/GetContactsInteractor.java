package victoriaslmn.android.viper.sample.domain.contacts;

import java.util.List;

import rx.Observable;
import rx.Scheduler;
import victoriaslmn.android.viper.sample.domain.common.Interactor;

public class GetContactsInteractor extends Interactor<List<Contact>, Void> {

    private final ContactsDataProvider contactsDataProvider;

    public GetContactsInteractor(Scheduler jobScheduler, Scheduler iuScheduler, ContactsDataProvider contactsDataProvider) {
        super(jobScheduler, iuScheduler);
        this.contactsDataProvider = contactsDataProvider;
    }

    @Override
    protected Observable<List<Contact>> buildObservable(Void parameter) {
        return contactsDataProvider.getAllContacts();
    }
}
