package victoriaslmn.android.viper.sample.presentation.messages.last;

import victoriaslmn.android.viper.sample.R;
import victoriaslmn.android.viper.sample.presentation.messages.common.BaseMessagesFragment;

public class LastMessagesFragment extends BaseMessagesFragment<LastMessagesPresenter> implements LastMessagesView {
    @Override
    public int getTitle() {
        return R.string.chats;
    }
}
