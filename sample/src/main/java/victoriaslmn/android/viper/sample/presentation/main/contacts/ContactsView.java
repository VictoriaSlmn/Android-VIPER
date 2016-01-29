package victoriaslmn.android.viper.sample.presentation.main.contacts;

import java.util.List;

import victoriaslmn.android.viper.sample.domain.contacts.Contact;
import victoriaslmn.android.viper.sample.presentation.main.common.BaseMainView;

public interface ContactsView extends BaseMainView {
    void setContacts(List<Contact> contacts);
}
