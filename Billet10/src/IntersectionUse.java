public class IntersectionUse {
    public static void main(String[] args) {
        Intersection intersection = new Intersection("Перехрестя на вулиці Степана Бандери");
        Bicycle b = new Bicycle("Ровер");
        Car c = new Car("Копєйка");

        intersection.handleCrossing(b);
        intersection.handleCrossing(c);
    }
}
