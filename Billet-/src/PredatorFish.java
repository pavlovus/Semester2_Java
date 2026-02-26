public class PredatorFish extends Fish {
    public PredatorFish(String name) {
        super(name);
    }

    @Override
    public void interactWithNeighbor(Fish neighbor, River river) {
        if (neighbor instanceof PeacefulFish) {
            if(Math.random() < 0.5){
                System.out.println("Peaceful Fish " +neighbor.getName() + "was attacked");
                river.removeFish(neighbor);
            }
        }
    }
}
