package victoriaslmn.android.viper.sample.presentation.main.contacts;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import butterknife.Bind;
import victoriaslmn.android.viper.sample.R;
import victoriaslmn.android.viper.sample.domain.contacts.Contact;
import victoriaslmn.android.viper.sample.presentation.common.Layout;
import victoriaslmn.android.viper.sample.presentation.main.common.BaseMainFragment;

@Layout(id = R.layout.recycler_view)
public class ContactsFragment extends BaseMainFragment<ContactsPresenter> implements ContactsView {

    @Bind(R.id.chats_recycler_view)
    RecyclerView recyclerView;

    @Override
    protected void injectPresenter() {
        getMainActivityComponent().inject(getPresenter());
    }

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
        contactsAdapter.setOnItemClickListener(view -> getPresenter().contactSelected((Contact) view.getTag()));
        recyclerView.setAdapter(contactsAdapter);
    }
}
