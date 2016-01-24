package victoriaslmn.android.viper.sample.presentation.messages.chats;

import java.util.List;

import victoriaslmn.android.viper.sample.presentation.messages.common.BaseMessagesView;

public interface ChatsView extends BaseMessagesView {
    void setChats(List<ChatViewModel> chatViewModels);

    void updateChats();
}
