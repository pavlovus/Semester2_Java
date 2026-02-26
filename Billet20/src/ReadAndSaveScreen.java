import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class ReadAndSaveScreen extends JFrame {
    private JTextArea textArea;

    public ReadAndSaveScreen() {
        super("Бла-бла");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(10, 10));

        JButton openButton = new JButton("Open File");

        JButton saveButton = new JButton("Save in File");

        textArea = new JTextArea();

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(scrollPane);
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);
        panel.add(buttonPanel);
        add(panel);

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = showFileChooser();
                if(file != null) {
                    showFileContent(file);
                }
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = showFileChooser();
                if(file != null) {
                    saveContentInFile(file);
                }
            }
        });
    }

    private File showFileChooser() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Only text files (.txt)", "txt", "java");
        chooser.setFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        return null;
    }

    private void showFileContent(File selectedFile) {
        try(BufferedReader br = new BufferedReader(new FileReader(selectedFile))){
            String res ="";
            String line;
            while ((line = br.readLine()) != null) {
                res += line+ "\n";
            }
            if(!res.isEmpty()){
                textArea.setText(res);
            } else {
                JOptionPane.showMessageDialog(this, "Схоже, що ваш файл пустий", "Файл пустий", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex){
            JOptionPane.showMessageDialog(this, "Схоже, щось пішло не так(((", "Помилка!!!", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void saveContentInFile(File file) {
        try(BufferedWriter br = new BufferedWriter(new FileWriter(file))){
            br.write(textArea.getText());
            JOptionPane.showMessageDialog(this, "Інформацію успішно збережено", "Успіх", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex){
            JOptionPane.showMessageDialog(this, "Схоже, щось пішло не так(((", "Помилка!!!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        ReadAndSaveScreen frame = new ReadAndSaveScreen();
        frame.setVisible(true);
    }
}
