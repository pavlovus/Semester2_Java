/*Домашнє завдання №5, Вус Павло, ІПЗ-1
Написати бібліотеку для роботи з паралелепіпедом.

Написати декілька конструкторів класу (для різних часткових випадків)
обраховувати і повертати площу основи
повернення висоти
обрахувати і повертати об'єм
додати свої можливості за бажанням
Клас тестувальник винести назовні бібліотеки..
* */
import utils.DataInput;

public class ParallelepipedUse {
    public static void main(String[] args) {
        while (true){
            System.out.print("Задайте паралелепіпед одним з трьох способів, щоб застосувати на ньому всі методи з бібліотеки: ");
            int constructor = DataInput.getInt("Введіть 1, щоб задати прямокутиний паралелепіпед,2 - похилий, 3 - похилу чотирикутну призму: ");
            while (constructor < 1 || constructor > 3){
                constructor = DataInput.getInt("Введіть число ВІД 1 ДО 3: ");
            }
            if (constructor == 1){
                int x1 = DataInput.getInt("Введіть координату x першої точки основи: ");
                int y1 = DataInput.getInt("Введіть координату y першої точки основи: ");
                int z1 = DataInput.getInt("Введіть координату z першої точки основи: ");
                int x2 = DataInput.getInt("Введіть координату x другої точки основи: ");
                int y2 = DataInput.getInt("Введіть координату y другої точки основи: ");
                int z2 = DataInput.getInt("Введіть координату z другої точки основи: ");
                int x3 = DataInput.getInt("Введіть координату x третьої точки основи: ");
                int y3 = DataInput.getInt("Введіть координату y третьої точки основи: ");
                int z3 = DataInput.getInt("Введіть координату z третьої точки основи: ");
                int x4 = DataInput.getInt("Введіть координату x точки верхньої основи: ");
                int y4 = DataInput.getInt("Введіть координату y точки верхньої основи: ");
                int z4 = DataInput.getInt("Введіть координату z точки верхньої основи: ");
                Parallelepiped parallelepiped = new Parallelepiped(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4);
                System.out.println("Площа основи - " + parallelepiped.findBaseArea());
                System.out.println("Висота - " + parallelepiped.findHeight());
                System.out.println("Об'єм - " + parallelepiped.findSize());
            } else if (constructor == 2){
                int x1 = DataInput.getInt("Введіть координату x першої точки основи: ");
                int y1 = DataInput.getInt("Введіть координату y першої точки основи: ");
                int z1 = DataInput.getInt("Введіть координату z першої точки основи: ");
                int x2 = DataInput.getInt("Введіть координату x другої точки основи: ");
                int y2 = DataInput.getInt("Введіть координату y другої точки основи: ");
                int z2 = DataInput.getInt("Введіть координату x другої точки основи: ");
                int x3 = DataInput.getInt("Введіть координату x третьої точки основи: ");
                int y3 = DataInput.getInt("Введіть координату y третьої точки основи: ");
                int z3 = DataInput.getInt("Введіть координату x третьої точки основи: ");
                int sideRibLength = DataInput.getInt("Введіть довжину бічного ребра: ");
                while (sideRibLength <= 0){
                    sideRibLength = DataInput.getInt("Ви маєте ввести ДОДАТНЄ значення: ");
                }
                int tiltAngle = DataInput.getInt("Введіть кут нахилу: ");
                while (tiltAngle <= 0 || tiltAngle > 90){
                    tiltAngle = DataInput.getInt("Введіть кут ВІД 0 ДО 90: ");
                }
                Parallelepiped parallelepiped = new Parallelepiped(x1, y1, z1, x2, y2, z2, x3, y3, z3, sideRibLength, tiltAngle);
                System.out.println("Площа основи - " + parallelepiped.findBaseArea());
                System.out.println("Висота - " + parallelepiped.findHeight());
                System.out.println("Об'єм - " + parallelepiped.findSize());
            } else {
                int x1 = DataInput.getInt("Введіть координату x першої точки основи: ");
                int y1 = DataInput.getInt("Введіть координату y першої точки основи: ");
                int z1 = DataInput.getInt("Введіть координату z першої точки основи: ");
                int baseSideLengthOne = DataInput.getInt("Введіть довжину першої сторони основи: ");
                while (baseSideLengthOne <= 0){
                    baseSideLengthOne = DataInput.getInt("Ви маєте ввести ДОДАТНЄ значення: ");
                }
                int baseSideLengthTwo = DataInput.getInt("Введіть довжину другої сторони основи: ");
                while (baseSideLengthTwo <= 0){
                    baseSideLengthTwo = DataInput.getInt("Ви маєте ввести ДОДАТНЄ значення: ");
                }
                int angleBetweenSidesOfBase = DataInput.getInt("Введіть кут між сторонами основи: ");
                while (angleBetweenSidesOfBase <= 0 || angleBetweenSidesOfBase > 180){
                    angleBetweenSidesOfBase = DataInput.getInt("Введіть кут ВІД 0 ДО 180: ");
                }
                int sideRibLength = DataInput.getInt("Введіть довжину бічного ребра: ");
                while (sideRibLength <= 0){
                    sideRibLength = DataInput.getInt("Ви маєте ввести ДОДАТНЄ значення: ");
                }
                int tiltAngle = DataInput.getInt("Введіть кут нахилу: ");
                while (tiltAngle <= 0 || tiltAngle > 90){
                    tiltAngle = DataInput.getInt("Введіть кут ВІД 0 ДО 90: ");
                }
                Parallelepiped parallelepiped = new Parallelepiped(x1, y1, z1, baseSideLengthOne, baseSideLengthTwo, angleBetweenSidesOfBase, sideRibLength, tiltAngle);
                System.out.println("Площа основи - " + parallelepiped.findBaseArea());
                System.out.println("Висота - " + parallelepiped.findHeight());
                System.out.println("Об'єм - " + parallelepiped.findSize());
            }
            //Запитуємо чи користувач хоче продовжувати
            int choice = DataInput.getInt("Продовжуємо? Введіть 1 для продовження або 0 для завершення: ");
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
