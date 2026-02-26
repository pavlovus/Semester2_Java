/* Практичне завдання №10, Вус Павло, ІПЗ-1, група №6
* Написати графічну програму, що використовуючи JFileChooser дозволяє обрати файл і виводить його зміст.*/
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Practice10 extends JFrame {
    private JTextArea textArea;

    public Practice10() {
        super("Практична №10");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(10, 10));

        JButton openButton = new JButton("Open File");
        openButton.setPreferredSize(new Dimension(100, 30));
        openButton.setBorder(null);
        openButton.setFont(new Font("Arial", Font.PLAIN, 18));
        openButton.setForeground(Color.WHITE);
        openButton.setBackground(Color.BLACK);

        textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(scrollPane);
        buttonPanel.add(openButton);
        panel.add(buttonPanel);
        add(panel);


        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFileChooser();
            }
        });
    }

    private void showFileChooser() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Only text files (.txt)", "txt", "java");
        chooser.setFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
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
    }

    public static void main(String[] args) {
        Practice10 frame = new Practice10();
        frame.setVisible(true);
    }
}