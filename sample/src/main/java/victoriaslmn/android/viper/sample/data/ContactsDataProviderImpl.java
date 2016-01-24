package victoriaslmn.android.viper.sample.data;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import victoriaslmn.android.viper.sample.domain.contacts.Contact;
import victoriaslmn.android.viper.sample.domain.contacts.ContactsDataProvider;

public class ContactsDataProviderImpl implements ContactsDataProvider {
    @Override
    public Observable<List<Contact>> getAllContacts() {
        List<Contact> result = new ArrayList<>();
        for (int i = 0; i < Contact.SAMPLE_MAX_CONTACT_COUNT; i++) {
            result.add(new Contact(i, "contact" + i));
        }
        return Observable.just(result);
    }
}
