package victoriaslmn.android.viper.sample.domain.contacts;

import java.util.List;

import javax.inject.Named;

import rx.Observable;
import rx.Scheduler;
import victoriaslmn.android.viper.sample.domain.common.Interactor;
import victoriaslmn.android.viper.sample.presentation.injection.PresentationModule;

public class GetContactsInteractor extends Interactor<List<Contact>, Void> {

    private final ContactsDataProvider contactsDataProvider;

    public GetContactsInteractor(@Named(PresentationModule.JOB) Scheduler jobScheduler,
                                 @Named(PresentationModule.UI) Scheduler iuScheduler,
                                 ContactsDataProvider contactsDataProvider) {
        super(jobScheduler, iuScheduler);
        this.contactsDataProvider = contactsDataProvider;
    }

    @Override
    protected Observable<List<Contact>> buildObservable(Void parameter) {
        return contactsDataProvider.getAllContacts();
    }
}
