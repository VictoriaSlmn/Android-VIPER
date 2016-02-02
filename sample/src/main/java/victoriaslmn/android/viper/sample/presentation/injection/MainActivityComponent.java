package victoriaslmn.android.viper.sample.presentation.injection;

import javax.inject.Singleton;

import dagger.Component;
import victoriaslmn.android.viper.sample.presentation.main.chats.ChatsFragment;
import victoriaslmn.android.viper.sample.presentation.main.chats.ChatsPresenter;
import victoriaslmn.android.viper.sample.presentation.main.contacts.ContactsFragment;
import victoriaslmn.android.viper.sample.presentation.main.contacts.ContactsPresenter;
import victoriaslmn.android.viper.sample.presentation.main.messages.MessagesFragment;
import victoriaslmn.android.viper.sample.presentation.main.messages.MessagesPresenter;

@Singleton
@Component(modules = {DomainModule.class, DataModule.class})
public interface MainActivityComponent {
    void inject(ChatsFragment chatsFragment);

    void inject(MessagesFragment messagesFragment);

    void inject(ContactsFragment contactsFragment);
}
