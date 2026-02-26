public class People {
    public int age;
    public String name;
    public static int totalAmount = 0;
    //Конструктори
    /**
     * Constructor with age and name.
     * @param age the age of the person
     * @param name the name of the person
     */
    public People(int age, String name) {
        this.age = age;
        this.name = name;
        totalAmount++;
    }
    /**
     * Constructor with name only.
     * @param name the name of the person
     */
    public People(String name) {
        this.name = name;
        totalAmount++;
    }
    /**
     * Constructor with age only. Name is set to "Unknown" by default.
     * @param age the age of the person
     */
    public People(int age) {
        this.age = age;
        this.name = "Unknown";
        totalAmount++;
    }
    /**
     * Default constructor. Name is set to "Unknown" by default.
     */
    public People() {
        this.name = "Unknown";
        totalAmount++;
    }
    //Гетери
    /**
     * Gets the age of the person.
     * @return the age of the person
     */
    public int getAge() {
        return age;
    }
    /**
     * Gets the name of the person.
     * @return the name of the person
     */
    public String getName() {
        return name;
    }
    //Сетери
    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getTotalAmount() {
        return totalAmount;
    }
    //toString
    public String toString() {
        return "Вітаю! я " + name + "і мені " + age + "років";
    }
}
