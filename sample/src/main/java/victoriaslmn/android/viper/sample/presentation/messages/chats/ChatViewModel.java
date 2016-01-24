package victoriaslmn.android.viper.sample.presentation.messages.chats;

import java.text.SimpleDateFormat;
import java.util.Date;

import victoriaslmn.android.viper.sample.domain.messages.Message;
import victoriaslmn.android.viper.sample.presentation.messages.common.TimeMapper;

public class ChatViewModel {
    public static ChatViewModel createAllRead(Message message) {
        return create(message, false);
    }

    public static ChatViewModel createHasNotRead(Message message) {
        return create(message, true);
    }

    private static ChatViewModel create(Message message, boolean hasNotReadMessages) {
        return new ChatViewModel(
                message.getContact().getId(),
                message.getContact().getName(),
                message,
                hasNotReadMessages);
    }

    public static boolean equals(ChatViewModel chat, Message message) {
        return chat.getId() == message.getContact().getId();
    }

    private final int id;
    private final String senderName;
    private Message lastMessage;
    private boolean hasNotReadMessages;

    private ChatViewModel(int id, String senderName, Message lastMessage, boolean hasNotReadMessages) {
        this.id = id;
        this.senderName = senderName;
        this.lastMessage = lastMessage;
        this.hasNotReadMessages = hasNotReadMessages;
    }

    public String getSenderName() {
        return senderName;
    }

    public int getId() {
        return id;
    }

    public int getLastMessageId() {
        return lastMessage.getId();
    }

    public String getLastMessage() {
        return lastMessage.getContent();
    }

    public String getTimeLastMessage() {
        return TimeMapper.transform(getTimestamp());
    }

    public boolean isHasNotReadMessages() {
        return hasNotReadMessages;
    }

    public void updateLastMessage(Message message) {
        this.lastMessage = message;
        this.hasNotReadMessages = true;
    }

    public long getTimestamp() {
        return lastMessage.getTimestamp();
    }
}
