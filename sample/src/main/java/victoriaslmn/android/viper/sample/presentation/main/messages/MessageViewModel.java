package victoriaslmn.android.viper.sample.presentation.main.messages;

public class MessageViewModel {
    private final String time;
    private final String message;

    public MessageViewModel(String time, String message) {
        this.time = time;
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }
}
