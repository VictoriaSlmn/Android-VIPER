package victoriaslmn.android.viper.sample.presentation.main.chats;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import victoriaslmn.android.viper.sample.R;

public class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.ChatViewHolder> {
    private final List<ChatViewModel> chatViewModels;
    private View.OnClickListener onItemClickListener;

    public ChatsAdapter(List<ChatViewModel> chatViewModels) {
        this.chatViewModels = chatViewModels;
    }

    @Override
    public ChatViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_view, parent, false);
        return new ChatViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(ChatViewHolder holder, int position) {
        holder.bind(chatViewModels.get(position));
    }

    @Override
    public int getItemCount() {
        return chatViewModels.size();
    }

    public void setOnItemClickListener(View.OnClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.sender_name)
        TextView senderName;
        @Bind(R.id.last_message_time)
        TextView lastMessageTime;
        @Bind(R.id.last_message)
        TextView lastMessage;

        public ChatViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(onItemClickListener);
        }

        public void bind(ChatViewModel model) {
            senderName.setText(model.getSenderName());
            lastMessageTime.setText(model.getTimeLastMessage());
            lastMessage.setText(model.getLastMessage());
            lastMessageTime.setBackgroundResource(getMessageBackground(model));
            lastMessage.setBackgroundResource(getMessageBackground(model));
            itemView.setTag(model);
        }

        private int getMessageBackground(ChatViewModel model) {
            return model.isHasNotReadMessages() ? R.color.colorPrimaryLight : android.R.color.transparent;
        }
    }
}
