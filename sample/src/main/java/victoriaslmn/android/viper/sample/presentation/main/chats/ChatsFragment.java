package victoriaslmn.android.viper.sample.presentation.main.chats;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import butterknife.Bind;
import victoriaslmn.android.viper.sample.R;
import victoriaslmn.android.viper.sample.presentation.common.Layout;
import victoriaslmn.android.viper.sample.presentation.main.common.BaseMainFragment;

@Layout(id = R.layout.recycler_view)
public class ChatsFragment extends BaseMainFragment<ChatsPresenter> implements ChatsView {

    @Bind(R.id.chats_recycler_view)
    RecyclerView recyclerView;

    private ChatsAdapter chatsAdapter;

    @Override
    public String getTitle() {
        return getString(R.string.chats);
    }

    @Override
    public int getFabButtonIcon() {
        return R.mipmap.ic_supervisor_account_white_24dp;
    }

    @Override
    public View.OnClickListener getFabButtonAction() {
        return null;
    }

    @Override
    public void setChats(List<ChatViewModel> chatViewModels) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        chatsAdapter = new ChatsAdapter(chatViewModels);
        chatsAdapter.setOnItemClickListener(view -> getPresenter().chatSelected((ChatViewModel)view.getTag()));
        recyclerView.setAdapter(chatsAdapter);
    }

    @Override
    protected void injectPresenter() {
        getMainActivityComponent().inject(getPresenter());
    }

    @Override
    public void updateChats() {
        chatsAdapter.notifyDataSetChanged();
    }
}
