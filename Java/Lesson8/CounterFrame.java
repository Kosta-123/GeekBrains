package Lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CounterFrame extends JFrame {
    private int counter;

    public CounterFrame(int initialValue){
        setBounds(500,500,300,120);
        setTitle("Numbers Counter");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Font font = new Font("Arial", Font.ITALIC, 40);

        JTextField counterBox = new JTextField();
        counterBox.setFont(font);
        counterBox.setHorizontalAlignment(SwingConstants.CENTER);
        add(counterBox, BorderLayout.CENTER);
        counter = initialValue;
        counterBox.setText(String.valueOf(counter));

        JButton decreaseButton = new JButton("<");
        decreaseButton.setFont(font);
        add(decreaseButton, BorderLayout.WEST);

        JButton increaseButton = new JButton(">");
        increaseButton.setFont(font);
        add (increaseButton, BorderLayout.EAST);

        counterBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                counter = Integer.parseInt(counterBox.getText());
                counterBox.setText(String.valueOf(counter));
            }
        });


                decreaseButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        counter--;
                        counterBox.setText(String.valueOf(counter));
                    }
                });

                increaseButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        counter++;
                        counterBox.setText(String.valueOf(counter));
                    }
                });

                setVisible(true);


            }

            public static void main(String[] args) {

                new CounterFrame(0);
            }
        }