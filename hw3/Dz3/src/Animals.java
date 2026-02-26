public class Animals {
    public String name;
    public int age;
    public static int totalAmountOfAnimals = 0;
    // Конструктори
    public Animals(String name, int age) {
        this.name = name;
        this.age = age;
        totalAmountOfAnimals++;
    }
    public Animals(String name) {
        this.name = name;
        this.age = 0; // Вік за замовчуванням
        totalAmountOfAnimals++;
    }
    public Animals(int age) {
        this.name = "Unknown";
        this.age = age;
        totalAmountOfAnimals++;
    }
    public Animals() {
        this.name = "Unknown";
        this.age = 0;
        totalAmountOfAnimals++;
    }
    // Гетери
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public int getTotalAmountOfAnimals() {
        return totalAmountOfAnimals;
    }
    // Сетери
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    // toString
    public String toString() {
        return "Це " + name + ", йому " + age + " років.";
    }
}
