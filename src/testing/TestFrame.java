package testing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TestFrame extends JFrame {

    private static final String TEXT = "You can get a blog started in less time than \n"
            + " it takes you to read this sentence. All you need is an email \n"
            + " address. You’ll get your own WordPress.com address \n"
            + " (like you.wordpress.com), a selection of great free \n"
            + " and customizable designs for your blog (we call them themes), \n"
            + " 3 gigabytes of file storage (that’s about 2,500 pictures!) \n"
            + " and all the other great features listed here. \n"
            + " You can blog as much as you want for free, \n"
            + " your blog can be public to the world or private \n"
            + " for just your friends, and our premium features \n"
            + "are completely optional.";

    public static void createGUI() {
        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setText(TEXT);
        textArea.setCaretPosition(0);

        final JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        mainPanel.add(panel, BorderLayout.SOUTH);

        frame.getContentPane().add(mainPanel);
        frame.setPreferredSize(new Dimension(350, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
       createGUI();
    }
}
