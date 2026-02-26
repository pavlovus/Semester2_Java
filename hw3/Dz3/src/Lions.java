class Lions extends Cats {
    public boolean hasMane; // Чи має лев гриву
    public int totalAmountOfLions;
    public Lions(String name, int age, String furColor, boolean hasMane) {
        super(name, age, furColor);
        this.hasMane = hasMane;
    }
    public Lions(String name) {
        super(name);
        this.hasMane = true;
    }
    public Lions() {
        super();
        this.hasMane = true;
    }
    // Гетери
    public boolean getHasMane() {
        return hasMane;
    }
    public int getTotalAmountOfLions() {
        return totalAmountOfLions;
    }
    // Сетери
    public void setHasMane(boolean hasMane) {
        this.hasMane = hasMane;
    }
    public void voice(){
        System.out.println("Raaaaaargh");
    }
    public String toString() {
        return "Це лев. " + super.toString() +
                (hasMane ? " У нього є грива." : " У нього немає гриви.");
    }
}

