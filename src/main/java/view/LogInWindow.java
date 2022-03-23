package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LogInWindow
{
    private JFrame logInFrame = new JFrame("Welcome - Log In");

    private JPanel logInPanel;

    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;

    private JButton logInButton;
    private JButton registerButton;
    private JButton sendToAdminPageButton;

    public LogInWindow()
    {
        logInFrame.setSize(200, 100);

        logInPanel = new JPanel();

        logInPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
        logInPanel.setLayout(new GridLayout(4, 2, 10, 10));

        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        logInButton = new JButton("Log In");
        registerButton = new JButton("First time here? Register");
        sendToAdminPageButton = new JButton("Traveling Agency");

        logInPanel.add(usernameLabel);
        logInPanel.add(usernameField);
        logInPanel.add(passwordLabel);
        logInPanel.add(passwordField);
        logInPanel.add(logInButton);
        logInPanel.add(registerButton);
        logInPanel.add(sendToAdminPageButton);

        logInFrame.setLayout(new FlowLayout());
        logInFrame.add(logInPanel);
        logInFrame.setVisible(true);
        logInFrame.setLocationRelativeTo(null);
        logInFrame.pack();

        logInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JTextField getUsernameField()
    {
        return usernameField;
    }

    public JPasswordField getPasswordField()
    {
        return passwordField;
    }

    public void setVisible(boolean b)
    {
        logInFrame.setVisible(b);
    }

    public void logInButtonActionListener(ActionListener actionListener)
    {
        logInButton.addActionListener(actionListener);
    }

    public void registerButtonActionListener(ActionListener actionListener)
    {
        registerButton.addActionListener(actionListener);
    }

    public void adminButtonActionListener(ActionListener actionListener)
    {
        sendToAdminPageButton.addActionListener(actionListener);
    }

}
