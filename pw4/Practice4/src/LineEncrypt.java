public class LineEncrypt {
    private String  line;
    private int currentDifference;
    /**
     * Constructor that initializes a string for encryption/decryption.
     *
     * @param line the string to be processed
     */
    public LineEncrypt(String line) {
        this.line = line;
    }
    /**
     * Sets a new string for encryption/decryption.
     *
     * @param line the new string
     */
    public void setLine(String line) {
        this.line = line;
    }
    /**
     * Retrieves the current string.
     *
     * @return the current string
     */
    public String getLine() {
        return line;
    }
    /**
     * Prints the current string to the console.
     */
    public void printLine() {
        System.out.println(line);
    }
    //Метод, який шифрує всі літери в стрічці
    /**
     * A method that encrypts all Latin letters in a string
     * @param line
     * @param difference
     * @return
     */
    private String encryptLine(String line, int difference) {
        String result = "";
        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);
            if (currentChar >= 'A' && currentChar <= 'Z') {
                //Для великих літер латинських
                currentChar = (char) ('A' + (currentChar - 'A' + difference % 26 + 26) % 26);
            } else if (currentChar >= 'a' && currentChar <= 'z') {
                //Для малих літер латинських
                currentChar = (char) ('a' + (currentChar - 'a' + difference % 26 + 26) % 26);
            } else if (currentChar >= 'А' && currentChar <= 'Я') {
                //Для великих літер українських
                currentChar = (char) ('А' + (currentChar - 'А' + difference % 32 + 32) % 32);
            } else if (currentChar >= 'а' && currentChar <= 'я') {
                //Для малих літер українських
                currentChar = (char) ('а' + (currentChar - 'а' + difference % 32 + 32) % 32);
            }
            result += currentChar;
        }
        return result;
    }
    /**
     * Encrypts the current string using the specified shift.
     * Then updates the current shift value accordingly.
     *
     * @param difference the shift value used for encryption
     */
    public void encryptCurrentLine(int difference) {
        this.line = encryptLine(this.line, difference);
        currentDifference += difference;
    }
    //Метод, який дешифрує всі літери в стрічці
    /**
     * A method that decrypts all Latin letters in a string
     * @param line
     * @param difference
     * @return
     */
    private String decryptLine(String line, int difference) {
        String result = "";
        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);
            if (currentChar >= 'A' && currentChar <= 'Z') {
                //Для великих літер
                currentChar = (char) ('A' + (currentChar - 'A' + (-difference) % 26 + 26) % 26);
            } else if (currentChar >= 'a' && currentChar <= 'z') {
                //Для малих літер
                currentChar = (char) ('a' + (currentChar - 'a' + (-difference) % 26 + 26) % 26);
            } else if (currentChar >= 'А' && currentChar <= 'Я') {
                //Для великих літер українських
                currentChar = (char) ('А' + (currentChar - 'А' + (-difference) % 32 + 32) % 32);
            } else if (currentChar >= 'а' && currentChar <= 'я') {
                //Для малих літер українських
                currentChar = (char) ('а' + (currentChar - 'а' + (-difference) % 32 + 32) % 32);
            }
            result += currentChar;
        }
        return result;
    }
    /**
     * Decrypts the current string using the specified shift.
     * Then updates the current shift value accordingly.
     *
     * @param difference the shift value used for decryption
     */
    public void decryptCurrentLine(int difference) {
        this.line = decryptLine(this.line, difference);
        currentDifference -= difference;
    }
    /**
     * Decrypts the current string using the stored shift value.
     * After decryption, the shift is reset to 0.
     */
    public void decryptCurrentLine() {
        this.line = decryptLine(this.line, currentDifference);
        currentDifference = 0;
    }
}
