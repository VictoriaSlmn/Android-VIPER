package victoriaslmn.android.viper.sample.presentation.main.chats;

import java.util.List;

import victoriaslmn.android.viper.sample.presentation.main.common.BaseMainView;

public interface ChatsView extends BaseMainView {
    void setChats(List<ChatViewModel> chatViewModels);

    void updateChats();
}
