package victoriaslmn.android.viper.sample.data;

import java.util.List;

import rx.Observable;
import victoriaslmn.android.viper.sample.domain.note.NotesDataProvider;
import victoriaslmn.android.viper.sample.domain.note.list.Note;

public class NotesDataProviderImpl implements NotesDataProvider {
    @Override
    public Observable<List<Note>> getAllNotes() {
        return null;
    }
}
