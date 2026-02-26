abstract class Fish {
    private String name;

    public Fish(String name) {
        this.name = name;
    }

    public abstract void interactWithNeighbor(Fish neighbor, River river);

    public void showInfo() {
        System.out.println("Fish: " + getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
