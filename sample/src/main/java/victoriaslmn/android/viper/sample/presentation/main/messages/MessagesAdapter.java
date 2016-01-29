package victoriaslmn.android.viper.sample.presentation.main.messages;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import victoriaslmn.android.viper.sample.R;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MessageViewHolder> {
    private final List<MessageViewModel> messageViewModels;

    public MessagesAdapter(List<MessageViewModel> messageViewModels) {
        this.messageViewModels = messageViewModels;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_view, parent, false);
        return new MessageViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        holder.bind(messageViewModels.get(position));
    }

    @Override
    public int getItemCount() {
        return messageViewModels.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.message_time)
        TextView messageTime;
        @Bind(R.id.message_text)
        TextView messageText;

        public MessageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(MessageViewModel model) {
            messageTime.setText(model.getTime());
            messageText.setText(model.getMessage());
        }
    }
}
