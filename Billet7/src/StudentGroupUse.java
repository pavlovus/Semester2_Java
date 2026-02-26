public class StudentGroupUse {
    public static void main(String[] args) {
        StudentGroup sg = new StudentGroup();
        Student st1 = new Student("Павло", 91, 17);
        Student st2 = new Student("Віталій", 90, 17);
        Student st3 = new Student("Андрій", 99, 18);
        Student st4 = new Student("Родіон", 100, 19);
        sg.addStudent(st1);
        sg.addStudent(st2);
        sg.addStudent(st3);
        sg.addStudent(st4);

        sg.printStudents();
        sg.sortByGrade();
        sg.printStudents();
        sg.sortByAge();
        sg.printStudents();
        sg.removeStudent(st2);
        sg.printStudents();
    }
}
