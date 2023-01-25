package console_chat;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Message {
    private String dateOfSend;
    private String text;
    private User from;

    public Message(String text, User from) {
        this.dateOfSend = getDateOfSend();
        this.text = text;
        this.from = from;
    }

    public String getDateOfSend() {
        Calendar calendar = Calendar.getInstance();
        String formattedDate = new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(calendar.getTime());
        return formattedDate;
    }

    public String getFrom() {
        return from.getLogin();
    }

    @Override
    public String toString() {
        return dateOfSend + " " + getFrom() + ": " + text;
    }
}
