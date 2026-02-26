import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class DictionaryScreen extends JFrame {
    public DictionaryScreen(Map<String, HashMap<String, Integer>> dictionary, int numOfWords, int numOfUnique, double sizeOfFiles, double sizeOfDict) {
        super("Домашня робота №11");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(650, 650);
        setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel("Словник термінів і інвертовані списки документів з частотою терміна в документі");
        title.setFont(new Font("Arial", Font.BOLD, 14));

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));

        addDictionary(textArea, dictionary);

        JLabel numOfAllWords = new JLabel("К-сть слів: " + numOfWords);
        numOfAllWords.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel numOfUniqueWords = new JLabel("К-сть унікальних слів: " + numOfUnique);
        numOfUniqueWords.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel sizeOfAllFiles = new JLabel("Розмір наданих файлів: " + sizeOfFiles + " KB");
        sizeOfAllFiles.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel sizeOfDictionary = new JLabel("Розмір створеного словника: " + sizeOfDict + " KB");
        sizeOfDictionary.setFont(new Font("Arial", Font.BOLD, 14));


        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        JPanel panel = new JPanel(new GridLayout(3, 1, 5, 5));
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel infoPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        titlePanel.add(title);
        panel.add(titlePanel);
        panel.add(scrollPane);
        infoPanel.add(numOfAllWords);
        infoPanel.add(numOfUniqueWords);
        infoPanel.add(sizeOfAllFiles);
        infoPanel.add(sizeOfDictionary);
        panel.add(infoPanel);
        add(panel);
    }

    private void addDictionary(JTextArea textArea, Map<String, HashMap<String, Integer>> dictionary) {
        String res = "";
        for(Map.Entry<String, HashMap<String, Integer>> outerEntry : dictionary.entrySet()){
            res += outerEntry.getKey() + " :";
            HashMap<String, Integer> innerMap = outerEntry.getValue();
            for(Map.Entry<String, Integer> innerEntry : innerMap.entrySet()){
                res += innerEntry.getKey() + " - " + innerEntry.getValue() + "; ";
            }
            res += "\n";
        }
        textArea.setText(res);
    }
}
