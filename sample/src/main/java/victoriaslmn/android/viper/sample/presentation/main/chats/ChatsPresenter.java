package victoriaslmn.android.viper.sample.presentation.main.chats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import victoriaslmn.android.viper.sample.R;
import victoriaslmn.android.viper.sample.domain.contacts.Contact;
import victoriaslmn.android.viper.sample.domain.messages.GetChatsInteractor;
import victoriaslmn.android.viper.sample.domain.messages.Message;
import victoriaslmn.android.viper.sample.presentation.main.common.BaseMainPresenter;

public class ChatsPresenter extends BaseMainPresenter<ChatsView> {

    private final List<ChatViewModel> chatViewModels = new ArrayList<>();

    @Inject
    GetChatsInteractor getChatsInteractor;

    public ChatsPresenter() {
        getView().getMainActivityComponent().inject(this);
    }

    @Override
    public void onStart() {
        getChatsInteractor.execute(new Subscriber<List<Message>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                getView().showError(R.string.error);
            }

            @Override
            public void onNext(List<Message> messages) {
                if (chatViewModels.isEmpty()) {
                    chatViewModels.addAll(convert(messages));
                    getView().setChats(chatViewModels);
                    return;
                }
                int newUpdateChats = updateChats(messages);
                if (newUpdateChats > 0) {
                    getView().showNewMessagesNotification();
                    getView().updateChats();
                }
            }
        });
    }

    private int updateChats(List<Message> messages) {
        int result = 0;
        for (Message message : messages) {
            boolean containsInChat = false;
            for (ChatViewModel chat : chatViewModels) {
                if (!ChatViewModel.equals(chat, message)) {
                    continue;
                }
                containsInChat = true;
                if (chat.getLastMessageId() != message.getId()) {
                    chat.updateLastMessage(message);
                    result++;
                }
                break;
            }
            if (!containsInChat) {
                chatViewModels.add(ChatViewModel.createHasNotRead(message));
                result++;
            }
        }
        Collections.sort(chatViewModels, (chat1, chat2) -> {
            if (chat1.getTimestamp() == chat2.getTimestamp()) {
                return 0;
            }
            return chat1.getTimestamp() > chat2.getTimestamp() ? -1 : 1;

        });
        return result;
    }

    private List<ChatViewModel> convert(List<Message> messages) {
        List<ChatViewModel> chatViewModels = new ArrayList<>();
        for (Message message : messages) {
            chatViewModels.add(ChatViewModel.createAllRead(message));
        }
        return chatViewModels;
    }

    @Override
    public void onStop() {
        getChatsInteractor.unsubscribe();
    }

    public void chatSelected(ChatViewModel tag) {
        getRouter().showChatDetails(new Contact(tag.getId(), tag.getSenderName()));
    }
}
