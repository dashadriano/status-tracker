import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class COVIDtracker {
    public static void main(String[] args) {
        JFrame frame = new JFrame("COVID Status Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Panel Dimensions
        JPanel namesPanel = new JPanel();
        namesPanel.setLayout(new GridLayout(10, 2, 5, 5));

        String[] names = {" ", " ", " ", " ", " ", " ", " ", " ", " ", " "};
        JTextField[] nameFields = new JTextField[10];
        JLabel[] status = new JLabel[10];
        JButton[] buttons = new JButton[10];

        // Label Color Coding Switch Toggle
        for (int i = 0; i < 10; i++) {
            nameFields[i] = new JTextField(names[i]);
            status[i] = new JLabel("NULL", SwingConstants.CENTER);
            status[i].setForeground(Color.GRAY);
            buttons[i] = new JButton("Toggle");

            int index = i;
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (status[index].getText().equals("NULL")) {
                        status[index].setText("Positive");
                        status[index].setForeground(Color.RED);
                    }
                    if (status[index].getText().equals("Positive")) {
                        status[index].setText("Negative");
                        status[index].setForeground(Color.GREEN);
                    } else {
                        status[index].setText("Positive");
                        status[index].setForeground(Color.RED);
                    }
                }
            });

            namesPanel.add(nameFields[i]);
            namesPanel.add(status[i]);
            namesPanel.add(buttons[i]);
        }

        // Frame Instance Calls
        frame.add(namesPanel, BorderLayout.CENTER);

        frame.setPreferredSize(new Dimension(400, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}