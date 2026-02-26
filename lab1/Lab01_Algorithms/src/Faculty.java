import utils.DataInput;

import java.io.IOException;
import java.util.Arrays;

public class Faculty {

    private String name;
    public Department[] departments;
    public int numOfDepartments;

    public Faculty(String name, int maxNumOfDepartments) {
        this.name = name;
        departments = new Department[maxNumOfDepartments];
        this.numOfDepartments = 0;
    }

    /**
     * Edits the faculty based on user input.
     */
    public void editFaculty() {
        int choice = DataInput.getInt("Введіть 1 - змінити назву факультету, 2 - змінити максимальну к-сть кафедр");
        while (choice < 1 || choice > 2) {
            choice = DataInput.getInt("Ви маєте ввести число ВІД 1 ДО 2: ");
        }
        if (choice == 1) {
            String newName = DataInput.getString("Введіть нову назву факультету: ");
            this.setName(newName);
        } else {
            int newMaxNumOfDepartments = DataInput.getInt("Введіть нову максимальну к-сть кафедр: ");
            while (newMaxNumOfDepartments < 1){
                newMaxNumOfDepartments = DataInput.getInt("Введіть ДОДАТНЄ число: ");
            }
            this.editMaxNumOfDepartments(newMaxNumOfDepartments);
            if (numOfDepartments > newMaxNumOfDepartments) {
                numOfDepartments = newMaxNumOfDepartments;
            }
        }
    }

    /**
     * Edits the maximum number of departments.
     *
     * @param newMaxNumOfLecturers the new maximum number of departments
     */
    private void editMaxNumOfDepartments(int newMaxNumOfLecturers) {
        this.departments = Arrays.copyOf(this.departments, newMaxNumOfLecturers);
    }

    /**
     * Adds a department to the faculty.
     *
     * @param department the department to add
     */
    public void addDepartment(Department department) {
        if (numOfDepartments < departments.length) {
            departments[numOfDepartments] = department;
            numOfDepartments++;
        }
    }

    /**
     * Deletes a department from the faculty.
     *
     * @param department the department to delete
     */
    public void deleteDepartment(Department department) {
        for (int i = 0; i < numOfDepartments; i++) {
            if (departments[i] == department) {
                departments[i] = null;
                numOfDepartments--;
                sortDepartments();
            }
        }
    }

    public void sortDepartments() {
        int lastNonNullIndex = 0;
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] != null) {
                if (i != lastNonNullIndex) {
                    departments[lastNonNullIndex] = departments[i];
                    departments[i] = null;
                }
                lastNonNullIndex++;
            }
        }
    }
    /**
     * Gets the amount of lecturers in the faculty.
     *
     * @return the number of lecturers in the faculty
     */
    private int getAmountOfLecturers() {
        int result = 0;
        for (int j = 0; j < this.numOfDepartments; j++) {
            if (this.departments[j] == null) continue;
            Department department = this.departments[j];
            for (int k = 0; k < department.numOfLecturers; k++) {
                if (department.lecturers[k] != null) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * Gets all lecturers in the faculty.
     *
     * @return an array of all lecturers in the faculty
     */
    private Lecturer[] getAllLecturers() {
        int lecs = getAmountOfLecturers();
        if (lecs == 0) return new Lecturer[0];

        Lecturer[] allLecs = new Lecturer[lecs];
        int count = 0;
        for (int j = 0; j < this.numOfDepartments; j++) {
            if (this.departments[j] == null) continue;
            Department department = this.departments[j];

            for (int k = 0; k < department.numOfLecturers; k++) {
                if (department.lecturers[k] != null) {
                    allLecs[count++] = department.lecturers[k];
                }
            }
        }
        return allLecs;
    }

    /**
     * Gets the amount of students in the faculty.
     *
     * @return the number of students in the faculty
     */
    private int getAmountOfStudents() {
        int result = 0;
        for (int j = 0; j < this.numOfDepartments; j++) {
            if (this.departments[j] == null) continue;
            Department department = this.departments[j];
            for (int k = 0; k < department.numOfStudents; k++) {
                if (department.students[k] != null) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * Gets all students in the faculty.
     *
     * @return an array of all students in the faculty
     */
    private Student[] getAllStudents() {
        int studentCount = getAmountOfStudents();
        if (studentCount == 0) return new Student[0];

        Student[] allStudents = new Student[studentCount];
        int count = 0;
        for (int j = 0; j < this.numOfDepartments; j++) {
            if (this.departments[j] == null) continue;
            Department department = this.departments[j];

            for (int k = 0; k < department.numOfStudents; k++) {
                if (department.students[k] != null) {
                    allStudents[count++] = department.students[k];
                }
            }
        }
        return allStudents;
    }

    /**
     * Gets all students in the faculty sorted
     *
     * @return an array of all students in the faculty sorted in alphabetical order
     */
    public Student[] getSortedStudents() {
        Student[] res = getAllStudents();
        for (int i = 1; i < res.length; i++) {
            if (res[i] == null) return res;
            Student cur = res[i];
            int j = i - 1;
            while (j >= 0 && Department.isFirstHigherThanTheSecond(cur.getFullName(), res[j].getFullName())) {
                res[j+1] = res[j];
                j--;
            }
            res[j+1] = cur;
        }
        return res;
    }

    public boolean findOverlap(String str) {
        for (int i = 0; i < numOfDepartments; i++) {
            if (departments[i] == null) break;
            else if (departments[i].getName().equalsIgnoreCase(str)) return true;
        }
        return false;
    }

    /**
     * Gets all lecturers in the faculty sorted
     *
     * @return an array of all lecturers in the faculty sorted in alphabetical order
     */
    public Lecturer[] getSortedLecturers() {
        Lecturer[] res = getAllLecturers();
        for (int i = 1; i < res.length; i++) {
            if (res[i] == null) return res;
            Lecturer cur = res[i];
            int j = i - 1;
            while (j >= 0 && Department.isFirstHigherThanTheSecond(cur.getFullName(), res[j].getFullName())) {
                res[j+1] = res[j];
                j--;
            }
            res[j+1] = cur;
        }
        return res;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
