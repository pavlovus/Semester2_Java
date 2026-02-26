import java.io.*;
import java.util.*;

public class FileToUniqueWordsCollection {
    private File file;
    public FileToUniqueWordsCollection(String filePath) {
        this.file = new File(filePath);
    }

    public Set<String> uniqueWordsFromFile() {
        Set<String> res = new LinkedHashSet<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreTokens()) {
                    String word = st.nextToken();
                    res.add(word);
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("Файл не знайдено");
        } catch (IOException e){
            System.out.println("Схоже, щось пішло не так");
        }
        return res;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
