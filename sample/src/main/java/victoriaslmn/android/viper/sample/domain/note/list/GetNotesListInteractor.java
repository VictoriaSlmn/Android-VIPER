package victoriaslmn.android.viper.sample.domain.note.list;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import victoriaslmn.android.viper.sample.domain.common.Interactor;
import victoriaslmn.android.viper.sample.domain.note.NotesDataProvider;

public class GetNotesListInteractor extends Interactor<List<Note>, Void> {
    @Inject
    NotesDataProvider notesDataProvider;

    @Override
    protected Observable<List<Note>> buildObservable(Void parameter) {
        return notesDataProvider.getAllNotes();
    }

    @Override
    protected void inject() {
        injectionComponent.inject(this);
    }
}
