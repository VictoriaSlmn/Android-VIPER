package victoriaslmn.android.viper.sample.domain.note;

import java.util.List;

import rx.Observable;
import victoriaslmn.android.viper.sample.domain.note.list.Note;

public interface NotesDataProvider {
    Observable<List<Note>> getAllNotes();
}
