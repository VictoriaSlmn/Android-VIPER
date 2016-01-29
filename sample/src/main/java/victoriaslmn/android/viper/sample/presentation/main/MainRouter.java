package victoriaslmn.android.viper.sample.presentation.main;

import victoriaslmn.android.viper.sample.domain.contacts.Contact;

public interface MainRouter {
    void showMessages(Contact contact);

    void openContacts();
}
