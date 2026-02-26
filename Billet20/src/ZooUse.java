public class ZooUse {
    public static void main(String[] args) {
        Animal lion = new Lion("Лев");
        Animal elephant = new Elephant("Слон");

        Enclosure lionEnclosure = new Enclosure(lion, true);
        Enclosure elephantEnclosure = new Enclosure(elephant, false);

        ZooWorker worker = new ZooWorker("Іван");

        lionEnclosure.showAnimalInEnclosure();
        elephantEnclosure.showAnimalInEnclosure();

        worker.feedAnimal(lion, 10);
        worker.feedAnimal(elephant, 15);

        worker.clearEnclosure(lionEnclosure);
        worker.clearEnclosure(elephantEnclosure);
        System.out.println(lionEnclosure);
        System.out.println(elephantEnclosure);
    }
}
