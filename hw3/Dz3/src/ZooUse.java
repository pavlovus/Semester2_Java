/*Домашнє завдання №3, Вус Павло, ІПЗ-1
Перша спроба моделювання.

Уявімо собі ситуацію. Нам потрібно написати програму, що буде управляти зоопарком.

В нас є тварини(оберіть самостійно), наприклад пінгвін і медвідь. А також є працівник зоопарку (роль його оберіть самостійно), наприклад доглядач тварин.

Зробіть класи які будуть характеризувати вказані дійові особи системи, опишіть поля і методи, що їм притаманні (деякі методи можуть бути порожні).
Зробіть клас , який буде моделювати день зоопарку.
 */
import utils.DataInput;

public class ZooUse {
    public static void main(String[] args) {
        WorkersOfZoo workerOne = new WorkersOfZoo();
        WorkersOfZoo workerTwo = new WorkersOfZoo();
        Visitors visitorOne = new Visitors();
        workerTwo.welcomeVisitor(visitorOne);
        Visitors visitorTwo = new Visitors();
        workerOne.welcomeVisitor(visitorTwo);
        Lions lion= new Lions();
        Tigers tiger= new Tigers();
        Chimpanzee chimpanzee= new Chimpanzee();
        Gorillas gorilla= new Gorillas();
        workerOne.warnVisitors();
        while (true){
            System.out.println("Виберіть, яку тварину годувати за робітника зоопарку: 1 - Лев, 2 - Тигр, 3 - Шимпанзе, 4 - Горила, 0 - Завершити годування");
            int choice = DataInput.getInt("Ваш вибір: ");
            if (choice == 0) {
                System.out.println("Годування завершено.");
                break;
            }
            switch (choice) {
                case 1:
                    workerOne.feedLion(lion);
                    System.out.println("Лев нагодований.");
                    break;
                case 2:
                    workerOne.feedTiger(tiger);
                    System.out.println("Тигр нагодований.");
                    break;
                case 3:
                    workerOne.feedChimpanzee(chimpanzee);
                    System.out.println("Шимпанзе нагодований.");
                    break;
                case 4:
                    workerOne.feedGorilla(gorilla);
                    System.out.println("Горила нагодована.");
                    break;
                default:
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
                    break;
            }
        }
        while (true){
            System.out.println("Виберіть, яку тварину годувати за робітника зоопарку: 1 - Лев, 2 - Тигр, 3 - Шимпанзе, 4 - Горила, 0 - Завершити годування");
            int choice = DataInput.getInt("Ваш вибір: ");
            if (choice == 0) {
                System.out.println("Годування завершено.");
                break;
            }
            switch (choice) {
                case 1:
                    visitorOne.seeLion(lion);
                    break;
                case 2:
                    visitorOne.seeTiger(tiger);
                    break;
                case 3:
                    visitorOne.seeChimpanzee(chimpanzee);
                    break;
                case 4:
                    visitorOne.seeGorilla(gorilla);
                    break;
                default:
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
                    break;
            }
        }
        visitorOne.leaveZoo();
        workerTwo.sayGoodbye(visitorOne);
        visitorOne.leaveZoo();
        workerTwo.sayGoodbye(visitorTwo);
    }
}
