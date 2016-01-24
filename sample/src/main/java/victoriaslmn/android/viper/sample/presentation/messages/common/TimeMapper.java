package victoriaslmn.android.viper.sample.presentation.messages.common;


import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeMapper {
    public static String transform(long timestamp){
        return SimpleDateFormat.getDateTimeInstance().format(new Date(timestamp));
    }
}
