package victoriaslmn.android.viper.sample.presentation.messages;

import victoriaslmn.android.viper.sample.domain.contacts.Contact;

public interface MessagesRouter {
    void showChatDetails(Contact contact);
}
