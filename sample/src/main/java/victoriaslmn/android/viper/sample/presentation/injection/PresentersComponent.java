package victoriaslmn.android.viper.sample.presentation.injection;

import javax.inject.Singleton;

import dagger.Component;
import victoriaslmn.android.viper.sample.presentation.messages.bycontact.ByContactMessagesPresenter;
import victoriaslmn.android.viper.sample.presentation.messages.chats.ChatsPresenter;

@Singleton
@Component(modules = {PresentationModule.class, DataModule.class})
public interface PresentersComponent {
    void inject(ChatsPresenter chatsPresenter);

    void inject(ByContactMessagesPresenter byContactMessagesPresenter);
}
