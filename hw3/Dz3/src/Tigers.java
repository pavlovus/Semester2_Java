class Tigers extends Cats {
    public int stripeCount; // Кількість смуг
    public int totalAmountOfTigers;
    /**
     * Constructor with name, age, fur color, and stripe count.
     * @param name the name of the tiger
     * @param age the age of the tiger
     * @param furColor the fur color of the tiger
     * @param stripeCount the number of stripes on the tiger
     */
    public Tigers(String name, int age, String furColor, int stripeCount) {
        super(name, age, furColor);
        this.stripeCount = stripeCount;
    }
    /**
     * Constructor with name only. Default stripe count is set to 90.
     * @param name the name of the tiger
     */
    public Tigers(String name) {
        super(name);
        this.stripeCount = 90; // Середня кількість смуг
    }
    /**
     * Default constructor. Default stripe count is set to 100.
     */
    public Tigers() {
        super();
        this.stripeCount = 100;
    }
    // Гетери
    /**
     * Gets the number of stripes on the tiger.
     * @return the number of stripes
     */
    public int getStripeCount() {
        return stripeCount;
    }
    /**
     * Gets the total number of tigers.
     * @return the total amount of tigers
     */
    public int getTotalAmountOfTigers() {
        return totalAmountOfTigers;
    }
    // Сетери
    /**
     * Sets the number of stripes on the tiger.
     * @param stripeCount the number of stripes to set
     */
    public void setStripeCount(int stripeCount) {
        this.stripeCount = stripeCount;
    }
    /**
     * The tiger makes a roaring sound.
     */
    public void voice(){
        System.out.println("Graaaaahrrr");
    }
    /**
     * Returns a string representation of the tiger.
     * @return a string containing tiger details including stripe count
     */
    public String toString() {
        return "Це тигр. " + super.toString() +
                " Кількість смуг: " + stripeCount + ".";
    }
}
