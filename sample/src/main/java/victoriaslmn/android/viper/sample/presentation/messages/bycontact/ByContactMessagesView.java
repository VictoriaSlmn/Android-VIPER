package victoriaslmn.android.viper.sample.presentation.messages.bycontact;

import java.util.List;

import victoriaslmn.android.viper.sample.presentation.messages.common.BaseMessagesView;

public interface ByContactMessagesView extends BaseMessagesView {
    void resolveTitle(String name);

    void setMessages(List<MessageViewModel> viewModels);

    void updateMessages();
}
