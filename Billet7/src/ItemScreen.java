import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ItemScreen extends JFrame {
    private JPanel panel;

    public ItemScreen() {
        super("Item Screen");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel("Назва товару: ");
        JTextField nameField = new JTextField(15);
        JLabel weightLabel = new JLabel("Вага товару: ");
        JTextField weightField = new JTextField(15);
        JLabel priceLabel = new JLabel("Ціна товару: ");
        JTextField priceField = new JTextField(15);

        JButton submitButton = new JButton("Зберегти");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    addToScreen(nameField.getText(), weightField.getText(), priceField.getText());
                } catch (IncorrectInputException ex) {
                    JOptionPane.showMessageDialog(ItemScreen.this, ex.getMessage(), "Помилка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(weightLabel);
        panel.add(weightField);
        panel.add(priceLabel);
        panel.add(priceField);
        panel.add(submitButton);

        add(panel);
    }

    private void addToScreen(String name, String weight, String price) {
        if (name.equals("") || weight.equals("") || price.equals(""))
            throw new IncorrectInputException("Схоже, що деякі поля пусті");
        try {
            Integer.parseInt(weight);
        } catch (NumberFormatException e) {
            throw new IncorrectInputException("Вага має бути цілим числом");
        }
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IncorrectInputException("Ціна має бути цілим числом");
        }

        String s = "Назва товару: " + name + " | Вага: " + weight + " | Ціна: " + price;
        JLabel label = new JLabel(s);

        int lastIndex = panel.getComponentCount() - 1;
        panel.add(label, lastIndex);
        panel.revalidate();
        panel.repaint();
    }

    public static void main(String[] args) {
        ItemScreen screen = new ItemScreen();
        screen.setVisible(true);
    }
}
