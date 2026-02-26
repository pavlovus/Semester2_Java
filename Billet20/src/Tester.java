import utils.DataInput;

public class Tester {
    public static void main(String[] args) {
        FileToSpecificCharCollection f = new FileToSpecificCharCollection("C:\\Users\\Pavlo\\Desktop\\test.txt");
        while (true){
            int choice = DataInput.getInt("1 - колекція, яка починається з певного символу, 0 - завершити: ");
            if (choice == 1){
                char ch = DataInput.getChar("Введіть символ, з якого мають починатися всі слова колекції: ");
                System.out.println(f.wordsStartingWithSpecificChar(ch));
            } else if (choice == 0){
                System.out.println("Програма завершена!!!");
                return;
            }
        }
    }
}
