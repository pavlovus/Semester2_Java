class Chimpanzee extends Monkeys {
    public boolean usesTools;
    public int totalAmountOfChimpanzee;
    public Chimpanzee(String name, int age, boolean isIntelligent, String favoriteFood, boolean usesTools) {
        super(name, age, isIntelligent, favoriteFood);
        this.usesTools = usesTools;
    }
    public Chimpanzee(String name) {
        super(name);
        this.usesTools = true;
    }
    public Chimpanzee() {
        super();
        this.usesTools = true;
    }
    // Гетери
    public boolean getUsesTools() {
        return usesTools;
    }
    public int getTotalAmountOfChimpanzee() {
        return totalAmountOfChimpanzee;
    }
    // Сетери
    public void setUsesTools(boolean usesTools) {
        this.usesTools = usesTools;
    }
    public void voice(){
        System.out.println("Ooh, ooh, ooh, ooh");
    }
    //toString
    public String toString() {
        return "Це шимпанзе. " + super.toString() +
                (usesTools ? " Вона вміє користуватися інструментами." : " Вона не користується інструментами.");
    }
}
