public class PeacefulFish extends Fish {
    public PeacefulFish(String name) {
        super(name);
    }

    @Override
    public void interactWithNeighbor(Fish neighbor, River river) {
        if (neighbor instanceof PredatorFish) {
            if(Math.random() < 0.5){
                System.out.println("Peaceful Fish " + getName() + "was attacked");
                river.removeFish(this);
            }
        }
    }
}
