
import java.io.*;
import java.util.Arrays;


public class WordInFileCalculator {
    private String fileName;
    /**
     * Constructor that initializes the file name.
     *
     * @param fileName The name of the file to be processed.
     */
    public WordInFileCalculator(String fileName) {
        this.fileName = fileName;
    }
    /**
     * Gets the file name.
     *
     * @return The name of the file.
     */
    public String getFileName() {
        return fileName;
    }
    /**
     * Sets the file name.
     *
     * @param fileName The name of the file to be processed.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    /**
     * Finds the total number of words in the file.
     * This method uses a StreamTokenizer to count words and numbers in the file.
     *
     * @return The total number of words found in the file.
     */
    public int findNumberOfWordsInFile() {
    int numberOfWords = 0;
        try{
            FileReader fr = new FileReader(fileName);
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
            String s;
            while (st.nextToken() != StreamTokenizer.TT_EOF) {
                if (st.ttype == StreamTokenizer.TT_WORD || st.ttype == StreamTokenizer.TT_NUMBER) {
                    numberOfWords++;
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Файл не знайдено");
        }
        catch (IOException e){
            System.out.println("Схоже, щось пішло не так");
        }
    return numberOfWords;
    }
    /**
     * Finds the number of unique words in the file.
     * This method counts unique words by using a String array to store them and checks if a word has already been encountered.
     *
     * @return The number of unique words found in the file.
     */
    public int findNumberOfUniqueWordsInFile() {
        String[] uniqueWords = new String[findNumberOfWordsInFile()];
        int numberOfUniqueWords = 0;
        try{
            FileReader fr = new FileReader(fileName);
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
            String s;
            while (st.nextToken() != StreamTokenizer.TT_EOF) {
                if ((st.ttype == StreamTokenizer.TT_WORD || st.ttype == StreamTokenizer.TT_NUMBER) && isNewWord(uniqueWords, st.sval)) {
                    uniqueWords[numberOfUniqueWords] = st.sval;
                    numberOfUniqueWords++;
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Файл не знайдено");
        }
        catch (IOException e){
            System.out.println("Схоже, щось пішло не так");
        }
        return numberOfUniqueWords;
    }
    /**
     * Helper method to check if a word is new (not already in the uniqueWords array).
     *
     * @param uniqueWords Array holding unique words found so far.
     * @param token The word to be checked.
     * @return True if the word is not already in the array, otherwise false.
     */
    private boolean isNewWord(String[] uniqueWords, String token) {
        for (String word : uniqueWords) {
            if (word != null && word.equals(token)) {
                return false;
            }
        }
        return true;
    }
    /**
     * Gets an array of unique words from the file, sorted alphabetically.
     *
     * @return An array of unique words from the file, sorted alphabetically.
     */
    private String[] getUniqueWords() {
        String[] uniqueWords = new String[findNumberOfWordsInFile()];
        int numberOfUniqueWords = 0;
        try{
            FileReader fr = new FileReader(fileName);
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
            String s;
            while (st.nextToken() != StreamTokenizer.TT_EOF) {
                if ((st.ttype == StreamTokenizer.TT_WORD || st.ttype == StreamTokenizer.TT_NUMBER) && isNewWord(uniqueWords, st.sval)) {
                    uniqueWords[numberOfUniqueWords] = st.sval;
                    numberOfUniqueWords++;
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Файл не знайдено");
        }
        catch (IOException e){
            System.out.println("Схоже, щось пішло не так");
        }
        String[] newUniqueWords = Arrays.copyOf(uniqueWords, numberOfUniqueWords);
        return sortArrayAscending(newUniqueWords);
    }
    /**
     * Sorts an array of strings alphabetically.
     *
     * @param arr the array of strings to be sorted
     * @return a new array with the strings sorted alphabetically
     */
    public String[] sortArrayAscending(String[] arr) {
        // Потрібно створити копію масиву, щоб не змінювати оригінальний
        String[] res = Arrays.copyOf(arr, arr.length);

        // Сортування за допомогою алгоритму сортування вибором (можна використовувати будь-який алгоритм)
        for (int i = 0; i < res.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < res.length; j++) {
                if (isFirstHigherThanTheSecond(res[j], res[minIndex])) {
                    minIndex = j;
                }
            }
            String temp = res[minIndex];
            res[minIndex] = res[i];
            res[i] = temp;
        }
        return res;
    }
    /**
     * Checks if the first string is alphabetically higher than the second string.
     *
     * @param str1 the first string
     * @param str2 the second string
     * @return true if the first string is higher, false otherwise
     */
    public static boolean isFirstHigherThanTheSecond(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        // If all the letters in a String are same but the length is different the
        // shorter one is put first
        boolean sameLetters = true;
        for (int i = 0; i < len; i++) {
            if (Character.toLowerCase(str1.charAt(i)) != Character.toLowerCase(str2.charAt(i))) {
                sameLetters = false;
            }
        }
        if (sameLetters) {
            return str1.length() == len;
        }
        // Checks if the first String is first in alphabetical order
        for (int i = 0; i < len; i++) {
            if (isCyrrilic(str1.charAt(i)) && isCyrrilic(str2.charAt(i))) {
                if (getCyrrilicIndex(Character.toUpperCase(str1.charAt(i))) < getCyrrilicIndex(Character.toUpperCase(str2.charAt(i)))) {
                    return true;
                } else if (getCyrrilicIndex(Character.toUpperCase(str1.charAt(i))) == getCyrrilicIndex(Character.toUpperCase(str2.charAt(i)))) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (Character.toLowerCase(str1.charAt(i)) < Character.toLowerCase(str2.charAt(i))) {
                    return true;
                } else if (Character.toLowerCase(str1.charAt(i)) == Character.toLowerCase(str2.charAt(i))) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    /**
     * Checks if a character is Cyrillic.
     *
     * @param c the character to check
     * @return true if the character is Cyrillic, false otherwise
     */
    private static boolean isCyrrilic(char c) {
        for (char letter : alphabet) {
            if (Character.toUpperCase(c) == letter) {
                return true;
            }
        }
        return false;
    }
    /**
     * Gets the index of a Cyrillic character in the alphabet.
     *
     * @param c the character to get the index of
     * @return the index of the character
     */
    private static int getCyrrilicIndex(char c) {
        for (int i = 0; i < alphabet.length; i++) {
            if (Character.toUpperCase(c) == alphabet[i]) return i;
        }
        return -1;
    }
    // Український алфавіт
    private static final char[] alphabet = {
            'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е', 'Є', 'Ж', 'З', 'И', 'І', 'Ї', 'Й', 'К', 'Л', 'М', 'Н',
            'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ю', 'Я'
    };
    /**
     * Prints the unique words from the file in alphabetical order along with their usage count.
     *
     * This method calls getUniqueWords() to retrieve and sort the unique words and then counts their occurrences.
     */
    public void printUniqueWords() {
        String[] uniqueWords = getUniqueWords();
        for (String word : uniqueWords) {
            System.out.println(word + " - " +getNumberOfUsages(word));
        }
    }
    /**
     * Counts the number of occurrences of a specific word in the file.
     *
     * @param word The word whose frequency is to be counted.
     * @return The number of times the word appears in the file.
     */
    private int getNumberOfUsages(String word) {
        int numberOfUsages = 0;
        try{
            FileReader fr = new FileReader(fileName);
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
            String s;
            while (st.nextToken() != StreamTokenizer.TT_EOF) {
                if ((st.ttype == StreamTokenizer.TT_WORD || st.ttype == StreamTokenizer.TT_NUMBER)) {
                    if(word.equals(st.sval)) {
                        numberOfUsages++;
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
        return numberOfUsages;
    }
}
