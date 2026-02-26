abstract class Animal {
    private String name;
    private int amountOfFoodReceived;

    public Animal(String name) {
        this.name = name;
        this.amountOfFoodReceived = 0;
    }

    public abstract void showBehavior();

    public void beFed(int amountOfFood) {
        this.amountOfFoodReceived += amountOfFood;
        System.out.println(getName() + " отримав " + amountOfFood + " одиниць їжі!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Тварина - " + name + ", к-сть отриманої їжі - " + amountOfFoodReceived;
    }
}
