package edu.neu.HW14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class SignUpWindow {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton signUpButton;
    private static Map<String, String> userDatabase = new HashMap<>();

    public SignUpWindow() {
        frame = new JFrame("Sign Up");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(3, 2));

        frame.add(new JLabel("Username:"));
        usernameField = new JTextField();
        frame.add(usernameField);

        frame.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        frame.add(passwordField);

        signUpButton = new JButton("Create Account");
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();

                if (!username.isEmpty() && !password.isEmpty()) {
                    if (!userDatabase.containsKey(username)) {
                        userDatabase.put(username, password);
                        JOptionPane.showMessageDialog(frame, "Account created successfully!");
                        frame.dispose(); // Close the sign-up window
                        new LoginWindow(); // Open the login window
                    } else {
                        JOptionPane.showMessageDialog(frame, "Username already exists. Please choose another.");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Username and password cannot be empty.");
                }
            }
        });
        frame.add(signUpButton);

        frame.setVisible(true);
    }

    public static boolean validateUser(String username, String password) {
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }
}
