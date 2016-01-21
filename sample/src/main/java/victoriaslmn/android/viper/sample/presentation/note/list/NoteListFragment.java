package victoriaslmn.android.viper.sample.presentation.note.list;

import victoriaslmn.android.viper.sample.R;
import victoriaslmn.android.viper.sample.presentation.common.BaseFragment;

public class NoteListFragment extends BaseFragment<NoteListPresenter> implements NoteListView {
    @Override
    public int getTitle() {
        return R.string.my_notes;
    }
}
