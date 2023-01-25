package console_chat;

public class User {
    private int id;
    private String login;
    private boolean isOnline;

    public User(int id, String login) {
        this.id = id;
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public String getOnline() {
        return isOnline() ? "online" : "offline";
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}
