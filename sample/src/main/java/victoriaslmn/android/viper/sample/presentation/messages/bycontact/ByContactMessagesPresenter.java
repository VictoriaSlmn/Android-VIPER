package victoriaslmn.android.viper.sample.presentation.messages.bycontact;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import victoriaslmn.android.viper.sample.R;
import victoriaslmn.android.viper.sample.domain.contacts.Contact;
import victoriaslmn.android.viper.sample.domain.messages.GetMessagesByContactInteractor;
import victoriaslmn.android.viper.sample.domain.messages.Message;
import victoriaslmn.android.viper.sample.presentation.injection.Injector;
import victoriaslmn.android.viper.sample.presentation.messages.common.BaseMessagesPresenter;
import victoriaslmn.android.viper.sample.presentation.messages.common.TimeMapper;

public class ByContactMessagesPresenter extends BaseMessagesPresenter<ByContactMessagesView> {
    private Contact contact;
    private final List<MessageViewModel> viewModels = new ArrayList<>();

    @Inject
    GetMessagesByContactInteractor getMessagesByContactInteractor;

    public ByContactMessagesPresenter() {
        Injector.getPresentersComponent().inject(this);
    }

    public void init(@NonNull Contact contact) {
        this.contact = contact;
        getView().resolveTitle(contact.getName());
    }

    @Override
    public void onStart() {
        if (contact == null) {
            return;
        }
        getMessagesByContactInteractor.execute(contact, new Subscriber<List<Message>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                getView().showError(R.string.error);
            }

            @Override
            public void onNext(List<Message> messages) {
                if (messages.size() <= viewModels.size()) {
                    return;
                }
                int startSize = viewModels.size();
                for (int i = startSize; i < messages.size(); i++) {
                    viewModels.add(
                            new MessageViewModel(
                                    TimeMapper.transform(messages.get(i).getTimestamp()),
                                    messages.get(i).getContent()));
                }
                if (startSize == 0) {
                    getView().setMessages(viewModels);
                } else {
                    getView().showNewMessagesNotification();
                    getView().updateMessages();
                }
            }
        });
    }

    @Override
    public void onStop() {
        getMessagesByContactInteractor.unsubscribe();
    }
}
