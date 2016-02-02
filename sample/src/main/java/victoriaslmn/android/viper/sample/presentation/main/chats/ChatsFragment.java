package victoriaslmn.android.viper.sample.presentation.main.chats;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import victoriaslmn.android.viper.sample.R;
import victoriaslmn.android.viper.sample.presentation.common.BasePresenter;
import victoriaslmn.android.viper.sample.presentation.common.Layout;
import victoriaslmn.android.viper.sample.presentation.main.common.BaseMainFragment;

@Layout(id = R.layout.recycler_view)
public class ChatsFragment extends BaseMainFragment implements ChatsView {

    @Inject
    ChatsPresenter chatsPresenter;

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
        return v -> chatsPresenter.openContacts();
    }

    @Override
    public void setChats(List<ChatViewModel> chatViewModels) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        chatsAdapter = new ChatsAdapter(chatViewModels);
        chatsAdapter.setOnItemClickListener(view -> chatsPresenter.chatSelected((ChatViewModel)view.getTag()));
        recyclerView.setAdapter(chatsAdapter);
    }

    @Override
    public void updateChats() {
        chatsAdapter.notifyDataSetChanged();
    }

    @NonNull
    @Override
    protected BasePresenter getPresenter() {
        return chatsPresenter;
    }

    @Override
    protected void inject() {
        getMainActivityComponent().inject(this);
    }
}
