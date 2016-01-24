package victoriaslmn.android.viper.sample.presentation.injection;

public class Injector {
    private static PresentersComponent presentersComponent;

    public static void setPresentersComponent(PresentersComponent presenterComponent) {
        Injector.presentersComponent = presenterComponent;
    }

    public static PresentersComponent getPresentersComponent() {
        return presentersComponent;
    }
}
