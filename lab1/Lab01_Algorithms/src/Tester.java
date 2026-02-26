import utils.DataInput;
//123
public class Tester {
    public static void main(String[] args) {
        University naukma = new University("NaUKMA", 8);
        Faculty fi = new Faculty("FI", 5);
        Faculty fgn = new Faculty("FGN", 6);
        Department depOfMaths = new Department("Кафедра математики", 100, 10);
        Department depOfInformatics = new Department("Кафедра інформатики", 200, 15);
        Department depOfPhilosophy = new Department("Кафедра філософії", 50, 5);
        Department depOfHistory = new Department("Кафедра історії", 50, 5);

        Lecturer lecturerOne = new Lecturer("Митник Юрій", "PhD in Mathematics");
        Lecturer lecturerTwo = new Lecturer("Чорней Руслан", "PhD in Mathematics");
        Lecturer lecturerThree = new Lecturer("Щеглов Микита", "PhD in Mathematics");
        Lecturer lecturerFour = new Lecturer("Глибовець Андрій", "LOVE");
        Lecturer lecturerFive = new Lecturer("Пєчкурова Олена", "PhD in Informatics");
        Lecturer lecturerSix = new Lecturer("Кирієнко Оксана", "PhD in Informatics");
        Lecturer lecturerSeven = new Lecturer("Петро Порошенко", "PhD in Literature");
        Lecturer lecturerEight = new Lecturer("Сковорода Григорій", "PhD in History");
        Lecturer lecturerNine = new Lecturer("Могила Петро", "PhD in Philosophy");
        Lecturer lecturerTen = new Lecturer("Жозе Моуріньйо", "PhD in Philosophy");

        depOfMaths.addLecturer(lecturerOne);
        depOfMaths.addLecturer(lecturerTwo);
        depOfMaths.addLecturer(lecturerThree);
        depOfInformatics.addLecturer(lecturerFour);
        depOfInformatics.addLecturer(lecturerFive);
        depOfInformatics.addLecturer(lecturerSix);
        depOfHistory.addLecturer(lecturerSeven);
        depOfHistory.addLecturer(lecturerEight);
        depOfPhilosophy.addLecturer(lecturerNine);
        depOfPhilosophy.addLecturer(lecturerTen);

        Student studentOne = new Student("Мартинишин Віталій", 1, 1);
        Student studentTwo = new Student("Шаповал Родіон", 1, 1);
        Student studentThree = new Student("Вус Павло", 1, 1);
        Student studentFour = new Student("Цьопич Андрій", 1, 1);
        Student studentFive = new Student("Дмитро Гандзюр", 1, 1);
        Student studentSix = new Student("Роман Літвінчук", 1, 1);
        Student studentSeven = new Student("Франків Ярослав", 3, 3);
        Student studentEight = new Student("Аісарук Діана", 2, 2);
        Student studentNine = new Student("Нижник Вітя", 6, 2);
        Student studentTen = new Student("Кіченко Тимофій", 3, 3);

        Student studentEleven = new Student("Михайленко Олексій", 4, 4);
        Student studentTwelve = new Student("Рембо", 1, 3);
        Student studentThirteen = new Student("Тимошенко Олег", 6, 4);
        Student studentFourteen = new Student("Сиваківський Тарас", 4, 4);
        Student studentFifteen = new Student("Караульна Людмила", 5, 4);
        Student studentSixteen = new Student("Сандора", 4, 4);
        Student studentSeventeen = new Student("Сірник", 1, 1);
        Student studentEighteen = new Student("Пітура Олексій", 1, 1);
        Student studentNineteen = new Student("Подік Андрій", 2, 2);
        Student studentTwenty = new Student("ЕнКей", 2, 2);

        Student studentTwentyOne = new Student("Драбина", 3, 3);
        Student studentTwentyTwo = new Student("Ігор Федорович", 5, 3);
        Student studentTwentyThree = new Student("Іванов Юра", 4, 4);
        Student studentTwentyFour = new Student("Правник", 4, 4);
        Student studentTwentyFive = new Student("Шот Назар", 1, 1);
        Student studentTwentySix = new Student("Виталик", 1, 1);
        Student studentTwentySeven = new Student("Гантеля Богдан", 2, 2);
        Student studentTwentyEight = new Student("Шалун Назар", 2, 2);
        Student studentTwentyNine = new Student("Момрик Юра", 3, 3);
        Student studentThirty = new Student("Валах Олександр", 3, 3);

        depOfMaths.addStudent(studentOne);
        depOfMaths.addStudent(studentTwo);
        depOfMaths.addStudent(studentThree);
        depOfMaths.addStudent(studentFour);
        depOfMaths.addStudent(studentFive);
        depOfMaths.addStudent(studentSix);
        depOfMaths.addStudent(studentSeven);
        depOfMaths.addStudent(studentEight);
        depOfInformatics.addStudent(studentNine);
        depOfInformatics.addStudent(studentTen);
        depOfInformatics.addStudent(studentEleven);
        depOfInformatics.addStudent(studentTwelve);
        depOfInformatics.addStudent(studentThirteen);
        depOfInformatics.addStudent(studentFourteen);
        depOfInformatics.addStudent(studentFifteen);
        depOfInformatics.addStudent(studentSixteen);
        depOfHistory.addStudent(studentSeventeen);
        depOfHistory.addStudent(studentEighteen);
        depOfHistory.addStudent(studentNineteen);
        depOfHistory.addStudent(studentTwenty);
        depOfHistory.addStudent(studentTwentyOne);
        depOfHistory.addStudent(studentTwentyTwo);
        depOfHistory.addStudent(studentTwentyThree);
        depOfPhilosophy.addStudent(studentTwentyFour);
        depOfPhilosophy.addStudent(studentTwentyFive);
        depOfPhilosophy.addStudent(studentTwentySix);
        depOfPhilosophy.addStudent(studentTwentySeven);
        depOfPhilosophy.addStudent(studentTwentyEight);
        depOfPhilosophy.addStudent(studentTwentyNine);
        depOfPhilosophy.addStudent(studentThirty);


        fi.addDepartment(depOfMaths);
        fi.addDepartment(depOfInformatics);
        fgn.addDepartment(depOfPhilosophy);
        fgn.addDepartment(depOfHistory);

        naukma.addFaculty(fi);
        naukma.addFaculty(fgn);

        while (true){
            System.out.println("Виберіть дію, яку хочете виконати з цієї бібліотеки до університету НаУКМА: ");
            System.out.println("1 - Створити/видалити/редагувати факультет");
            System.out.println("2 - Створити/видалити/редагувати кафедру факультету");
            System.out.println("3 - Додати/видалити/редагувати студента/викладача до кафедри");
            System.out.println("4 - Знайти студента/викладача за ПІБ, курсом або групою");
            System.out.println("5 - Вивести всіх студентів впорядкованих за курсами");
            System.out.println("6 - Вивести всіх студентів/викладачів факультета впорядкованих за алфавітом ");
            System.out.println("7 - Вивести всіх студентів кафедри впорядкованих за курсами ");
            System.out.println("8 - Вивести всіх студентів/викладачів кафедри впорядкованих за алфавітом");
            System.out.println("9 - Вивести всіх студентів кафедри вказаного курсу");
            System.out.println("10 - Вивести всіх студентів кафедри вказаного курсу впорядкованих за алфавітом");
            System.out.println("11 - Вивести всі факультети і їхні кафедри: ");
            System.out.println("12 - Завершити ");
            int numberOfAction = DataInput.getInt("Введіть ваш вибір: ");
            while (numberOfAction < 1 || numberOfAction > 12){
                numberOfAction = DataInput.getInt("Вам потрібно ввести число ВІД 1 ДО 12: ");
            }
            switch (numberOfAction) {
                case 1:
                    workWithFaculty(naukma);
                    break;
                case 2:
                    workWithDepartment(naukma);
                    break;
                case 3:
                    workWithDepartmentMembers(naukma);
                    break;
                case 4:
                    workWithFindingMembers(naukma);
                    break;
                case 5:
                    naukma.printAllStudentsSortedByCourse();
                    break;
                case 6:
                    getAllStudentsOrLecturersOfFacultyInAlphabeticalOrder(naukma);
                    break;
                case 7:
                    getAllStudentsOfDepartmentSortedByCourse(naukma);
                    break;
                case 8:
                    getAllStudentsOrLecturersOfDeparmentInAlphabeticalOrder(naukma);
                    break;
                case 9:
                    getAllStudentsOfDepartmentByCourse(naukma);
                    break;
                case 10:
                    getAllStudentsOfDepartmentByCourseSortedAlphabetically(naukma);
                    break;
                case 11:
                    printAllFacultiesAndDepartments(naukma);
                    break;
                case 12:
                   return;
            }
        }
    }

    private static void printAllFacultiesAndDepartments(University naukma) {
        if(naukma.numOfFaculties != 0){
            System.out.println("Факультети: ");
            for(int i = 0; i < naukma.numOfFaculties; i++){
                System.out.println(naukma.faculties[i].getName());
                System.out.println("Його кафедри: ");
                if(naukma.faculties[i].numOfDepartments != 0){
                    for (int j = 0; j < naukma.faculties[i].numOfDepartments; j++){
                        System.out.println(naukma.faculties[i].departments[j].getName());
                    }
                } else {
                    System.out.println("Схоже, що в цьому факультеті ще немає кафедр(((");
                }
            }
        } else {
            System.out.println("Схоже, що в цьому університеті ще немає факультетів(((");
        }
    }

    private static void getAllStudentsOfDepartmentByCourseSortedAlphabetically(University university) {
        if (university.numOfFaculties == 0) {
            System.out.println("Цей університет не має факультетів");
            return;
        }
        Faculty faculty;
        // Користувач обирає факультет
        int numOfFaculties = university.numOfFaculties;
        System.out.println("Виберіть факультет: ");
        for (int i = 1; i <= numOfFaculties; i++)
            System.out.println(i + " - " + university.faculties[i-1].getName());
        int mod = DataInput.getInt("");
        while (mod < 1 || mod > numOfFaculties)
            mod = DataInput.getInt("Вам треба ввести число від 1 до " + (numOfFaculties) + " : ");
        faculty = university.faculties[mod-1];

        if (faculty.numOfDepartments == 0) {
            System.out.println("Цей факультет не має кафедр");
            return;
        }

        Department department;
        // Користувач обирає кафедру
        int numOfDeps = faculty.numOfDepartments;
        System.out.println("Виберіть кафедру: ");
        for (int i = 1; i <= numOfDeps; i++)
            System.out.println(i + " - " + faculty.departments[i-1].getName());
        int mod2 = DataInput.getInt("");
        while (mod2 < 1 || mod2 > numOfDeps)
            mod2 = DataInput.getInt("Вам треба ввести число від 1 до " + (numOfDeps) + " : ");
        department = faculty.departments[mod2-1];

        int choice = DataInput.getInt("Введіть курс, студентів якого ви хочете знайти: ");
        while (choice < 1 || choice > 6) choice = DataInput.getInt("Ввеідть число від 1 до 6: ");

        Student[] students = department.getAlphabeticallySortedStudentsByCourse(choice);
        if (students.length == 0) System.out.println("Немає студентів такого курсу");
        else {
            for (Student student : students) {
                if (student == null) break;
                System.out.println(student);
            }
        }

    }

    private static void getAllStudentsOfDepartmentByCourse(University university) {
        if (university.numOfFaculties == 0) {
            System.out.println("Цей університет не має факультетів");
            return;
        }
        Faculty faculty;
        // Користувач обирає факультет
        int numOfFaculties = university.numOfFaculties;
        System.out.println("Виберіть факультет: ");
        for (int i = 1; i <= numOfFaculties; i++)
            System.out.println(i + " - " + university.faculties[i-1].getName());
        int mod = DataInput.getInt("");
        while (mod < 1 || mod > numOfFaculties)
            mod = DataInput.getInt("Вам треба ввести число від 1 до " + (numOfFaculties) + " : ");
        faculty = university.faculties[mod-1];

        if (faculty.numOfDepartments == 0) {
            System.out.println("Цей факультет не має кафедр");
            return;
        }

        Department department;
        // Користувач обирає кафедру
        int numOfDeps = faculty.numOfDepartments;
        System.out.println("Виберіть кафедру: ");
        for (int i = 1; i <= numOfDeps; i++)
            System.out.println(i + " - " + faculty.departments[i-1].getName());
        int mod2 = DataInput.getInt("");
        while (mod2 < 1 || mod2 > numOfDeps)
            mod2 = DataInput.getInt("Вам треба ввести число від 1 до " + (numOfDeps) + " : ");
        department = faculty.departments[mod2-1];

        int choice = DataInput.getInt("Введіть курс, студентів якого ви хочете знайти: ");
        while (choice < 1 || choice > 6) choice = DataInput.getInt("Ввеідть число від 1 до 6: ");

        Student[] students = department.getStudentsByCourse(choice);
        if (students.length == 0) System.out.println("Немає студентів такого курсу");
        else {
            for (Student student : students) {
                if (student == null) break;
                System.out.println(student);
            }
        }
    }

    private static void getAllStudentsOrLecturersOfDeparmentInAlphabeticalOrder(University university) {
        if (university.numOfFaculties == 0) {
            System.out.println("Цей університет не має факультетів");
            return;
        }
        Faculty faculty;
        // Користувач обирає факультет
        int numOfFaculties = university.numOfFaculties;
        System.out.println("Виберіть факультет: ");
        for (int i = 1; i <= numOfFaculties; i++)
            System.out.println(i + " - " + university.faculties[i-1].getName());
        int mod = DataInput.getInt("");
        while (mod < 1 || mod > numOfFaculties)
            mod = DataInput.getInt("Вам треба ввести число від 1 до " + (numOfFaculties) + " : ");
        faculty = university.faculties[mod-1];

        if (faculty.numOfDepartments == 0) {
            System.out.println("Цей факультет не має кафедр");
            return;
        }

        Department department;
        // Користувач обирає кафедру
        int numOfDeps = faculty.numOfDepartments;
        System.out.println("Виберіть кафедру: ");
        for (int i = 1; i <= numOfDeps; i++)
            System.out.println(i + " - " + faculty.departments[i-1].getName());
        int mod2 = DataInput.getInt("");
        while (mod2 < 1 || mod2 > numOfDeps)
            mod2 = DataInput.getInt("Вам треба ввести число від 1 до " + (numOfDeps) + " : ");
        department = faculty.departments[mod2-1];

        // Користувач обирає сортувати або студентів, або лекторів
        int choice = DataInput.getInt("Введіть 0 щоб повернути сортованих студентів," +
                " або 1 щоб повернути сортованих викладачів: ");
        while (choice != 0 && choice != 1) choice = DataInput.getInt("Введіть або 0, або 1: ");

        switch (choice) {
            case 0:
                Student[] studs = department.getAlphabeticallySortedStudents();
                for (Student student : studs) {
                    if (student == null) break;
                    System.out.println(student);
                }
                break;

            case 1:
                Lecturer[] lecs = department.getAlphabeticallySortedLecturers();
                for (Lecturer lecturer : lecs) {
                    if (lecturer == null) break;
                    System.out.println(lecturer);
                }
                break;
        }
    }

    private static void getAllStudentsOfDepartmentSortedByCourse(University university) {
        if (university.numOfFaculties == 0) {
            System.out.println("Цей університет не має факультетів");
            return;
        }
        Faculty faculty;
        // Користувач обирає факультет
        int numOfFaculties = university.numOfFaculties;
        System.out.println("Виберіть факультет: ");
        for (int i = 1; i <= numOfFaculties; i++)
            System.out.println(i + " - " + university.faculties[i-1].getName());
        int mod = DataInput.getInt("");
        while (mod < 1 || mod > numOfFaculties)
            mod = DataInput.getInt("Вам треба ввести число від 1 до " + (numOfFaculties) + " : ");
        faculty = university.faculties[mod-1];

        if (faculty.numOfDepartments == 0) {
            System.out.println("Цей факультет не має кафедр");
            return;
        }

        Department department;
        // Користувач обирає кафедру
        int numOfDeps = faculty.numOfDepartments;
        System.out.println("Виберіть кафедру: ");
        for (int i = 1; i <= numOfDeps; i++)
            System.out.println(i + " - " + faculty.departments[i-1].getName());
        int mod2 = DataInput.getInt("");
        while (mod2 < 1 || mod2 > numOfDeps)
            mod2 = DataInput.getInt("Вам треба ввести число від 1 до " + (numOfDeps) + " : ");
        department = faculty.departments[mod2-1];

        Student[] students = department.getStudentsSortedByCourse();
        for (Student student : students){
            if (student == null) break;
            System.out.println(student);
        }
    }

    private static void getAllStudentsOrLecturersOfFacultyInAlphabeticalOrder(University university) {
        if (university.numOfFaculties == 0) {
            System.out.println("Цей університет не має факультетів");
            return;
        }
        Faculty faculty;
        // Користувач обирає факультет
        int numOfFaculties = university.numOfFaculties;
        System.out.println("Виберіть факультет: ");
        for (int i = 1; i <= numOfFaculties; i++)
            System.out.println(i + " - " + university.faculties[i-1].getName());
        int mod = DataInput.getInt("");
        while (mod < 1 || mod > numOfFaculties)
            mod = DataInput.getInt("Вам треба ввести число від 1 до " + (numOfFaculties) + " : ");
        faculty = university.faculties[mod-1];

        // Користувач обирає сортувати або студентів, або лекторів
        int choice = DataInput.getInt("Введіть 0 щоб повернути сортованих студентів," +
                " або 1 щоб повернути сортованих викладачів: ");
        while (choice != 0 && choice != 1) choice = DataInput.getInt("Введіть або 0, або 1: ");

        switch (choice) {
            case 0:
                Student[] studs = faculty.getSortedStudents();
                for (Student student : studs) {
                    if (student == null) break;
                    System.out.println(student);
                }
            break;

            case 1:
                Lecturer[] lecs = faculty.getSortedLecturers();
                for (Lecturer lecturer : lecs) {
                    if (lecturer == null) break;
                    System.out.println(lecturer);
                }
            break;
        }
    }
    private static void workWithFindingMembers(University naukma) {
        int choiceOne = DataInput.getInt("Введіть 0, щоб знайти студента, або 1, щоб знайти викладача: ");
        while (choiceOne < 0 || choiceOne > 1){
            choiceOne = DataInput.getInt("Вам потрібно ввести 0 АБО 1: ");
        }
        if (choiceOne == 1){
            String name = DataInput.getString("Введіть ПІБ викладача, якого хочете найти: ");
            Lecturer[] lecturersWithCertainFullName = naukma.findLecturersByName(name);
            if (lecturersWithCertainFullName.length != 0){
                for (Lecturer lecturer : lecturersWithCertainFullName) {
                    System.out.println(lecturer.toString());
                }
            } else {
                System.out.println("Схоже, що такого викладача немає в цьому університеті");
            }
        } else {
            int choiceTwo = DataInput.getInt("Введіть 0, щоб знайти за ПІБ, 1 - за курсом, 2 - за групою: ");
            while (choiceTwo < 0 || choiceTwo > 2){
                choiceTwo = DataInput.getInt("Вам потрібно ввести число ВІД 0 ДО 2: ");
            }
            if (choiceTwo == 0){
                String name = DataInput.getString("Введіть ПІБ студента, якого хочете найти: ");
                Student[] studentsWithCertainFullName = naukma.findStudentsByName(name);
                if (studentsWithCertainFullName.length != 0){
                    for (Student student : studentsWithCertainFullName) {
                        System.out.println(student.toString());
                    }
                } else {
                    System.out.println("Схоже, що такого студента немає в цьому університеті: ");
                }
            } else if (choiceTwo == 1){
                int course = DataInput.getInt("Введіть курс, за яким будемо шукати: ");
                while (course < 0 || course > 6){
                    course = DataInput.getInt("Вам потрібно ввести число ВІД 1 ДО 6: ");
                }
                Student[] studentsWithCertainCourse = naukma.findStudentsByCourse(course);
                if (studentsWithCertainCourse.length != 0){
                    for (Student student : studentsWithCertainCourse) {
                        System.out.println(student.toString());
                    }
                } else {
                    System.out.println("Схоже, що таких студентів немає в цьому університеті");
                }
            } else {
                int group = DataInput.getInt("Введіть групу, за якою будемо шукати: ");
                Student[] studentsWithCertainGroup = naukma.findStudentsByGroup(group);
                if (studentsWithCertainGroup.length != 0){
                    for (Student student : studentsWithCertainGroup) {
                        System.out.println(student.toString());
                    }
                } else {
                    System.out.println("Схоже, що таких студентів немає в цьому університеті");
                }
            }
        }
    }

    private static void workWithDepartmentMembers(University naukma) {
        int choice = DataInput.getInt("Введіть 0, щоб додати, 1 - видалити, 2 - редагувати студента/викладача: ");
        while (choice < 0 || choice > 2) {
            choice = DataInput.getInt("Вам потрібно ввести число ВІД 0 ДО 2: ");
        }
        if (choice == 0){
            int choiceOne = DataInput.getInt("Введіть 0, щоб додати студента, або 1, щоб додати викладача: ");
            while (choiceOne < 0 || choiceOne > 1){
                choiceOne = DataInput.getInt("Вам потрібно ввести 0 АБО 1: ");
            }
            if (choiceOne == 0){
                String name = DataInput.getString("Введіть ПІБ: ");
                int course = DataInput.getInt("Введіть курс навчання: ");
                while (course < 0 || course > 6){
                    course = DataInput.getInt("Вам потрібно ввести число ВІД 1 ДО 6: ");
                }
                int group = DataInput.getInt("Введіть групу навчання: ");
                Student newStudent = new Student(name, course, group);
                if(naukma.numOfFaculties != 0){
                    for(int i = 1; i <= naukma.numOfFaculties; i++){
                        System.out.println("Введіть " + i  + ", щоб вибрати факультет" + naukma.faculties[i-1].getName());
                    }
                    int choiceOfFaculty = DataInput.getInt("Введіть ваш вибір: ");
                    while (choiceOfFaculty < 1 || choiceOfFaculty > naukma.numOfFaculties){
                        choiceOfFaculty = DataInput.getInt("Вам потрібно ввести число ВІД 1 ДО " + naukma.numOfFaculties + ": ");
                    }
                    if(naukma.faculties[choiceOfFaculty-1].numOfDepartments != 0){
                        for(int i = 1; i <= naukma.faculties[choiceOfFaculty-1].numOfDepartments; i++){
                            System.out.println("Введіть " + i  + ", щоб вибрати кафедру" + naukma.faculties[choiceOfFaculty-1].departments[i-1].getName());
                        }
                        int choiceTwo = DataInput.getInt("Введіть ваш вибір: ");
                        while (choiceTwo < 1 || choiceTwo > naukma.faculties[choiceOfFaculty-1].numOfDepartments){
                            choiceTwo = DataInput.getInt("Вам потрібно ввести число ВІД 1 ДО " + naukma.faculties[choiceOfFaculty-1].numOfDepartments + ": ");
                        }
                        if (naukma.faculties[choiceOfFaculty - 1].departments[choiceTwo-1].findOverlapStudents(name))
                            System.out.println("Студент з таким ПІБ уже існує на цій кафедрі(");
                        else
                            naukma.faculties[choiceOfFaculty - 1].departments[choiceTwo-1].addStudent(newStudent);
                    } else {
                        System.out.println("Схоже, що в цьому факультеті ще немає кафедр(((");
                    }
                } else {
                    System.out.println("Схоже, що в цьому університеті ще немає факультетів(((");
                }
            } else {
                String name = DataInput.getString("Введіть ПІБ: ");
                String degree = DataInput.getString("Введіть вчений ступінь: ");
                Lecturer newLecturer = new Lecturer(name, degree);
                if(naukma.numOfFaculties != 0){
                    for(int i = 1; i <= naukma.numOfFaculties; i++){
                        System.out.println("Введіть " + i  + ", щоб вибрати факультет" + naukma.faculties[i-1].getName());
                    }
                    int choiceOfFaculty = DataInput.getInt("Введіть ваш вибір: ");
                    while (choiceOfFaculty < 1 || choiceOfFaculty > naukma.numOfFaculties){
                        choiceOfFaculty = DataInput.getInt("Вам потрібно ввести число ВІД 1 ДО " + naukma.numOfFaculties + ": ");
                    }
                    if(naukma.faculties[choiceOfFaculty-1].numOfDepartments != 0){
                        for(int i = 1; i <= naukma.faculties[choiceOfFaculty-1].numOfDepartments; i++){
                            System.out.println("Введіть " + i  + ", щоб вибрати кафедру" + naukma.faculties[choiceOfFaculty-1].departments[i-1].getName());
                        }
                        int choiceTwo = DataInput.getInt("Введіть ваш вибір: ");
                        while (choiceTwo < 1 || choiceTwo > naukma.faculties[choiceOfFaculty-1].numOfDepartments){
                            choiceTwo = DataInput.getInt("Вам потрібно ввести число ВІД 1 ДО " + naukma.faculties[choiceOfFaculty-1].numOfDepartments + ": ");
                        }
                        if (naukma.faculties[choiceOfFaculty - 1].departments[choiceTwo-1].findOverlapLecturers(name))
                            System.out.println("Викладачам з таким ПІБ уже існує на цій кафедрі(");
                        else
                            naukma.faculties[choiceOfFaculty - 1].departments[choiceTwo-1].addLecturer(newLecturer);
                    } else {
                        System.out.println("Схоже, що в цьому факультеті ще немає кафедр(((");
                    }
                } else {
                    System.out.println("Схоже, що в цьому університеті ще немає факультетів(((");
                }
            }
        } else if (choice == 1) {
            int choiceOne = DataInput.getInt("Введіть 0, щоб видалити студента, або 1, щоб видалити викладача: ");
            while (choiceOne < 0 || choiceOne > 1){
                choiceOne = DataInput.getInt("Вам потрібно ввести 0 АБО 1: ");
            }
            if (choiceOne == 0){
                String name = DataInput.getString("Введіть ПІБ: ");
                int course = DataInput.getInt("Введіть курс навчання: ");
                while (course < 0 || course > 6){
                    course = DataInput.getInt("Вам потрібно ввести число ВІД 1 ДО 6: ");
                }
                int group = DataInput.getInt("Введіть групу навчання: ");
                if(naukma.findCertainStudent(name, group, course) != null) {
                    naukma.findStudentDepartment(name, course, group).deleteStudent(naukma.findCertainStudent(name, group, course));
                } else {
                    System.out.println("Схоже, що немає такого студента");
                }
            } else {
                String name = DataInput.getString("Введіть ПІБ: ");
                if(naukma.findCertainLecturer(name) != null) {
                    naukma.findLecturerDepartment(name).deleteLecturer(naukma.findCertainLecturer(name));
                } else {
                    System.out.println("Схоже, що немає такого викладача");
                }
            }
        } else {
            int choiceOne = DataInput.getInt("Введіть 0, щоб редагувати студента, або 1, щоб редагувати викладача: ");
            while (choiceOne < 0 || choiceOne > 1){
                choiceOne = DataInput.getInt("Вам потрібно ввести 0 АБО 1: ");
            }
            if (choiceOne == 0){
                String name = DataInput.getString("Введіть ПІБ: ");
                int course = DataInput.getInt("Введіть курс навчання: ");
                while (course < 0 || course > 6){
                    course = DataInput.getInt("Вам потрібно ввести число ВІД 1 ДО 6: ");
                }
                int group = DataInput.getInt("Введіть групу навчання: ");
                Student currentStudent = naukma.findCertainStudent(name, group, course);
                Department currentDepartment = naukma.findStudentDepartment(name, group, course);
                if (currentStudent != null){
                    if(naukma.numOfFaculties != 0){
                        for(int i = 1; i <= naukma.numOfFaculties; i++){
                            System.out.println("Введіть " + i  + ", щоб додати цього студента до кафедри " + naukma.faculties[i-1].getName());
                        }
                        int choiceTwo = DataInput.getInt("Введіть ваш вибір: ");
                        while (choiceTwo < 1 || choiceTwo > naukma.numOfFaculties){
                            choiceTwo = DataInput.getInt("Вам потрібно ввести число ВІД 1 ДО " + naukma.numOfFaculties + ": ");
                        }
                        if(naukma.faculties[choiceTwo-1].numOfDepartments != 0){
                            for(int i = 1; i <= naukma.faculties[choiceTwo-1].numOfDepartments; i++){
                                System.out.println("Введіть " + i  + ", щоб додати цього студента до кафедри " + naukma.faculties[choiceTwo-1].departments[i-1].getName());
                            }
                            int choiceThree = DataInput.getInt("Введіть ваш вибір: ");
                            while (choiceThree < 1 || choiceThree > naukma.faculties[choiceTwo-1].numOfDepartments){
                                choiceThree = DataInput.getInt("Вам потрібно ввести число ВІД 1 ДО " + naukma.faculties[choiceTwo-1].numOfDepartments + ": ");
                            }
                            currentDepartment.changeDepartment(currentStudent, naukma.faculties[choiceTwo - 1].departments[choiceThree-1]);
                        } else {
                            System.out.println("Схоже, що в цьому факультеті ще немає кафедр(((");
                        }
                    } else {
                        System.out.println("Схоже, що в цьому університеті ще немає факультетів(((");
                    }
                } else {
                    System.out.println("Схоже, що немає такого студента");
                }
            } else {
                String name = DataInput.getString("Введіть ПІБ: ");
                Lecturer currentLecturer = naukma.findCertainLecturer(name);
                Department currentDepartment = naukma.findLecturerDepartment(name);
                if (currentLecturer != null){
                    if(naukma.numOfFaculties != 0){
                        for(int i = 1; i <= naukma.numOfFaculties; i++){
                            System.out.println("Введіть " + i  + ", щоб додати цього викладача до кафедри" + naukma.faculties[i-1].getName());
                        }
                        int choiceTwo = DataInput.getInt("Введіть ваш вибір: ");
                        while (choiceTwo < 1 || choiceTwo > naukma.numOfFaculties){
                            choiceTwo = DataInput.getInt("Вам потрібно ввести число ВІД 1 ДО " + naukma.numOfFaculties + ": ");
                        }
                        if(naukma.faculties[choiceTwo-1].numOfDepartments != 0){
                            for(int i = 1; i <= naukma.faculties[choiceTwo-1].numOfDepartments; i++){
                                System.out.println("Введіть " + i  + ", щоб додати цього викладача до кафедри" + naukma.faculties[choiceTwo-1].departments[i-1].getName());
                            }
                            int choiceThree = DataInput.getInt("Введіть ваш вибір: ");
                            while (choiceThree < 1 || choiceThree > naukma.faculties[choiceTwo -1].numOfDepartments){
                                choiceThree = DataInput.getInt("Вам потрібно ввести число ВІД 1 ДО " + naukma.faculties[choiceTwo-1].numOfDepartments + ": ");
                            }
                            currentDepartment.changeDepartment(currentLecturer, naukma.faculties[choiceTwo - 1].departments[choiceThree-1]);
                        } else {
                            System.out.println("Схоже, що в цьому факультеті ще немає кафедр(((");
                        }
                    } else {
                        System.out.println("Схоже, що в цьому університеті ще немає факультетів(((");
                    }
                } else {
                    System.out.println("Схоже, що немає такого викладача");
                }
            }
        }
    }

    private static void workWithDepartment(University naukma) {
        int choiceOfAction = DataInput.getInt("Введіть число 1, щоб додати нову кафедру, 2 - видалити вже існуючу, 3 -  редагувати існуючу: ");
        while (choiceOfAction < 1 || choiceOfAction > 3){
            choiceOfAction = DataInput.getInt("Введіть число ВІД 1 ДО 3: ");
        }
        if (choiceOfAction == 1){
            String name = DataInput.getString("Введіть назву нової кафедри : ");
            int maxNumOfStudents = DataInput.getInt("Введіть максимальну к-сть студентів: ");
            while (maxNumOfStudents <1){
                maxNumOfStudents = DataInput.getInt("Введіть ДОДАТНЄ число: ");
            }
            int maxNumOfLecturers = DataInput.getInt("Введіть максимальну к-сть викладачів: ");
            while (maxNumOfLecturers <1){
                maxNumOfLecturers = DataInput.getInt("Введіть ДОДАТНЄ число: ");
            }
            for(int i = 1; i <= naukma.numOfFaculties; i++){
                System.out.println("Введіть " + i  + ", щоб додати кафедру до " + naukma.faculties[i-1].getName());
            }
            int choiceOne = DataInput.getInt("Введіть ваш вибір: ");
            while (choiceOne < 1 || choiceOne > naukma.numOfFaculties){
                choiceOne = DataInput.getInt("Вам потрібно ввести число ВІД 1 ДО " + naukma.numOfFaculties + ": ");
            }
            if (naukma.faculties[choiceOne - 1].findOverlap(name)) name = DataInput.getString("Така кафедра уже існує(");
            else {
                Department department = new Department(name, maxNumOfStudents, choiceOfAction);
                naukma.faculties[choiceOne - 1].addDepartment(department);
            }
        } else if (choiceOfAction == 2){
            if(naukma.numOfFaculties != 0){
                for(int i = 1; i <= naukma.numOfFaculties; i++){
                    System.out.println("Введіть " + i  + ", щоб видалити кафедру " + naukma.faculties[i-1].getName());
                }
                int choiceOne = DataInput.getInt("Введіть ваш вибір: ");
                while (choiceOne < 1 || choiceOne > naukma.numOfFaculties){
                    choiceOne = DataInput.getInt("Вам потрібно ввести число ВІД 1 ДО " + naukma.numOfFaculties + ": ");
                }
                if (naukma.faculties[choiceOne - 1].numOfDepartments != 0){
                    for(int i = 1; i <= naukma.faculties[choiceOne-1].numOfDepartments; i++){
                        System.out.println("Введіть " + i  + ", щоб редагувати кафедри " + naukma.faculties[choiceOne-1].departments[i-1].getName());
                    }
                    int choiceTwo = DataInput.getInt("Введіть ваш вибір: ");
                    while (choiceTwo < 1 || choiceTwo > naukma.faculties[choiceOne-1].numOfDepartments){
                        choiceTwo = DataInput.getInt("Вам потрібно ввести число ВІД 1 ДО " + naukma.faculties[choiceOne-1].numOfDepartments + ": ");
                    }
                    naukma.faculties[choiceOne -1].deleteDepartment(naukma.faculties[choiceOne -1].departments[choiceTwo -1]);
                } else {
                    System.out.println("Схоже, що в цьому факультеті ще немає кафедр(((");
                }
            } else {
                System.out.println("Схоже, що в цьому університеті ще немає факультетів(((");
            }
        } else {
            if(naukma.numOfFaculties != 0){
                for(int i = 1; i <= naukma.numOfFaculties; i++){
                    System.out.println("Введіть " + i  + ", щоб редагувати кафедри " + naukma.faculties[i-1].getName());
                }
                int choiceOne = DataInput.getInt("Введіть ваш вибір: ");
                while (choiceOne < 1 || choiceOne > naukma.numOfFaculties){
                    choiceOne = DataInput.getInt("Вам потрібно ввести число ВІД 1 ДО " + naukma.numOfFaculties + ": ");
                }
                if(naukma.faculties[choiceOne-1].numOfDepartments != 0){
                    for(int i = 1; i <= naukma.faculties[choiceOne-1].numOfDepartments; i++){
                        System.out.println("Введіть " + i  + ", щоб редагувати кафедри " + naukma.faculties[choiceOne-1].departments[i-1].getName());
                    }
                    int choiceTwo = DataInput.getInt("Введіть ваш вибір: ");
                    while (choiceTwo < 1 || choiceTwo > naukma.faculties[choiceOne-1].numOfDepartments){
                        choiceTwo = DataInput.getInt("Вам потрібно ввести число ВІД 1 ДО " + naukma.faculties[choiceOne-1].numOfDepartments + ": ");
                    }
                    naukma.faculties[choiceOne - 1].departments[choiceTwo-1].editDepartment();
                } else {
                    System.out.println("Схоже, що в цьому факультеті ще немає кафедр(((");
                }
            } else {
                System.out.println("Схоже, що в цьому університеті ще немає факультетів(((");
            }
        }

    }

    private static void workWithFaculty(University naukma) {
       int choiceOfAction = DataInput.getInt("Введіть число 1, щоб додати новий факультет, 2 - видалити вже існуючий, 3 -  редагувати існуючий: ");
       while (choiceOfAction < 1 || choiceOfAction > 3){
           choiceOfAction = DataInput.getInt("Введіть число ВІД 1 ДО 3: ");
       }
       if (choiceOfAction == 1){
           String name = DataInput.getString("Введіть назву нового факультету: ");
           while (naukma.findOverlap(name)) name = DataInput.getString("Такйи факультет уже існує. Введіть назву нового факультету: ");
           int maxNumOfStudents = DataInput.getInt("Введіть максимальну к-сть кафедр: ");
           while (maxNumOfStudents <1){
               maxNumOfStudents = DataInput.getInt("Введіть ДОДАТНЄ число: ");
           }
           Faculty newFaculty = new Faculty(name, maxNumOfStudents);
           naukma.addFaculty(newFaculty);
       } else if (choiceOfAction == 2){
           if(naukma.numOfFaculties != 0){
               for(int i = 1; i <= naukma.numOfFaculties; i++){
                   System.out.println("Введіть " + i  + ", щоб видалити " + naukma.faculties[i-1].getName());
               }
               int choiceOne = DataInput.getInt("Введіть ваш вибір: ");
               while (choiceOne < 1 || choiceOne > naukma.numOfFaculties){
                   choiceOne = DataInput.getInt("Вам потрібно ввести число ВІД 1 ДО " + naukma.numOfFaculties + ": ");
               }
               naukma.deleteFaculty(naukma.faculties[choiceOne-1]);
           } else {
               System.out.println("Схоже, що в цьому університеті ще немає факультетів(((");
           }
       } else {
           if(naukma.numOfFaculties != 0){
               for(int i = 1; i <= naukma.numOfFaculties; i++){
                   System.out.println("Введіть " + i  + ", щоб редагувати" + naukma.faculties[i-1].getName());
               }
               int choice = DataInput.getInt("Введіть ваш вибір: ");
               while (choice < 1 || choice > naukma.numOfFaculties){
                   choice = DataInput.getInt("Вам потрібно ввести число ВІД 1 ДО " + naukma.numOfFaculties + ": ");
               }
               naukma.faculties[choice - 1].editFaculty();
           } else {
               System.out.println("Схоже, що в цьому університеті ще немає факультетів(((");
           }
       }
    }
}
