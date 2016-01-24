package victoriaslmn.android.viper.sample.presentation.messages;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import com.google.common.base.Preconditions;

import butterknife.Bind;
import victoriaslmn.android.viper.sample.R;
import victoriaslmn.android.viper.sample.presentation.common.BaseActivity;
import victoriaslmn.android.viper.sample.presentation.common.Layout;
import victoriaslmn.android.viper.sample.presentation.messages.common.BaseMessagesFragment;
import victoriaslmn.android.viper.sample.presentation.messages.last.LastMessagesFragment;

@Layout(id = R.layout.activity_main)
public class MessagesActivity extends BaseActivity implements MessagesRouter {
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);
        addBackStack(new LastMessagesFragment());
//        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show());
    }

    private void addBackStack(BaseMessagesFragment fragment) {
        Preconditions.checkNotNull(fragment);
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.content, fragment);
        tx.addToBackStack(fragment.getFragmentName());
        tx.commit();
        resolveToolbar(fragment);
    }

    private void resolveToolbar(BaseMessagesFragment fragment) {
        toolbar.setTitle(fragment.getTitle());
    }
}
