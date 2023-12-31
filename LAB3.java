package edu.neu.mgen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LAB3 extends JFrame {

    private JComboBox<String> colorDropdown;
    private JTextField colorOutputField;
    private JPanel circlePanel;
    private Color currentColor = Color.WHITE;

public LAB3() {
        createComponents();
        layoutComponents();
        addListeners();
        setFrameProperties();
    }

    private void createComponents() {
        colorDropdown = new JComboBox<>(new String[]{"Red", "Blue", "Green"});
        colorOutputField = new JTextField(10);
        circlePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(currentColor);
                g.fillOval(50, 50, 100, 100); 
            }
        };
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());
        add(circlePanel, BorderLayout.CENTER);
        add(colorDropdown, BorderLayout.NORTH);
        add(colorOutputField, BorderLayout.SOUTH);
    }

    private void addListeners() {
        colorDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColor = (String) colorDropdown.getSelectedItem();
                switch (selectedColor) {
                    case "Red":
                        currentColor = Color.RED;
                        break;
                    case "Blue":
                        currentColor = Color.BLUE;
                        break;
                    case "Green":
                        currentColor = Color.GREEN;
                        break;
                }
                colorOutputField.setText(selectedColor);
                circlePanel.repaint();
            }
        });
    }

    private void setFrameProperties() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LAB3();
            }
        });
    }
}
