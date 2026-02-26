import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;

public class TextFileChooser extends JFrame {

    public TextFileChooser() {
        super("Домашня робота №11");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 200);
        setLocationRelativeTo(null);
        this.setLayout(new BorderLayout(10, 10));

        JLabel title = new JLabel("Оберіть 10 текстових файлів з мінімальним розміром 150K");

        JButton openButton = new JButton("Обрати файли");
        openButton.setPreferredSize(new Dimension(100, 30));
        openButton.setBorder(null);
        openButton.setFont(new Font("Arial", Font.PLAIN, 12));
        openButton.setForeground(Color.WHITE);
        openButton.setBackground(Color.BLACK);
        openButton.setFocusPainted(false);

        JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(openButton);
        titlePanel.add(title);
        panel.add(titlePanel);
        panel.add(buttonPanel);
        add(panel);

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    showFileChooser();
                } catch (IncorrectSizeException ex) {
                    JOptionPane.showMessageDialog(TextFileChooser.this, ex.getMessage(), "Помилка", JOptionPane.ERROR_MESSAGE);
                } catch (IncorrectNumberOfFilesException ex) {
                    JOptionPane.showMessageDialog(TextFileChooser.this, ex.getMessage(), "Помилка", JOptionPane.ERROR_MESSAGE);
                } catch (FileProcessingException ex){
                    JOptionPane.showMessageDialog(TextFileChooser.this, ex.getMessage(), "Помилка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void showFileChooser() throws IncorrectSizeException, IncorrectNumberOfFilesException, FileProcessingException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Only text files (.txt)", "txt");
        chooser.setFileFilter(filter);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setMultiSelectionEnabled(true);
        int returnVal = chooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File[] selectedFiles = chooser.getSelectedFiles();
            if (selectedFiles.length < 10) {
                throw new IncorrectNumberOfFilesException("Вам потрібно обрати 10 файлів!!!");
            }
            if (!checkForSize(selectedFiles)) {
                throw new IncorrectSizeException("Вам потрібно обрати файли більші за 150KB.");
            }
            int numOfWords = 0;
            double sizeOfFiles = 0;
            HashMap<String, HashMap<String, Integer>> dictionary = new HashMap<>();
            for(File file : selectedFiles) {
                long fileSize = file.length();
                double fileSizeKB = fileSize / 1024.0;
                sizeOfFiles += fileSizeKB;
                numOfWords += analyzeFileForWords(file, dictionary);
            }
            List<Map.Entry<String, HashMap<String, Integer>>> entryList = new ArrayList<>(dictionary.entrySet());
            entryList.sort(Map.Entry.comparingByKey(String.CASE_INSENSITIVE_ORDER));

            Map<String, HashMap<String, Integer>> sortedDictionary = new LinkedHashMap<>();
            for (Map.Entry<String, HashMap<String, Integer>> entry : entryList) {
                HashMap<String, Integer> innerMap = entry.getValue();
                List<Map.Entry<String, Integer>> innerList = new ArrayList<>(innerMap.entrySet());
                innerList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

                HashMap<String, Integer> sortedInnerMap = new LinkedHashMap<>();
                for (Map.Entry<String, Integer> innerEntry : innerList) {
                    sortedInnerMap.put(innerEntry.getKey(), innerEntry.getValue());
                }
                sortedDictionary.put(entry.getKey(), sortedInnerMap);
            }
            saveDictionaryOnDisk(sortedDictionary);
            File dictionaryFile = new File("C:\\Users\\Pavlo\\Desktop\\test.txt");
            double sizeofDictionary = dictionaryFile.length()/1024.0;
            addDictOnScreen(sortedDictionary, numOfWords,dictionary.size(), sizeOfFiles, sizeofDictionary);
        }
    }

    private int analyzeFileForWords(File file, HashMap<String, HashMap<String, Integer>> dictionary) {
        int count = 0;
        try{
            FileReader fr = new FileReader(file);
            StreamTokenizer st = new StreamTokenizer(fr);
            st.wordChars('a', 'z');
            st.wordChars('A', 'Z');
            st.wordChars('0', '9');
            st.whitespaceChars(0, ' ');
            st.ordinaryChar(',');
            st.ordinaryChar('.');
            st.ordinaryChar('"');
            st.ordinaryChar('?');
            st.ordinaryChar('!');
            st.ordinaryChar(';');
            st.ordinaryChar(':');
            st.ordinaryChar('/');
            st.ordinaryChar('…');
            while (st.nextToken() != StreamTokenizer.TT_EOF) {
                if ((st.ttype == StreamTokenizer.TT_WORD || st.ttype == StreamTokenizer.TT_NUMBER)) {
                    if(st.sval != null) {
                        count++;
                        HashMap<String, Integer> freqMap = dictionary.get(st.sval);
                        if(freqMap == null) {
                            freqMap = new HashMap<>();
                            freqMap.put(file.getName(), 1);
                            dictionary.put(st.sval, freqMap);
                        } else {
                            Integer freq = freqMap.get(file.getName());
                            freqMap.put(file.getName(), freq == null ? 1 : freq + 1);
                        }
                    }
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Файл не знайдено");
        }
        catch (IOException e){
            System.out.println("Схоже, щось пішло не так");
        }
        return count;
    }

    private void saveDictionaryOnDisk(Map<String, HashMap<String, Integer>> dictionary) throws FileProcessingException {
        String filePath = "C:\\Users\\Pavlo\\Desktop\\test.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for(Map.Entry<String, HashMap<String, Integer>> outerEntry : dictionary.entrySet()){
                writer.write(outerEntry.getKey());
                writer.newLine();
            }
        } catch (IOException e){
            throw new FileProcessingException("Помилка при збереженні словника на диск!");
        }
    }

    private void addDictOnScreen(Map<String, HashMap<String, Integer>> dictionary, int numOfWords, int numOfUniqueWords, double sizeOfFiles, double sizeofDictionary) {
        DictionaryScreen resScreen = new DictionaryScreen(dictionary, numOfWords, numOfUniqueWords, sizeOfFiles, sizeofDictionary);
        resScreen.setVisible(true);
    }

    private boolean checkForSize(File[] selectedFiles) {
        for(File file : selectedFiles) {
            long fileSize = file.length();
            double fileSizeKB = fileSize / 1024.0;
            if(fileSizeKB < 150){
                return false;
            }
        }
        return true;
    }
}
