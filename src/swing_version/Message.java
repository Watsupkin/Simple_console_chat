package swing_version;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Message {
//    private User fromUser;
    private String text;
    private String dateOfSent;

    public Message(String text) {
        this.text = text;
        this.dateOfSent = getTime();
    }

    private String getTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(calendar.getTime());
    }

    public String getText() {
        return text;
    }

    public String getDateOfSent() {
        return dateOfSent;
    }
}
