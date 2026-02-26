public class Visitors extends People{
    public boolean left;
    public static int totalAmountOfVisitors = 0;
    //Конструктори
    /**
     * Constructor with age and name.
     * @param age the age of the visitor
     * @param name the name of the visitor
     */
    public Visitors(int age, String name) {
        super(age, name);
        this.left = false;
        totalAmountOfVisitors++;
    }
    /**
     * Constructor with age only.
     * @param age the age of the visitor
     */
    public Visitors(int age) {
        super(age);
        this.left = false;
        totalAmountOfVisitors++;
    }
    /**
     * Constructor with name only.
     * @param name the name of the visitor
     */
    public Visitors(String name) {
        super(name);
        this.left = false;
        totalAmountOfVisitors++;
    }
    /**
     * Default constructor.
     */
    public Visitors(){
        this.left = false;
        totalAmountOfVisitors++;
    }
    //Гетери
    /**
     * Checks if the visitor has left the zoo.
     * @return true if the visitor has left, false otherwise
     */
    public boolean getLeft() {
        return left;
    }
    /**
     * Gets the total number of visitors.
     * @return the total amount of visitors
     */
    public int getTotalAmountOfVisitors() {
        return totalAmountOfVisitors;
    }
    //Сетери
    /**
     * Sets whether the visitor has left the zoo.
     * @param left true if the visitor has left, false otherwise
     */
    public void setLeft(boolean left) {
        this.left = left;
    }
    //Дивитись на тварин
    /**
     * The visitor observes a lion.
     * @param lion the lion to be observed
     */
    public void seeLion(Lions lion){
        lion.voice();
    }
    /**
     * The visitor observes a tiger.
     * @param tiger the tiger to be observed
     */
    public void seeTiger(Tigers tiger){
        tiger.voice();
    }
    /**
     * The visitor observes a chimpanzee.
     * @param chimpanzee the chimpanzee to be observed
     */
    public void seeChimpanzee(Chimpanzee chimpanzee){
        chimpanzee.voice();
    }
    /**
     * The visitor observes a gorilla.
     * @param gorilla the gorilla to be observed
     */
    public void seeGorilla(Gorillas gorilla){
        gorilla.voice();
    }
    //Покинути зоопарк
    /**
     * The visitor leaves the zoo.
     */
    public void leaveZoo(){
        System.out.println("До побачення!!!");
        this.left = true;
    }
    //toString
    /**
     * Returns a string representation of the visitor.
     * @return a string containing visitor details and whether they have left the zoo
     */
    public String toString() {
        if (left) {
            return "Вітаю! я " + name + "і мені " + age + "років, і я вже покинув зоопарк";
        } else {
            return "Вітаю! я " + name + "і мені " + age + "років, і я зараз в зоопарку";
        }
    }
}
