package victoriaslmn.android.viper.sample.domain.contacts;

import java.util.List;

import rx.Observable;

public interface ContactsDataProvider {
    Observable<List<Contact>> getAllContacts();
}
