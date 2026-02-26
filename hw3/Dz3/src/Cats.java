class Cats extends Animals{
    public String furColor;
    public static int totalAmountOfCats = 0;
    //Конструктори
    public Cats(String name, int age, String furColor) {
        super(name, age);
        this.furColor = furColor;
        totalAmountOfCats++;
    }
    public Cats(String name, String furColor) {
        super(name);
        this.furColor = furColor;
        totalAmountOfCats++;
    }
    public Cats(int age, String furColor) {
        super(age);
        this.furColor = furColor;
        totalAmountOfCats++;
    }
    public Cats(String name) {
        super(name);
        this.furColor = "Unknown";
        totalAmountOfCats++;
    }
    public Cats() {
        super();
        this.furColor = "Unknown";
        totalAmountOfCats++;
    }

    // Гетери та сетери
    public String getFurColor() {
        return furColor;
    }
    public int getTotalAmountOfCats() {
        return totalAmountOfCats;
    }
    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }
    // toString
    @Override
    public String toString() {
        return super.toString() + " Це кіт з " + furColor + " шерстю.";
    }
}
