package victoriaslmn.android.viper.sample.presentation.main.contacts;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import victoriaslmn.android.viper.sample.R;
import victoriaslmn.android.viper.sample.domain.contacts.Contact;
import victoriaslmn.android.viper.sample.domain.contacts.GetContactsInteractor;
import victoriaslmn.android.viper.sample.presentation.main.common.BaseMainPresenter;

public class ContactsPresenter extends BaseMainPresenter<ContactsView> {

    private final GetContactsInteractor getContactsInteractor;

    @Inject
    public ContactsPresenter(GetContactsInteractor getContactsInteractor){
        this.getContactsInteractor = getContactsInteractor;
    }

    @Override
    public void onStart() {
        getContactsInteractor.execute(new Subscriber<List<Contact>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                getView().showError(R.string.error);
            }

            @Override
            public void onNext(List<Contact> contacts) {
                getView().setContacts(contacts);
            }
        });
    }

    @Override
    public void onStop() {
        getContactsInteractor.unsubscribe();
    }

    public void contactSelected(Contact contact) {
        getRouter().showMessages(contact);
    }
}
