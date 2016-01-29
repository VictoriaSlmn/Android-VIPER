package victoriaslmn.android.viper.sample.presentation.injection;

import javax.inject.Singleton;

import dagger.Component;
import victoriaslmn.android.viper.sample.presentation.main.chats.ChatsPresenter;
import victoriaslmn.android.viper.sample.presentation.main.messages.MessagesPresenter;

@Singleton
@Component(modules = {DomainModule.class, DataModule.class})
public interface MainActivityComponent {
    void inject(ChatsPresenter chatsPresenter);

    void inject(MessagesPresenter messagesPresenter);
}
