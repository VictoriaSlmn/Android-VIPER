package victoriaslmn.android.viper.sample.presentation.injection;

import dagger.Module;
import dagger.Provides;
import victoriaslmn.android.viper.sample.data.ContactsDataProviderImpl;
import victoriaslmn.android.viper.sample.data.MessagesDataProviderImpl;
import victoriaslmn.android.viper.sample.domain.contacts.ContactsDataProvider;
import victoriaslmn.android.viper.sample.domain.messages.MessagesDataProvider;

@Module
public class DataModule {

    @Provides
    public MessagesDataProvider provideNotesDataProvider() {
        return new MessagesDataProviderImpl();
    }

    @Provides
    public ContactsDataProvider provideMarksDataProvider() {
        return new ContactsDataProviderImpl();
    }
}
