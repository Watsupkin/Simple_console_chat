package swing_version;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SwingChat {
    JFrame mainMenu;
    JButton logIn, signIn, send, exit;
    JLabel welcome;
    static JTextArea chatText;
    JTextField text;
    ArrayList<User> users;
    ArrayList<String> userNames;

    SwingChat() {

        /**Создание главного меню*/
        users = new ArrayList<>();
        var listener = new Listener();
        mainMenu = new JFrame("CHAT");
        mainMenu.setBounds(new Rectangle(300, 300));
        mainMenu.setLayout(null);

        welcome = new JLabel("Welcome to super chat!");
        welcome.setBounds(70, 30, 150, 30);

        logIn = new JButton("log in");
        logIn.setBounds(70, 80, 150, 30);
        logIn.addActionListener(listener);

        signIn = new JButton("sign in");
        signIn.setBounds(70, 130, 150, 30);

        exit = new JButton("exit");
        exit.setBounds(70, 180, 150, 30);
        exit.addActionListener(listener);

        mainMenu.add(welcome);
        mainMenu.add(logIn);
        mainMenu.add(signIn);
        mainMenu.add(exit);

//        mainMenu.pack();
        mainMenu.setVisible(true);
        mainMenu.setLocationRelativeTo(null);
        mainMenu.setResizable(false);
        mainMenu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    /**Создание обработчика событий*/

    class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == logIn) {
                String ansName = JOptionPane.showInputDialog(mainMenu, "Enter yor login: ");
                User newUser;
                try {
                    newUser = getUser(ansName);
                    new ChatWindow(newUser);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else if (e.getSource() == exit) {
                System.exit(0);
            }
        }
    }

    /**Получение пользователя*/

    private User getUser(String userName) throws IOException {
//        User user = null;
        if (!checkUser(userName)) {
            User user = new User(userName, true);
            user.setOnline(true);
            users.add(user);
            writeFile(user);
            return user;
        } else {
            for (User u : users) {
                if (u.getUserName().equals(userName) && u.isOnline()) {
                    JOptionPane.showMessageDialog(mainMenu, "This user already online");
//                    return null;
                } else {
                    u.setOnline(true);
                    return u;
                }
            }
        }
        return null;
    }

    /**Проверка на существование юзера*/

    private boolean checkUser(String userName) throws FileNotFoundException {
        userNames = readFile();
        for (String name : userNames) {
            if (name.equals(userName)) {
                return true;
            }
        }
        return false;
    }

    /**Чтение списка имен юзеров из файла*/

    public ArrayList<String> readFile() throws FileNotFoundException {
        var sc = new Scanner("users.txt");
        while (sc.hasNextLine()) {
            userNames.add(sc.nextLine());
        }
        sc.close();
        return userNames;
    }

    /**Запись в файл имен новых юзеров*/

    public void writeFile(User user) throws IOException {

        String newUserName = user.getUserName();
        var writer = new FileWriter("users.txt", true);
        writer.write("\n" + newUserName);
        writer.flush();
    }

    /**Создание окна чата, для залогиневшегося пользователя*/

    public class ChatWindow {
        JFrame chatFrame;

        ChatWindow(User user) {
            chatFrame = new JFrame("Chat");
            JPanel supPanel = new JPanel(new BorderLayout());


            chatText = new JTextArea();
            chatText.setEditable(false);
            chatText.setLineWrap(true);

            final JScrollPane scrollPane = new JScrollPane(chatText);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            supPanel.add(scrollPane, BorderLayout.CENTER);

            send = new JButton("send");
            text = new JTextField();


            chatFrame.getContentPane().add(supPanel);
            chatFrame.setPreferredSize(new Dimension(350, 200));
            chatFrame.pack();
            chatFrame.setLocationRelativeTo(mainMenu);
            chatFrame.setVisible(true);
        }
    }
}