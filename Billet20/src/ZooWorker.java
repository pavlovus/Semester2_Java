public class ZooWorker {
    private String name;

    public ZooWorker(String name) {
        this.name = name;
    }

    public void feedAnimal(Animal animal, int amountOfFood) {
        System.out.println(getName() + " годує " + animal.getName());
        animal.beFed(amountOfFood);
    }

    public void clearEnclosure(Enclosure enclosure) {
        if(!enclosure.isClear())
            enclosure.setClear(true);
    }

    public String getName() {
        return name;
    }
}
