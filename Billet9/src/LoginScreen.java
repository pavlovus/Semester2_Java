import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame {
    private static final String CORRECT_LOGIN = "Pavlo";
    private static final String CORRECT_PASSWORD = "Vus";

    private JTextField loginField;
    private JPasswordField passwordField;

    public LoginScreen() {
        super("Введіть логін та пароль");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        this.setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel loginLabel = new JLabel("Login:");
        loginField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginButton.setPreferredSize(new Dimension(100, 30));
        loginButton.setBorder(null);
        loginButton.setFont(new Font("Arial", Font.PLAIN, 18));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(Color.BLACK);

        inputPanel.add(loginLabel);
        inputPanel.add(loginField);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordField);

        buttonPanel.add(loginButton);

        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authenticate();
            }
        });
    }

    private void authenticate() {
        String inputLogin = loginField.getText();
        String inputPassword = new String(passwordField.getPassword());
        if (CORRECT_LOGIN.equals(inputLogin) && CORRECT_PASSWORD.equals(inputPassword)) {
            JOptionPane.showMessageDialog(this, "Ого, ви отримуєте 40 балів за екзамен з програмування!!!", "Вам надано доступ)", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "На жаль, ви ввели неправильні дані", "Сюрпризу не буде(((", JOptionPane.ERROR_MESSAGE);
        }
        loginField.setText("");
        passwordField.setText("");
    }

    public static void main(String[] args) {
        LoginScreen app = new LoginScreen();
        app.setVisible(true);
    }
}
