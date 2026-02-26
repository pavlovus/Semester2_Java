/*Практичне завдання №4, Вус Павло, ІПЗ-1
 Написати клас який на вхід отримує стрічку символів і зберігає її.

На запит користувача повертається закодована стрічка. В якості кодування стрічки можна взяти шифр Цезаря.

На запит користувача повертається розкодована стрічка.
* */
import utils.DataInput;

import java.io.IOException;

public class LineEncryptUse {
    public static void main(String[] args) throws IOException {
        while (true) {
            String line = DataInput.getString("Введіть стрічку, яку будемо шифрувати або дешифрувати: ");
            LineEncrypt encryption = new LineEncrypt(line);
            while (true){
                int difference = DataInput.getInt("Введіть число, на яке хочете зашифрувати стрічку: ");
                encryption.encryptCurrentLine(difference);
                System.out.println("Теперішній стан стрічки: " + encryption.getLine());
                int choice =  DataInput.getInt("Введіть 1, щоб продовжити шифрування, або 0, щоб перейти до дешифрування: ");
                while(choice != 0 && choice != 1){
                    choice = DataInput.getInt("Вам потрібно ввести 1 АБО 0: ");
                }
                if (choice == 0){
                    break;
                }
            }
            while (true){
                int difference = DataInput.getInt("Введіть число, на яке хочете дешифрувати стрічку або 0, якщо хочете одразу дешифрувати в початковий стан: ");
                if (difference == 0){
                    encryption.decryptCurrentLine();
                    System.out.println("Теперішній стан стрічки: " + encryption.getLine());
                    break;
                } else {
                    encryption.decryptCurrentLine(difference);
                    System.out.println("Теперішній стан стрічки: " + encryption.getLine());
                    int choice =  DataInput.getInt("Введіть 1, щоб продовжити дешифрування, або 0, щоб завершити його: ");
                    while(choice != 0 && choice != 1){
                        choice = DataInput.getInt("Вам потрібно ввести 1 АБО 0: ");
                    }
                    if (choice == 0){
                        break;
                    }
                }
            }
            //Запитуємо чи користувач хоче продовжувати
            int choice = DataInput.getInt("Продовжуємо? Введіть 1 для продовження і введення нової стрічки або 0 для завершення: ");
            while(true){
                if(choice == 0){
                    System.out.println("Програма завершена!");
                    return;
                } else if(choice == 1){
                    break;
                } else {
                    choice = DataInput.getInt("Ви ввели інше число!!!. Вам потрібно ввести 1 для продовження або 0 для виходу:");
                }
            }
        }
    }
}
