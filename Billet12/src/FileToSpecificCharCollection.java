import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileToSpecificCharCollection {
    private File file;
    public FileToSpecificCharCollection(String filePath) {
        this.file = new File(filePath);
    }

    public ArrayList<String> wordsStartingWithSpecificChar(char ch) {
        ArrayList<String> res = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreTokens()) {
                    String word = st.nextToken();
                    if(word.charAt(0) == ch) {
                        res.add(word);
                    }
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
