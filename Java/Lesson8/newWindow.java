package Lesson8;

import javax.swing.*;
import java.awt.*;

public class newWindow extends JFrame {
    public newWindow() {
    setTitle ("Test Window");
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setBounds(250, 250, 500, 400);
    JButton button1 = new JButton("Button #1");
    add (button1, BorderLayout.EAST);
    JButton button2 = new JButton("Button #2");
    add (button2, BorderLayout.WEST);
        JTextArea textField = new JTextArea();
        textField.setBounds(20, 20, 120, 50);
        add (textField, BorderLayout.CENTER);
        setVisible(true);


    }

    public static void main(String[] args) {

        new newWindow();
    }
}
