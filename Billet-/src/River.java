import java.util.ArrayList;

public class River {
    private String riverName;
    private ArrayList<Fish> fishes;
    private int happiness;
    public River(String riverName) {
        this.riverName = riverName;
        this.fishes = new ArrayList<>();
        this.happiness = 100;
    }

    public void addFish(Fish fish){
        if (fish instanceof PredatorFish){
            this.happiness--;
        }
        fishes.add(fish);
    }

    public void removeFish(Fish fish){
        fishes.remove(fish);
    }

    public void simulateLife() {
        for (int i = 0; i < fishes.size()-1; i++) {
            fishes.get(i).interactWithNeighbor(fishes.get(i+1), this);
        }
    }

    public void showFishes() {
        for(Fish fish : fishes){
            fish.showInfo();
        }
    }
}
