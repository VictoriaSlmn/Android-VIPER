package victoriaslmn.android.viper.sample.domain.injection;

import dagger.Module;
import dagger.Provides;
import victoriaslmn.android.viper.sample.data.MarksDataProviderImpl;
import victoriaslmn.android.viper.sample.data.NotesDataProviderImpl;
import victoriaslmn.android.viper.sample.domain.mark.MarksDataProvider;
import victoriaslmn.android.viper.sample.domain.note.NotesDataProvider;

@Module
public class DataModule {

    @Provides
    public NotesDataProvider provideNotesDataProvider() {
        return new NotesDataProviderImpl();
    }

    @Provides
    public MarksDataProvider provideMarksDataProvider() {
        return new MarksDataProviderImpl();
    }
}
