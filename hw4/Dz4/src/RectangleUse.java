/*Домашнє завдання №4, Вус Павло, ІПЗ-1
Створити клас Rectangle, що буде описувати прямокутник і містити методи необхідні для роботи з ним. Клас, має чотири поля - x1, y1, x2 і y2, що відповідають за кути прямокутника.

Методи:  переміщення прямокутника на вказану відстань; перевірка, чи знаходиться точка в середині прямокутника; метод, що повертає об'єднання даного прямокутника з іншим (найменший прямокутник, що містить обидва); перетин двух прямокутників; перевизначений метод toString.

В класі Rectangle не повинно бути ніяких введень-виведень, тільки геттери-сеттери. Введення-виведення має бути повністю винесене у клас-тестувальник.
* */
import utils.DataInput;

import javax.xml.crypto.Data;

public class RectangleUse {
    public static void main(String[] args) {
        while (true){
            int x1 = DataInput.getInt("Введіть координату x нижньої лівої точки: ");
            int y1 = DataInput.getInt("Введіть координату y нижньої лівої точки: ");
            int x2 = DataInput.getInt("Введіть координату x верхньої правої точки: ");
            while (x1 > x2){
                x2 = DataInput.getInt("Ця координата не може бути меншою за попередню: ");
            }
            int y2 = DataInput.getInt("Введіть координату y верхньої правої точки: ");
            while (y1 > y2){
                y2 = DataInput.getInt("Ця координата не може бути меншою за попередню: ");
            }
            Rectangle rectangle = new Rectangle(x1, y1, x2, y2);
            outerLoop:
            while (true){
                System.out.println("Виберіть дію над цим прямокутником: ");
                System.out.println("1 - Перемістити його");
                System.out.println("2 - Перевірити чи точка знаходиться в середині");
                System.out.println("3 - Об'єднання з іншим прямокутником");
                System.out.println("4 - Перетин з іншим прямокутником");
                System.out.println("5 - Розпочати заново");
                System.out.println("6 - Завершити");
                int numberOfAction = DataInput.getInt("Введіть ваш вибір: ");
                switch (numberOfAction){
                    case 1:
                        int dx = DataInput.getInt("Введіть зміщення по х: ");
                        int dy = DataInput.getInt("Введіть зміщення по y: ");
                        rectangle.move(dx, dy);
                        System.out.println(rectangle.toString());
                        break;
                    case 2:
                        int x = DataInput.getInt("Введіть координату x точки: ");
                        int y = DataInput.getInt("Введіть координату y точки: ");
                        if(rectangle.containsPoint(x, y)){
                            System.out.println("Ця точка є всередині прямокутника");
                        } else {
                            System.out.println("Ця точка не є всередині прямокутника");
                        }
                        break;
                    case 3:
                        int X1 = DataInput.getInt("Введіть координату x нижньої лівої точки: ");
                        int Y1 = DataInput.getInt("Введіть координату y нижньої лівої точки: ");
                        int X2 = DataInput.getInt("Введіть координату x верхньої правої точки: ");
                        while (X1 > X2){
                            X2 = DataInput.getInt("Ця координата не може бути меншою за попередню: ");
                        }
                        int Y2 = DataInput.getInt("Введіть координату y верхньої правої точки: ");
                        while (Y1 > Y2){
                            Y2 = DataInput.getInt("Ця координата не може бути меншою за попередню: ");
                        }
                        Rectangle rectangleOne = new Rectangle(X1, Y1, X2, Y2);
                        Rectangle union = rectangle.union(rectangleOne);
                        System.out.println(union.toString());
                        break;
                    case 4:
                        int x3 = DataInput.getInt("Введіть координату x нижньої лівої точки: ");
                        int y3 = DataInput.getInt("Введіть координату y нижньої лівої точки: ");
                        int x4 = DataInput.getInt("Введіть координату x верхньої правої точки: ");
                        while (x3 > x4){
                            x4 = DataInput.getInt("Ця координата не може бути меншою за попередню: ");
                        }
                        int y4 = DataInput.getInt("Введіть координату y верхньої правої точки: ");
                        while (y3 > y4){
                            y4 = DataInput.getInt("Ця координата не може бути меншою за попередню: ");
                        }
                        Rectangle rectangleTwo = new Rectangle(x3, y3, x4, y4);
                        Rectangle intersection = rectangle.intersection(rectangleTwo);
                        if(intersection != null){
                            System.out.println(intersection.toString());
                        } else {
                            System.out.println("Схоже, що перетину немає");
                        }
                        break;
                    case 5:
                        break outerLoop;
                    case 6:
                        System.out.println("Програма завершена!");
                        return;
                }
            }
        }
    }
}
