import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    static abstract class Fish {
        String name;

        Fish(String name) {
            this.name = name;
        }

        abstract void act();
    }

    static class Goldfish extends Fish {
        Goldfish(String name) {
            super(name);
        }

        @Override
        void act() {
            System.out.println(name + " плаває і блимає плавниками.");
        }
    }

    static class Guppy extends Fish {
        Guppy(String name) {
            super(name);
        }

        @Override
        void act() {
            System.out.println(name + " грається з іншими рибками.");
        }
    }

    private List<Fish> fishes = new ArrayList<>();
    private double temperature;

    public Aquarium(double temperature) {
        this.temperature = temperature;
    }

    public void addFish(Fish fish) {
        fishes.add(fish);
    }

    public void feedFishes() {
        System.out.println("Годування риб:");
        for (Fish fish : fishes) {
            fish.act();
        }
    }

    public void cleanAquarium() {
        System.out.println("Акваріум очищено.");
    }

    public void regulateTemperature() {
        System.out.println("Температура підтримується на рівні: " + temperature + "°C.");
    }

    public static void main(String[] args) {
        Aquarium aquarium = new Aquarium(24.0);

        Fish fish1 = new Goldfish("Золота рибка");
        Fish fish2 = new Guppy("Гуппі");

        aquarium.addFish(fish1);
        aquarium.addFish(fish2);

        aquarium.regulateTemperature();
        aquarium.feedFishes();
        aquarium.cleanAquarium();
    }
}


