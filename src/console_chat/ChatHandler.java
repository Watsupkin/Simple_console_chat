package console_chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ChatHandler {

    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Message> messages = new ArrayList<>();
    BufferedReader reader;

    ChatHandler() throws IOException {
        users = new ArrayList<>();
        System.out.println("******************************" +
                "\n* Welcome to chat *" +
                "\n******************************" +
                "\n login - to join chat" +
                "\n exit - to exit" +
                "\n disc - to log out of chat");
        reader = new BufferedReader(new InputStreamReader(System.in));
        var ans = reader.readLine();
        if (ans.equalsIgnoreCase("login")) {
            login();
        } else if (ans.equalsIgnoreCase("exit")) {
            System.exit(0);
        } else {
            System.out.println("unknown command");
            new ChatHandler();
        }
    }

    public void login() throws IOException {
        System.out.println("Enter your login: ");
        var answer = reader.readLine();
        if (users.size() > 0) {
            for (User u : users) {
                if (u.getLogin().equals(answer)) {
                    if (!u.isOnline()) u.setOnline(true);
                    new ChatWindow(u);
                }
            }
        }
        User user = new User(1, answer);
        user.setOnline(true);
        users.add(user);
        new ChatWindow(user);
    }

    class ChatWindow {
        ChatWindow(User user) throws IOException {
            System.out.println("******** Chat-history ********" +
                    getHistory() +
                    "******************************");
            System.out.println("******************************\n"
                    .concat(getOnline()).concat("******************************"));
            reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                var answer = reader.readLine();
                if (!answer.equalsIgnoreCase("login") &&
                        !answer.equalsIgnoreCase("disc")) {
                    Message message = new Message(answer, user);
                    messages.add(message);
                }
                if (answer.equalsIgnoreCase("disc")) {
                    user.setOnline(false);
                    System.out.println(user.getLogin().concat(" disconnected"));
                    login();
                } else if (answer.equalsIgnoreCase("login")) {
                    login();
                } else if (answer.equalsIgnoreCase("exit")) System.exit(0);
            }
        }
    }

    public String getHistory() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        for (Message message : messages) {
            builder.append(message).append("\n");
        }
        return builder.toString();
    }

    public String getOnline() {
        StringBuilder builder = new StringBuilder();
        for (User user : users) {
            builder.append(user.getLogin()).append(" is ").append(user.getOnline()).append("\n");
        }
        return builder.toString();
    }
}
