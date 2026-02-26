public class WorkersOfZoo extends People{
    public String workPosition;
    public int workHours;
    public static int totalAmountOfWorkers;
    //Конструктори
    /**
     * Default constructor.
     */
    public WorkersOfZoo(){
        super();
    }
    /**
     * Constructor with work position.
     * @param workPosition the work position of the worker
     */
    public WorkersOfZoo(String workPosition) {
        super();
        this.workPosition = workPosition;
    }
    /**
     * Constructor with name, age, and work position.
     * @param name the name of the worker
     * @param age the age of the worker
     * @param workPosition the work position of the worker
     */
    public WorkersOfZoo(String name, int age, String workPosition) {
        super(age, name);
        this.workPosition = workPosition;
    }
    /**
     * Constructor with age and work position.
     * @param age the age of the worker
     * @param workPosition the work position of the worker
     */
    public WorkersOfZoo(int age, String workPosition) {
        super(age);
        this.workPosition = name;
    }
    /**
     * Constructor with name and work position.
     * @param name the name of the worker
     * @param workPosition the work position of the worker
     */
    public WorkersOfZoo(String name, String workPosition) {
        super(name);
        this.workPosition = workPosition;
    }
    //Гетери
    /**
     * Gets the work position of the worker.
     * @return the work position
     */
    public String getWorkPosition() {
        return workPosition;
    }
    /**
     * Gets the total number of workers.
     * @return the total amount of workers
     */
    public int getWorkHours() {
        return workHours;
    }
    /**
     * Gets the total number of workers.
     * @return the total amount of workers
     */
    public int getTotalAmountOfWorkers() {
        return totalAmountOfWorkers;
    }
    //Сетери
    /**
     * Sets the work position of the worker.
     * @param workPosition the work position to be set
     */
    public void setWorkPosition(String workPosition) {
        this.workPosition = workPosition;
    }
    /**
     * Sets the work hours of the worker.
     * @param workHours the number of work hours to be set
     */
    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }
    //Методи для годування тварин
    /**
     * Feeds a lion, triggering its voice and increasing work hours.
     * @param lion the lion to be fed
     */
    public void feedLion(Lions lion){
        lion.voice();
        workHours++;
    }
    /**
     * Feeds a tiger, triggering its voice and increasing work hours.
     * @param tiger the tiger to be fed
     */
    public void feedTiger(Tigers tiger){
        tiger.voice();
        workHours++;
    }
    /**
     * Feeds a chimpanzee, triggering its voice and increasing work hours.
     * @param chimpanzee the chimpanzee to be fed
     */
    public void feedChimpanzee(Chimpanzee chimpanzee){
        chimpanzee.voice();
        workHours++;
    }
    /**
     * Feeds a gorilla, triggering its voice and increasing work hours.
     * @param gorilla the gorilla to be fed
     */
    public void feedGorilla(Gorillas gorilla){
        gorilla.voice();
        workHours++;
    }
    //Попередити відвідувачів
    /**
     * Warns visitors about zoo regulations.
     */
    public void warnVisitors(){
        System.out.println("В нашому зоопарку відвідувачам заборонено годувати тварин!");
    }
    // Привітати відвідувачів в зоопарку
    /**
     * Welcomes a visitor to the zoo.
     * @param visitor the visitor to welcome
     */
    public void welcomeVisitor(Visitors visitor){
        System.out.println("Вітаю " + visitor.name +"! Радий бачити вас в нашому зоопарку");
    }
    //Попрощатись з відвідувачем зоопарку
    /**
     * Says goodbye to a visitor.
     * @param visitor the visitor to say goodbye to
     */
    public void sayGoodbye(Visitors visitor){
        System.out.println("Бувайте " + visitor.name + "! Надіюсь вас знову побачити в нашому зоопарку!");
    }
    //toString
    /**
     * Returns a string representation of the worker.
     * @return a string containing worker details
     */
    public String toString(){
        return "Вітаю! я " + name + "і мені " + age + "років, я працюю як" + workPosition;
    }
}
