import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CreateAccount implements ActionListener {

    JFrame frame = new JFrame();
    JLabel createTextLabel = new JLabel("");

    JLabel userIDLabel = new JLabel("userID:");
    JLabel userPasswordLabel = new JLabel("password:");
    JLabel messageLabel = new JLabel();

    JTextField userIDField = new JTextField();
    JTextField userPasswordField = new JTextField();

    JButton createAccountButton = new JButton("Confirm");

    HashMap<String, String> logininfo = new HashMap<String, String>();

    CreateAccount(HashMap<String, String> loginInfoOriginal) {

        createTextLabel.setBounds(10, 0, 400, 100);
        createTextLabel.setFont(new Font(null, Font.PLAIN, 20));
        createTextLabel.setText("Hello, setup your account here! ");

        userIDLabel.setBounds(50, 100, 75, 25); //x,y,width,height
        userPasswordLabel.setBounds(50, 150, 75, 25); //x,y,width,height		

        messageLabel.setBounds(100, 300, 350, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 17));

        userIDField.setBounds(125, 100, 200, 25);
        userPasswordField.setBounds(125, 150, 200, 25);

        createAccountButton.setBounds(125, 250, 100, 25);
        createAccountButton.setFocusable(false);
        createAccountButton.addActionListener(this);

        frame.add(userIDLabel);
        frame.add(userPasswordLabel);
        frame.add(createTextLabel);
        frame.add(messageLabel);
        frame.add(userIDField);
        frame.add(userPasswordField);
        frame.add(createAccountButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 450); //width,height
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createAccountButton) {

            String userID = userIDField.getText();
            String password = userPasswordField.getText();

            if (userID.isEmpty() || password.isEmpty()) {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Please enter both username and password");

            } else if (logininfo.containsKey(userID)) {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Username is taken,use a different one. ");
            } else {
                logininfo.put(userID, password);
                System.out.println("User information added to loginInfo: " + logininfo);
                frame.dispose();
                LoginPage loginPage = new LoginPage(logininfo);
            }
        }
    }

}