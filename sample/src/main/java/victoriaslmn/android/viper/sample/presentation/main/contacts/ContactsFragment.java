package victoriaslmn.android.viper.sample.presentation.main.contacts;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import victoriaslmn.android.viper.sample.R;
import victoriaslmn.android.viper.sample.domain.contacts.Contact;
import victoriaslmn.android.viper.sample.presentation.common.BasePresenter;
import victoriaslmn.android.viper.sample.presentation.common.Layout;
import victoriaslmn.android.viper.sample.presentation.main.common.BaseMainFragment;

@Layout(id = R.layout.recycler_view)
public class ContactsFragment extends BaseMainFragment implements ContactsView {

    @Inject
    ContactsPresenter contactsPresenter;

    @Bind(R.id.chats_recycler_view)
    RecyclerView recyclerView;

    @Override
    public String getTitle() {
        return getString(R.string.contacts);
    }

    @Override
    public int getFabButtonIcon() {
        return android.R.drawable.ic_input_add;
    }

    @Override
    public View.OnClickListener getFabButtonAction() {
        return null;
    }

    @Override
    public void setContacts(List<Contact> contacts) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ContactsAdapter contactsAdapter = new ContactsAdapter(contacts);
        contactsAdapter.setOnItemClickListener(view -> contactsPresenter.contactSelected((Contact) view.getTag()));
        recyclerView.setAdapter(contactsAdapter);
    }

    @NonNull
    @Override
    protected BasePresenter getPresenter() {
        return contactsPresenter;
    }

    @Override
    protected void inject() {
        getMainActivityComponent().inject(this);
    }
}
