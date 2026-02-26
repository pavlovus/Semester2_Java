import java.util.ArrayList;
import java.util.List;

class StudentParty {
    String name;

    public StudentParty(String name) {
        this.name = name;
    }

    public void danceWith(StudentParty partner) {
        System.out.println(name + " танцює з " + partner.name);
    }

    public void communicate(StudentParty partner) {
        System.out.println(name + " спілкується з " + partner.name);
    }

    public void consume(String item) {
        System.out.println(name + " вживає " + item);
    }

    public void relax() {
        System.out.println(name + " розслабляється на вечірці");
    }
}

class Boy extends StudentParty {
    public Boy(String name) {
        super(name);
    }

    public void joke() {
        System.out.println(name + " жартує");
    }
}

class Girl extends StudentParty {
    public Girl(String name) {
        super(name);
    }

    public void smile() {
        System.out.println(name + " посміхається");
    }
}

class Party {
    List<StudentParty> students = new ArrayList<>();

    public void addStudent(StudentParty s) {
        students.add(s);
    }

    public void startParty() {
        System.out.println("Вечірка починається!\n");

        for (StudentParty s : students) {
            s.relax();
        }

        System.out.println("\n[ Танці ]");
        for (int i = 0; i < students.size() - 1; i += 2) {
            StudentParty a = students.get(i);
            StudentParty b = students.get(i + 1);
            a.danceWith(b);
        }

        System.out.println("\n[ Спілкування ]");
        for (int i = 0; i < students.size() - 1; i++) {
            students.get(i).communicate(students.get(i + 1));
        }

        System.out.println("\n[ Вживання напоїв ]");
        for (StudentParty s : students) {
            s.consume("напій");
        }

        System.out.println("\n[ Індивідуальні дії ]");
        for (StudentParty s : students) {
            if (s instanceof Boy) {
                ((Boy) s).joke();
            } else if (s instanceof Girl) {
                ((Girl) s).smile();
            }
        }

        System.out.println("\nВечірка завершилась.");
    }
}

public class UniversityParty {
    public static void main(String[] args) {
        Party party = new Party();

        StudentParty s1 = new Boy("Олег");
        StudentParty s2 = new Girl("Марія");
        StudentParty s3 = new Boy("Андрій");
        StudentParty s4 = new Girl("Ірина");
        StudentParty s5 = new Boy("Сергій");

        party.addStudent(s1);
        party.addStudent(s2);
        party.addStudent(s3);
        party.addStudent(s4);
        party.addStudent(s5);

        party.startParty();
    }
}

