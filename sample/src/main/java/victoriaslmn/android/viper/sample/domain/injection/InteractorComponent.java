package victoriaslmn.android.viper.sample.domain.injection;

import javax.inject.Singleton;

import dagger.Component;
import victoriaslmn.android.viper.sample.domain.note.list.GetNotesListInteractor;

@Singleton
@Component(modules = {DataModule.class})
public interface InteractorComponent {
    void inject(GetNotesListInteractor getNotesListInteractor);
}
