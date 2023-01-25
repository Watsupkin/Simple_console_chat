package swing_version;

import java.io.Serializable;

public class User implements Serializable {
    //    private int id;
    private String userName;
    private boolean isOnline;


    public User(String userName, boolean isOnline) {
//        this.id = id;
        this.userName = userName;
        this.isOnline = isOnline;
    }

    public String sendMessage(String textOfMessage) {
        Message message = new Message(textOfMessage);
        StringBuilder builder = new StringBuilder();
        builder.append(message.getDateOfSent())
                .append(" ").append(getUserName())
                .append(" - ").append(message.getText());
        return builder.toString();
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", isOnline=" + isOnline +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}
