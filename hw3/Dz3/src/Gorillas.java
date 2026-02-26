class Gorillas extends Monkeys {
    public double weight;
    public double totalAmountOfGorillas;
    public Gorillas(String name, int age, boolean isIntelligent, String favoriteFood, double weight) {
        super(name, age, isIntelligent, favoriteFood);
        this.weight = weight;
    }
    public Gorillas(String name) {
        super(name);
        this.weight = 160.0;
    }
    public Gorillas() {
        super();
        this.weight = 160.0;
    }
    // Гетери
    public double getWeight() {
        return weight;
    }
    public double getTotalAmountOfGorillas() {
        return totalAmountOfGorillas;
    }
    // Сетери
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void voice(){
        System.out.println("Ghoo, hgoo, hgoo");
    }
    //toString
    public String toString() {
        return "Це горила. " + super.toString() +
                " Вага: " + weight + " кг.";
    }
}

