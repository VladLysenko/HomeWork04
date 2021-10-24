package HW04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {
    public Window() {
        setTitle("Net Chat");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(1000, 300, 600, 400);

        setLayout(new BorderLayout());
        JButton pushMessage = new JButton("Enter");
        JTextPane writeMessage = new JTextPane();
        JTextField messageWindow = new JTextField();
        setLayout(null);

        add (pushMessage);
        pushMessage.setBounds(500,310,70,45);

        add (writeMessage);
        writeMessage.setBounds(3,310,492,45);

        add (messageWindow);
        messageWindow.setBounds(3,5,579, 300);

        setVisible(true);

        pushMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messageWindow.setText("Me: " + writeMessage.getText());
                writeMessage.setText(null);
            }
        });
    }

    public static void main(String[] args) {
        new Window();
    }
}
