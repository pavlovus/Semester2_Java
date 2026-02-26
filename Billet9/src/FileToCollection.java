import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class FileToCollection {
    private File file;
    public FileToCollection(String filePath) {
        this.file = new File(filePath);
    }

    public ArrayList<String> oddWordsFromFile() {
        ArrayList<String> res = new ArrayList<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                int count = 0;
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreTokens()) {
                    String word = st.nextToken();
                    count++;
                    if (count % 2 != 0) {
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
