import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ItemScreen extends JFrame {
    public ItemScreen(String filePath) {
        super("Item Screen");
        File fileToSave = new File(filePath);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
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
                    saveInFile(fileToSave, nameField.getText(), weightField.getText(), priceField.getText());
                } catch (IncorrectInputException ex){
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

    private void saveInFile(File fileToSave, String name, String weight, String price) {
        if(name.equals("") || weight.equals("") || price.equals(""))
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
        String s = "Назва товару: " + name + "\nВага: " + weight + "\nЦіна: " + price;
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))){
            writer.write(s);
            JOptionPane.showMessageDialog(ItemScreen.this, "Ви успішно зберегли інформацію", "Успіх", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException ex){
            JOptionPane.showMessageDialog(ItemScreen.this, "Схоже, що такого файлу не існує", "Помилка", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex){
            JOptionPane.showMessageDialog(ItemScreen.this, "Схоже, що щось пішло не так під час записування в файл", "Помилка", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        ItemScreen screen = new ItemScreen("C:\\Users\\Pavlo\\Desktop\\test.txt");
        screen.setVisible(true);
    }
}
