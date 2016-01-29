package victoriaslmn.android.viper.sample.presentation.main.messages;

import java.util.List;

import victoriaslmn.android.viper.sample.presentation.main.common.BaseMainView;

public interface MessagesView extends BaseMainView {
    void resolveTitle(String name);

    void setMessages(List<MessageViewModel> viewModels);

    void updateMessages();
}
