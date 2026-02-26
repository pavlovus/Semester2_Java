/* Практичне завдання №8, Вус Павло, ІПЗ-1, група №6
Написати програму, що зчитує інформацію з текстового файлу і рахує кількість слів в файлі, кількість унікальних слів в файлі, виводить інформацію про кількість слів, кількість унікальних слів, унікальні слова за алфавітом і поруч скільки разів це слово зустрілося.
Унікальні слова - це, так би мовити, словарний запас файлу. Тобто, якщо у вас у файлі сто слів, але при цьому там двадцять п'ять різних слів, кожне з яких повторюється чотири рази, то унікальних слів - 25.
 */
import utils.DataInput;

import java.util.Arrays;

public class WordInFileCalculatorUse {
    public static void main(String[] args) {
        while (true){
            //String fileName = DataInput.getString("Введіть ім'я файлу: ");
            WordInFileCalculator wordCalculator = new WordInFileCalculator("C:\\Users\\Pavlo\\Desktop\\test.txt");
            System.out.println("К-сть слів в цьому файлі - " + wordCalculator.findNumberOfWordsInFile());
            System.out.println("К-сть унікальних слів в цьому файлі - " + wordCalculator.findNumberOfUniqueWordsInFile());
            System.out.println("Унікальні слова за алфавітом та к-сть їх використань: ");
            wordCalculator.printUniqueWords();
            //Запитуємо чи користувач хоче продовжувати і створити новий масив
            int choice = DataInput.getInt("Продовжуємо? Введіть 1 для продовження або 0 для виходу: ");
            while(true){
                if(choice == 0){
                    System.out.println("Програма завершена!");
                    return;
                } else if(choice == 1){
                    break;
                } else {
                    choice = DataInput.getInt("Ви ввели інше число!!!. Вам потрібно ввести 1 для продовження або 0 для виходу: ");
                }
            }
        }
    }
}
