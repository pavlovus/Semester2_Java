public class StudentGroupUse {
    public static void main(String[] args) {
        StudentGroup group = new StudentGroup();

        Student st1 = new Student("Павло", 61);
        Student st2 = new Student("Віталій", 62);
        Student st3 = new Student("Андрій", 63);
        Student st4 = new Student("Родіон", 64);

        group.addStudent(st1);
        group.addStudent(st2);
        group.addStudent(st3);
        group.addStudent(st4);

        group.printStudents();
        System.out.println(group.getAverageScore());
        System.out.println(group.getMaxScore());
        System.out.println(group.getMinScore());

        group.removeStudent(st1);
        System.out.println("\n");
        group.printStudents();
        System.out.println(group.getAverageScore());
        System.out.println(group.getMaxScore());
        System.out.println(group.getMinScore());
    }
}
