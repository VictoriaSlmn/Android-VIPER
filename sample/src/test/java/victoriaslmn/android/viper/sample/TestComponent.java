package victoriaslmn.android.viper.sample;

import javax.inject.Singleton;

import dagger.Component;
import victoriaslmn.android.viper.sample.presentation.injection.DataModule;
import victoriaslmn.android.viper.sample.presentation.injection.DomainModule;
import victoriaslmn.android.viper.sample.presentation.injection.PresentationModule;
import victoriaslmn.android.viper.sample.presentation.messages.bycontact.ByContactMessagesPresenter;
import victoriaslmn.android.viper.sample.presentation.messages.chats.ChatsPresenter;

@Singleton
@Component()
public interface TestComponent {
}
