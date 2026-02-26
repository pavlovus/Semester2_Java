class Monkeys extends Animals {
    public boolean isIntelligent;
    public String favoriteFood;
    public int totalAmountsOfMonkeys;
    // Конструктори
    public Monkeys(String name, int age, boolean isIntelligent, String favoriteFood) {
        super(name, age);
        this.isIntelligent = isIntelligent;
        this.favoriteFood = favoriteFood;
    }
    public Monkeys(String name) {
        super(name);
        this.isIntelligent = true;
        this.favoriteFood = "банани";
    }
    public Monkeys() {
        super();
        this.isIntelligent = true;
        this.favoriteFood = "фрукти";
    }
    // Гетери
    public boolean getIsIntelligent() {
        return isIntelligent;
    }
    public String getFavoriteFood() {
        return favoriteFood;
    }
    public int getTotalAmountsOfMonkeys() {
        return totalAmountsOfMonkeys;
    }
    // Сетери
    public void setIsIntelligent(boolean isIntelligent) {
        this.isIntelligent = isIntelligent;
    }
    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }
    // toString
    @Override
    public String toString() {
        return super.toString() +
                (isIntelligent ? " Вона дуже розумна." : " Вона не дуже розумна.") +
                " Улюблена їжа: " + favoriteFood + ".";
    }
}
