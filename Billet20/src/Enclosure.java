public class Enclosure {
    private Animal animal;
    private boolean clear;

    public Enclosure(Animal animal, boolean clear) {
        this.animal = animal;
        this.clear = clear;
    }

    public void showAnimalInEnclosure() {
        System.out.println("В вольєрі знаходиться: ");
        animal.showBehavior();
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public boolean isClear() {
        return clear;
    }

    public void setClear(boolean clear) {
        this.clear = clear;
    }

    @Override
    public String toString() {
        return "Вольєр з твариною: " + animal + ", стан чистоти: " + clear;
    }
}
