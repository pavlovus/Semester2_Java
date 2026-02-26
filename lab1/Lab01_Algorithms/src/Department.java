import utils.DataInput;
import java.util.Arrays;

public class Department {

    private String name;
    public Student[] students;
    public Lecturer[] lecturers;
    public int numOfStudents;
    public int numOfLecturers;

    public Department(String name, int maxNumOfStudents, int maxNumOfLecturers) {
        this.name = name;
        students = new Student[maxNumOfStudents];
        lecturers = new Lecturer[maxNumOfLecturers];
        this.numOfStudents = 0;
        this.numOfLecturers = 0;
    }

    /**
     * Edits the department based on user input.
     */
    public void editDepartment() {
        int choice = DataInput.getInt("Введіть 1 - змінити назву кафедри, 2 - змінити максимальну к-сть студентів, 3 - змінити максимальну к-сть викладачів: ");
        while (choice < 1 || choice > 3) {
            choice = DataInput.getInt("Ви маєте ввести число ВІД 1 ДО 3: ");
        }
        if (choice == 1) {
            String newName = DataInput.getString("Введіть нову назву кафедри: ");
            this.setName(newName);
            System.out.println("Назву кафедри успішно змінено!!!");
        } else if (choice == 2) {
            int newMaxNumOfStudents = DataInput.getInt("Введіть нову максимальну к-сть студентів: ");
            while (newMaxNumOfStudents < 1){
                newMaxNumOfStudents = DataInput.getInt("Введіть ДОДАТНЄ число: ");
            }
            this.editNumOfStudents(newMaxNumOfStudents);
            if (numOfLecturers > newMaxNumOfStudents) {
                numOfLecturers = newMaxNumOfStudents;
            }
            System.out.println("Максимальну к-сть студентів успішно змінено!!!");
        } else {
            int newMaxNumOfLecturers = DataInput.getInt("Введіть нову максимальну к-сть лекторів: ");
            while (newMaxNumOfLecturers < 1){
                newMaxNumOfLecturers = DataInput.getInt("Введіть ДОДАТНЄ число: ");
            }
            this.editMaxNumOfLecturers(newMaxNumOfLecturers);
            if (numOfStudents > newMaxNumOfLecturers) {
                numOfStudents = newMaxNumOfLecturers;
            }
            System.out.println("Максимальну к-сть лекторів успішно змінено!!!");
        }
    }

    /**
     * Sorts students by their course.
     *
     * @return the sorted array of students
     */
    public Student[] getStudentsSortedByCourse() {
        Student[] arr = this.students;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == null) return arr;
            Student cur = arr[i];
            int j = i - 1;
            while (j >= 0 && cur.getCourse() < arr[j].getCourse()) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = cur;
        }
        return arr;
    }

    public boolean findOverlapLecturers(String str) {
        for (int i = 0; i < numOfLecturers; i++) {
            if (lecturers[i] == null) break;
            else if (lecturers[i].getFullName().equalsIgnoreCase(str)) return true;
        }
        return false;
    }

    public boolean findOverlapStudents(String str) {
        for (int i = 0; i < numOfStudents; i++) {
            if (students[i] == null) break;
            else if (students[i].getFullName().equalsIgnoreCase(str)) return true;
        }
        return false;
    }

    /**
     * Gets students of a specific course.
     *
     * @param course the course number
     * @return an array of students in the specified course
     */
    public Student[] getStudentsByCourse(int course) {
        int count = 0;
        for (int i = 0; i < this.numOfStudents; i++) {
            if (this.students[i].getCourse() == course) count++;
        }

        if (count == 0) return new Student[0];

        Student[] res = new Student[count];
        for (int i = 0, j = 0; i < numOfStudents; i++) {
            if (this.students[i].getCourse() == course) {
                res[j] = this.students[i];
                j++;
            }
        }
        return res;
    }

    /**
     * Gets students of a specific course, sorted alphabetically.
     *
     * @param course the course number
     * @return an array of students in the specified course, sorted alphabetically
     */
    public Student[] getAlphabeticallySortedStudentsByCourse(int course) {
        Student[] res = getStudentsByCourse(course);
        for (int i = 1; i < res.length; i++) {
            if (res[i] == null) return res;
            Student cur = res[i];
            int j = i - 1;
            while (j >= 0 && isFirstHigherThanTheSecond(cur.getFullName(), res[j].getFullName())) {
                res[j+1] = res[j];
                j--;
            }
            res[j+1] = cur;
        }
        return res;
    }

    /**
     * Gets all students sorted alphabetically.
     *
     * @return an array of all students, sorted alphabetically
     */
    public Student[] getAlphabeticallySortedStudents() {
        Student[] res = this.students;
        for (int i = 1; i < res.length; i++) {
            if (res[i] == null) return res;
            Student cur = res[i];
            int j = i - 1;
            while (j >= 0 && isFirstHigherThanTheSecond(cur.getFullName(), res[j].getFullName())) {
                res[j+1] = res[j];
                j--;
            }
            res[j+1] = cur;
        }
        return res;
    }

    /**
     * Gets all lecturers sorted alphabetically.
     *
     * @return an array of all lecturers, sorted alphabetically
     */
    public Lecturer[] getAlphabeticallySortedLecturers() {
        Lecturer[] res = this.lecturers;
        for (int i = 1; i < res.length; i++) {
            if (res[i] == null) return res;
            Lecturer cur = res[i];
            int j = i - 1;
            while (j >= 0 && isFirstHigherThanTheSecond(cur.getFullName(), res[j].getFullName())) {
                res[j+1] = res[j];
                j--;
            }
            res[j+1] = cur;
        }
        return res;
    }

    /**
     * Checks if the first string is alphabetically higher than the second string.
     *
     * @param str1 the first string
     * @param str2 the second string
     * @return true if the first string is higher, false otherwise
     */
    public static boolean isFirstHigherThanTheSecond(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());

        // If all the letters in a String are same but the
        // length is different the shorter one is put first
        boolean sameLetters = true;
        for (int i = 0; i < len; i++) {
            if (Character.toLowerCase(str1.charAt(i)) != Character.toLowerCase(str2.charAt(i))) {
                sameLetters = false;
            }
        }
        if (sameLetters) {
            return str1.length() == len;
        }

        // Checks if the first String is first in alphabetical order
        for (int i = 0; i < len; i++) {
            if (isCyrrilic(str1.charAt(i)) && isCyrrilic(str2.charAt(i))) {
                if (getCyrrilicIndex(Character.toUpperCase(str1.charAt(i))) < getCyrrilicIndex(Character.toUpperCase(str2.charAt(i)))) {
                    return true;
                } else if (getCyrrilicIndex(Character.toUpperCase(str1.charAt(i))) == getCyrrilicIndex(Character.toUpperCase(str2.charAt(i)))) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (Character.toLowerCase(str1.charAt(i)) < Character.toLowerCase(str2.charAt(i))) {
                    return true;
                } else if (Character.toLowerCase(str1.charAt(i)) == Character.toLowerCase(str2.charAt(i))) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Checks if a character is Cyrillic.
     *
     * @param c the character to check
     * @return true if the character is Cyrillic, false otherwise
     */
    private static boolean isCyrrilic(char c) {
        for (char letter : alphabet) {
            if (Character.toUpperCase(c) == letter) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the index of a Cyrillic character in the alphabet.
     *
     * @param c the character to get the index of
     * @return the index of the character
     */
    private static int getCyrrilicIndex(char c) {
        for (int i = 0; i < alphabet.length; i++) {
            if (Character.toUpperCase(c) == alphabet[i]) return i;
        }
        return -1;
    }

    /**
     * Edits the maximum number of lecturers.
     *
     * @param newMaxNumOfLecturers the new maximum number of lecturers
     */
    private void editMaxNumOfLecturers(int newMaxNumOfLecturers) {
        this.lecturers = Arrays.copyOf(this.lecturers, newMaxNumOfLecturers);
    }

    /**
     * Edits the maximum number of students.
     *
     * @param newMaxNumOfStudents the new maximum number of students
     */
    private void editNumOfStudents(int newMaxNumOfStudents) {
        this.students = Arrays.copyOf(this.students, newMaxNumOfStudents);
    }

    /**
     * Changes the department of a student.
     *
     * @param student the student to change the department of
     * @param newDepartment the new department for the student
     */
    public void changeDepartment(Student student, Department newDepartment){
        if(newDepartment != null && student != null){
            this.deleteStudent(student);
            newDepartment.addStudent(student);
            System.out.println("Кафедру успішно змінено!!!");
        }
    }

    /**
     * Adds a student to the department.
     *
     * @param student the student to add
     */
    public void addStudent(Student student) {
        if (numOfStudents < students.length) {
            students[numOfStudents] = student;
            numOfStudents++;
            System.out.println("Студента успішно додано!!!");
        } else {
            System.out.println("Схоже, що ви досягли ліміту студентів");
        }
    }

    /**
     * Deletes a student from the department.
     *
     * @param student the student to delete
     */
    public void deleteStudent(Student student) {
        for (int i = 0; i < numOfStudents; i++) {
            if (students[i] == student) {
                students[i] = null;
                numOfStudents--;
                sortStudents();
                System.out.println("Студента успішно видалено!!!");
            }
        }
    }

    public void sortStudents() {
        int lastNonNullIndex = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (i != lastNonNullIndex) {
                    students[lastNonNullIndex] = students[i];
                    students[i] = null;
                }
                lastNonNullIndex++;
            }
        }
    }
    /**
     * Adds a lecturer to the department.
     *
     * @param lecturer the student to add
     */
    public void addLecturer(Lecturer lecturer) {
        if (numOfLecturers < lecturers.length) {
            lecturers[numOfLecturers] = lecturer;
            numOfLecturers++;
            System.out.println("Викладача успішно додано!!!");
        } else {
            System.out.println("Схоже, що ви досягли ліміту студентів");
        }
    }

    /**
     * Deletes a lecturer from the department.
     *
     * @param lecturer the lecturer to delete
     */
    public void deleteLecturer(Lecturer lecturer) {
        for (int i = 0; i < numOfLecturers; i++) {
            if (lecturers[i] == lecturer) {
                lecturers[i] = null;
                numOfLecturers--;
                sortLecturers();
                System.out.println("Викладача успішно видалено!!!");
            }
        }
    }

    public void sortLecturers() {
        int lastNonNullIndex = 0;
        for (int i = 0; i < lecturers.length; i++) {
            if (lecturers[i] != null) {
                if (i != lastNonNullIndex) {
                    lecturers[lastNonNullIndex] = lecturers[i];
                    lecturers[i] = null;
                }
                lastNonNullIndex++;
            }
        }
    }
    /**
     * Changes the department of a lecturer.
     *
     * @param lecturer the student to change the department of
     * @param newDepartment the new department for the lecturer
     */
    public void changeDepartment(Lecturer lecturer, Department newDepartment){
        if(newDepartment != null && lecturer != null){
            this.deleteLecturer(lecturer);
            newDepartment.addLecturer(lecturer);
            System.out.println("Кафедру успішно змінено!!!");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static final char[] alphabet = {
            'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е', 'Є', 'Ж', 'З', 'И', 'І', 'Ї', 'Й', 'К', 'Л', 'М', 'Н',
            'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ю', 'Я'
    };
}
