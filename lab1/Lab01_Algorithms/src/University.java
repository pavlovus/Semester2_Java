import utils.DataInput;
import java.util.Arrays;

public class University {

    private String name;
    public Faculty[] faculties;
    public int numOfFaculties;

    /**
     * Constructs a University object.
     *
     * @param name the name of the university
     * @param maxNumOfFaculties the maximum number of faculties
     */
    public University(String name, int maxNumOfFaculties) {
        this.name = name;
        faculties = new Faculty[maxNumOfFaculties];
        numOfFaculties = 0;
    }

    /**
     * Edits the university based on user input.
     */
    public void editUniversity() {
        int choice = DataInput.getInt("Введіть 1 - змінити назву університету, 2 - змінити максимальну к-сть факультету");
        while (choice < 1 || choice > 2) {
            choice = DataInput.getInt("Ви маєте ввести число ВІД 1 ДО 2: ");
        }
        if (choice == 1) {
            String newName = DataInput.getString("Введіть нову назву факультету: ");
            this.setName(newName);
        } else {
            int newMaxNumOfLecturers = DataInput.getInt("Введіть нову максимальну к-сть факультетів: ");
            this.editMaxNumOfDepartments(newMaxNumOfLecturers);
        }
    }

    /**
     * Edits the maximum number of departments.
     *
     * @param newMaxNumOfLecturers the new maximum number of departments
     */
    private void editMaxNumOfDepartments(int newMaxNumOfLecturers) {
        this.faculties = Arrays.copyOf(this.faculties, newMaxNumOfLecturers);
    }

    /**
     * Finds lecturers by their full name.
     *
     * @param fullName the full name of the lecturer
     * @return an array of lecturers with the specified full name
     */
    public Lecturer[] findLecturersByName(String fullName) {
        int count = 0;
        // Count the number of lecturers with the specified full name
        for (int i = 0; i < numOfFaculties; i++) {
            Faculty faculty = faculties[i];
            for (int j = 0; j < faculty.numOfDepartments; j++) {
                Department department = faculty.departments[j];
                for (int k = 0; k < department.numOfLecturers; k++) {
                    if (department.lecturers[k].getFullName().equalsIgnoreCase(fullName)) {
                        count++;
                    }
                }
            }
        }
        // Create an array of the appropriate size
        Lecturer[] foundLecturers = new Lecturer[count];
        int index = 0;
        // Fill the array
        for (int i = 0; i < numOfFaculties; i++) {
            Faculty faculty = faculties[i];
            for (int j = 0; j < faculty.numOfDepartments; j++) {
                Department department = faculty.departments[j];
                for (int k = 0; k < department.numOfLecturers; k++) {
                    if (department.lecturers[k].getFullName().equalsIgnoreCase(fullName)) {
                        foundLecturers[index++] = department.lecturers[k];
                    }
                }
            }
        }

        return foundLecturers;
    }

    /**
     * Finds a certain lecturer by their full name.
     *
     * @param fullName the full name of the lecturer
     * @return the lecturer with the specified full name, or null if not found
     */
    public Lecturer findCertainLecturer(String fullName) {
        for (int i = 0; i < numOfFaculties; i++) {
            Faculty faculty = faculties[i];
            for (int j = 0; j < faculty.numOfDepartments; j++) {
                Department department = faculty.departments[j];
                for (int k = 0; k < department.numOfLecturers; k++) {
                    Lecturer lecturer = department.lecturers[k];
                    if (lecturer == null) break;
                    if (fullName.isEmpty() || lecturer.getFullName().equalsIgnoreCase(fullName)) {
                        return lecturer;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Finds the department of a lecturer by their full name.
     *
     * @param fullName the full name of the lecturer
     * @return the department of the lecturer with the specified full name, or null if not found
     */
    public Department findLecturerDepartment(String fullName) {
        for (int i = 0; i < numOfFaculties; i++) {
            Faculty faculty = faculties[i];
            for (int j = 0; j < faculty.numOfDepartments; j++) {
                Department department = faculty.departments[j];
                for (int k = 0; k < department.numOfLecturers; k++) {
                    Lecturer lecturer = department.lecturers[k];
                    if (lecturer == null) break;
                    if (fullName.isEmpty() || lecturer.getFullName().equalsIgnoreCase(fullName)) {
                        return department;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Finds students by their full name.
     *
     * @param fullName the full name of the student
     * @return an array of students with the specified full name
     */
    public Student[] findStudentsByName(String fullName) {
        int count = 0;
        // Count the number of students with the specified full name
        for (int i = 0; i < numOfFaculties; i++) {
            Faculty faculty = faculties[i];
            for (int j = 0; j < faculty.numOfDepartments; j++) {
                Department department = faculty.departments[j];
                for (int k = 0; k < department.numOfStudents && (department.students[k] != null); k++) {
                    if (department.students[k].getFullName().equalsIgnoreCase(fullName)) {
                        count++;
                    }
                }
            }
        }
        // Create an array of the appropriate size
        Student[] foundStudents = new Student[count];
        int index = 0;
        // Fill the array
        for (int i = 0; i < numOfFaculties; i++) {
            Faculty faculty = faculties[i];
            for (int j = 0; j < faculty.numOfDepartments; j++) {
                Department department = faculty.departments[j];
                for (int k = 0; k < department.numOfStudents && (department.students[k] != null); k++) {
                    if (department.students[k].getFullName().equalsIgnoreCase(fullName)) {
                        foundStudents[index++] = department.students[k];
                    }
                }
            }
        }

        return foundStudents;
    }

    /**
     * Finds students by their group number.
     *
     * @param group the group number of the students
     * @return an array of students in the specified group
     */
    public Student[] findStudentsByGroup(int group) {
        int count = 0;
        // Count the number of students in the group
        for (int i = 0; i < numOfFaculties; i++) {
            Faculty faculty = faculties[i];
            for (int j = 0; j < faculty.numOfDepartments; j++) {
                Department department = faculty.departments[j];
                for (int k = 0; k < department.numOfStudents && (department.students[k] != null); k++) {
                    if (department.students[k].getGroup() == group) {
                        count++;
                    }
                }
            }
        }
        // Create an array of the appropriate size
        Student[] foundStudents = new Student[count];
        int index = 0;
        // Fill the array
        for (int i = 0; i < numOfFaculties; i++) {
            Faculty faculty = faculties[i];
            for (int j = 0; j < faculty.numOfDepartments; j++) {
                Department department = faculty.departments[j];
                for (int k = 0; k < department.numOfStudents && (department.students[k] != null); k++) {
                    if (department.students[k].getGroup() == group) {
                        foundStudents[index++] = department.students[k];
                    }
                }
            }
        }

        return foundStudents;
    }

    /**
     * Finds students by their course number.
     *
     * @param course the course number
     * @return an array of students in the specified course
     */
    public Student[] findStudentsByCourse(int course) {
        int count = 0;
        // Count the number of students in the course
        for (int i = 0; i < numOfFaculties; i++) {
            Faculty faculty = faculties[i];
            for (int j = 0; j < faculty.numOfDepartments; j++) {
                Department department = faculty.departments[j];
                for (int k = 0; k < department.numOfStudents && (department.students[k] != null); k++) {
                    if (department.students[k].getCourse() == course) {
                        count++;
                    }
                }
            }
        }
        // Create an array of the appropriate size
        Student[] foundStudents = new Student[count];
        int index = 0;
        // Fill the array
        for (int i = 0; i < numOfFaculties; i++) {
            Faculty faculty = faculties[i];
            for (int j = 0; j < faculty.numOfDepartments; j++) {
                Department department = faculty.departments[j];
                for (int k = 0; k < department.numOfStudents && (department.students[k] != null); k++) {
                    if (department.students[k].getCourse() == course) {
                        foundStudents[index++] = department.students[k];
                    }
                }
            }
        }

        return foundStudents;
    }

    /**
     * Finds a specific student by their full name, group, and course.
     *
     * @param fullName the full name of the student
     * @param group the group number of the student
     * @param course the course number of the student
     * @return the student matching the criteria, or null if not found
     */
    public Student findCertainStudent(String fullName, int group, int course) {
        for (int i = 0; i < numOfFaculties; i++) {
            Faculty faculty = faculties[i];
            for (int j = 0; j < faculty.numOfDepartments; j++) {
                Department department = faculty.departments[j];
                for (int k = 0; k < department.numOfStudents; k++) {

                    Student student = department.students[k];
                    if (student == null) break;

                    boolean nameMatches = fullName.isEmpty() || student.getFullName().equalsIgnoreCase(fullName);
                    boolean groupMatches = (group == -1 || student.getGroup() == group);
                    boolean courseMatches = (course == -1 || student.getCourse() == course);

                    if (nameMatches && groupMatches && courseMatches) {
                        return student;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Finds the department of a specific student by their full name, group, and course.
     *
     * @param fullName the full name of the student
     * @param group the group number of the student
     * @param course the course number of the student
     * @return the department of the student matching the criteria, or null if not found
     */
    public Department findStudentDepartment(String fullName, int group, int course) {
        for (int i = 0; i < numOfFaculties; i++) {
            Faculty faculty = faculties[i];
            for (int j = 0; j < faculty.numOfDepartments; j++) {
                Department department = faculty.departments[j];
                for (int k = 0; k < department.numOfStudents; k++) {
                    Student student = department.students[k];
                    if (student == null) break;

                    boolean nameMatches = fullName.isEmpty() || student.getFullName().equalsIgnoreCase(fullName);
                    boolean groupMatches = (group == -1 || student.getGroup() == group);
                    boolean courseMatches = (course == -1 || student.getCourse() == course);

                    if (nameMatches && groupMatches && courseMatches) {
                        return department;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Prints all students sorted by their course number.
     */
    public void printAllStudentsSortedByCourse() {
        Student[] sortedStudents = allStudentsSortedByCourse();
        for (int i = 0; i < getAmountOfStudents(); i++) {
            System.out.println(sortedStudents[i]);
        }
    }

    /**
     * Sorts all students by their course number.
     *
     * @return an array of all students sorted by their course number
     */
    private Student[] allStudentsSortedByCourse() {
        Student[] allStudents = getAllStudents();
        return ascendingSelectionSort(allStudents);
    }

    /**
     * Performs an ascending selection sort on an array of students.
     *
     * @param arr the array of students to sort
     * @return the sorted array of students
     */
    private Student[] ascendingSelectionSort(Student[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] != null && arr[minIndex] != null && arr[j].getCourse() < arr[minIndex].getCourse()) {
                    minIndex = j;
                }
            }
            Student temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    /**
     * Gets all students in the university.
     *
     * @return an array of all students in the university
     */
    private Student[] getAllStudents() {
        int studentCount = getAmountOfStudents();
        if (studentCount == 0) {
            return new Student[0];
        }

        Student[] allStudents = new Student[studentCount];
        int count = 0;

        for (int i = 0; i < numOfFaculties; i++) {
            if (faculties[i] == null) continue;
            Faculty faculty = faculties[i];

            for (int j = 0; j < faculty.numOfDepartments; j++) {
                if (faculty.departments[j] == null) continue;
                Department department = faculty.departments[j];

                for (int k = 0; k < department.numOfStudents; k++) {
                    if (department.students[k] != null) {
                        allStudents[count++] = department.students[k];
                    }
                }
            }
        }
        return allStudents;
    }

    /**
     * Gets the total number of students in the university.
     *
     * @return the total number of students in the university
     */
    private int getAmountOfStudents() {
        int result = 0;
        for (int i = 0; i < numOfFaculties; i++) {
            if (faculties[i] == null) continue;
            Faculty faculty = faculties[i];
            for (int j = 0; j < faculty.numOfDepartments; j++) {
                if (faculty.departments[j] == null) continue;
                Department department = faculty.departments[j];
                for (int k = 0; k < department.numOfStudents; k++) {
                    if(department.students[k] != null) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    /**
     * Adds a faculty to the university.
     *
     * @param faculty the faculty to add
     */
    public void addFaculty(Faculty faculty) {
        if (numOfFaculties < faculties.length) {
            faculties[numOfFaculties] = faculty;
            numOfFaculties++;
        }
    }


    /**
     * Deletes a faculty from the university.
     *
     * @param faculty the faculty to delete
     */
    public void deleteFaculty(Faculty faculty) {
        for (int i = 0; i < numOfFaculties; i++) {
            if (faculties[i] == faculty) {
                faculties[i] = null;
                numOfFaculties--;
                sortFaculties();
            }
        }
    }

    public void sortFaculties() {
        int lastNonNullIndex = 0;

        for (int i = 0; i < faculties.length; i++) {
            if (faculties[i] != null) {
                if (i != lastNonNullIndex) {
                    faculties[lastNonNullIndex] = faculties[i];
                    faculties[i] = null;
                }
                lastNonNullIndex++;
            }
        }
    }

    public boolean findOverlap(String str) {
        for (int i = 0; i < numOfFaculties; i++) {
            if (faculties[i] == null) break;
            else if (faculties[i].getName().equalsIgnoreCase(str)) return true;
        }
        return false;
    }

    /**
     * Gets the name of the university.
     *
     * @return the name of the university
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the university.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

}
