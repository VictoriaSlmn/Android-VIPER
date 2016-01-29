package victoriaslmn.android.viper.sample.presentation.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.google.common.base.Preconditions;

import butterknife.Bind;
import victoriaslmn.android.viper.sample.R;
import victoriaslmn.android.viper.sample.domain.contacts.Contact;
import victoriaslmn.android.viper.sample.presentation.common.BaseActivity;
import victoriaslmn.android.viper.sample.presentation.common.Layout;
import victoriaslmn.android.viper.sample.presentation.injection.DaggerMainActivityComponent;
import victoriaslmn.android.viper.sample.presentation.injection.DataModule;
import victoriaslmn.android.viper.sample.presentation.injection.DomainModule;
import victoriaslmn.android.viper.sample.presentation.injection.MainActivityComponent;
import victoriaslmn.android.viper.sample.presentation.main.chats.ChatsFragment;
import victoriaslmn.android.viper.sample.presentation.main.common.BaseMainFragment;
import victoriaslmn.android.viper.sample.presentation.main.contacts.ContactsFragment;
import victoriaslmn.android.viper.sample.presentation.main.messages.MessagesFragment;

@Layout(id = R.layout.activity_main)
public class MainActivity extends BaseActivity implements MainRouter {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.fab)
    FloatingActionButton floatingActionButton;

    private MainActivityComponent mainActivityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        mainActivityComponent =
                DaggerMainActivityComponent
                        .builder()
                        .dataModule(new DataModule())
                        .domainModule(new DomainModule())
                        .build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            addBackStack(new ChatsFragment());
        }
        return super.onCreateOptionsMenu(menu);
    }

    private void addBackStack(BaseMainFragment fragment) {
        Preconditions.checkNotNull(fragment);
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.content, fragment);
        tx.addToBackStack(fragment.getFragmentName());
        tx.commit();
    }

    public void resolveFab(BaseMainFragment fragment) {
        if (fragment.getFabButtonIcon() > 0) {
            floatingActionButton.setImageResource(fragment.getFabButtonIcon());
            floatingActionButton.setVisibility(View.VISIBLE);
            floatingActionButton.setOnClickListener(fragment.getFabButtonAction());
        } else {
            floatingActionButton.setVisibility(View.GONE);
            floatingActionButton.setOnClickListener(null);
        }

    }

    public void resolveToolbar(BaseMainFragment fragment) {
        toolbar.setTitle(fragment.getTitle());
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            toolbar.setNavigationIcon(R.mipmap.ic_arrow_back_white_24dp);
            toolbar.setNavigationOnClickListener(v -> onBackPressed());
        } else {
            toolbar.setNavigationIcon(null);
            toolbar.setNavigationOnClickListener(null);
        }
    }

    @Override
    public void showMessages(Contact contact) {
        addBackStack(MessagesFragment.newInstance(contact));
    }

    @Override
    public void openContacts() {
        addBackStack(new ContactsFragment());
    }

    public MainActivityComponent getMainActivityComponent() {
        return mainActivityComponent;
    }
}
