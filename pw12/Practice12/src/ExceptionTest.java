import utils.DataInput;

class IncorrectGradeInputException extends Exception{
    public IncorrectGradeInputException(String message) {
        super(message);
    }
}

public class ExceptionTest {

    public void getGrade() throws IncorrectGradeInputException{
        int grade = DataInput.getInt("Введіть оцінку студента:");
        if (grade < 0 || grade > 100) {
            throw new IncorrectGradeInputException("Ця оцінка не є коректною: " + grade);
        } else {
            System.out.println("Оцінка коректна: " + grade);
        }

    }
    public static void main(String[] args){
        ExceptionTest test = new ExceptionTest();
        while (true) {

            try {
                test.getGrade();
            } catch (IncorrectGradeInputException e) {
                System.out.println("Виняток спіймано: " + e.getMessage());
            }

            int choice;
            while (true) {
                choice = DataInput.getInt("Продовжуємо? Введіть 1 для продовження або 0 для виходу: ");
                if (choice == 0 || choice == 1) {
                    break;
                } else {
                    System.out.println("Ви ввели неправильне число! Введіть 1 для продовження або 0 для виходу.");
                }
            }
            if (choice == 0) {
                System.out.println("Програму завершено!");
                break;
            }
        }
    }
}