public class RiverUse {
    public static void main(String[] args) {
        Fish fish1 = new PeacefulFish("Тріска");
        Fish fish2 = new PredatorFish("Щука");
        Fish fish3 = new PeacefulFish("Тунець");

        River river = new River("Шкло");
        river.addFish(fish1);
        river.addFish(fish2);
        river.addFish(fish3);

        river.simulateLife();

        river.showFishes();
    }
}
