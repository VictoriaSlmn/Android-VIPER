package victoriaslmn.android.viper.sample;


import android.app.Application;

import victoriaslmn.android.viper.sample.presentation.injection.DaggerPresentersComponent;
import victoriaslmn.android.viper.sample.presentation.injection.DataModule;
import victoriaslmn.android.viper.sample.presentation.injection.DomainModule;
import victoriaslmn.android.viper.sample.presentation.injection.Injector;
import victoriaslmn.android.viper.sample.presentation.injection.PresentationModule;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Injector.setPresentersComponent(
                DaggerPresentersComponent
                        .builder()
                        .dataModule(new DataModule())
                        .domainModule(new DomainModule())
                        .presentationModule(new PresentationModule())
                        .build());
    }
}
