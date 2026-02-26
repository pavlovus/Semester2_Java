import javax.swing.*;
import java.io.*;
import java.nio.file.*;

public class FileCopy {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Копіювання файлу");
        JButton button = new JButton("Оберіть файл для копіювання");

        button.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(null);

            if (option == JFileChooser.APPROVE_OPTION) {
                File sourceFile = fileChooser.getSelectedFile();

                String destFileName = JOptionPane.showInputDialog("Введіть назву нового файлу:");
                if (destFileName != null && !destFileName.isEmpty()) {
                    try {
                        Files.copy(sourceFile.toPath(), Paths.get(destFileName), StandardCopyOption.REPLACE_EXISTING);
                        JOptionPane.showMessageDialog(null, "Файл скопійовано успішно.");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Помилка копіювання: " + ex.getMessage());
                    }
                }
            }
        });

        frame.add(button);
        frame.setSize(400, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

