package victoriaslmn.android.viper.sample.presentation.injection;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import victoriaslmn.android.viper.sample.data.ContactsDataProviderImpl;
import victoriaslmn.android.viper.sample.data.MessagesDataProviderImpl;
import victoriaslmn.android.viper.sample.domain.contacts.ContactsDataProvider;
import victoriaslmn.android.viper.sample.domain.messages.MessagesDataProvider;

@Module
public class DataModule {

    @Singleton
    @Provides
    public MessagesDataProvider provideNotesDataProvider() {
        return new MessagesDataProviderImpl();
    }

    @Singleton
    @Provides
    public ContactsDataProvider provideMarksDataProvider() {
        return new ContactsDataProviderImpl();
    }
}
