import java.util.Scanner;

public class StudentReader {
    public Scanner sc;
    public StudentReader() {
        sc = new Scanner(System.in);
    }

    public Student readStudent() {
        String name;
        int age = -1;
        int grade = -1;
        System.out.println("Введіть ПІБ студента: ");
        name = sc.nextLine();
        while (name.isEmpty()) {
            System.out.println("Ви маєте обов'язково ввести якесь ім'я: ");
            name = sc.nextLine();
        }
        System.out.println("Введіть вік студента: ");
        while (true) {
            if (sc.hasNextInt()) {
                age = sc.nextInt();
                if (age >= 16 && age <= 100) {
                    break;
                } else {
                    System.out.println("Ви маєте ввести число ВІД 16 ДО 100: ");
                }
            } else {
                System.out.println("Ви маєте ввести ЦІЛЕ ЧИСЛО: ");
                sc.next();
            }
        }
        System.out.println("Введіть середній бал студента: ");
        while (true) {
            if (sc.hasNextInt()) {
                grade = sc.nextInt();
                if (grade >= 0 && grade <= 100) {
                    break;
                } else {
                    System.out.println("Введіть оцінку ВІД 1 ДО 100: ");
                }
            } else {
                System.out.println("Ви маєте ввести ЦІЛЕ ЧИСЛО: ");
                sc.next();
            }
        }
        sc.nextLine();
        return new Student(name, age, grade);
    }
}

