public class Car {
    private String color;
    private String name;
    private boolean clean;
    private boolean repaired;

    public Car(String color, String name, boolean clean, boolean repaired) {
        this.color = color;
        this.name = name;
        this.clean = clean;
        this.repaired = repaired;
    }

    public void repair(){
        if(!repaired){
            this.repaired = true;
        }
    }

    public void clean(){
        if(!clean){
            this.clean = true;
        }
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isClean() {
        return clean;
    }
    public void setClean(boolean clean) {
        this.clean = clean;
    }
    public boolean isRepaired() {
        return repaired;
    }
    public void setRepaired(boolean repaired) {
        this.repaired = repaired;
    }
    public String toString() {
        return "Машина, колір - " +  color + ", назва - " + name + ", чиста " + clean + ", справна - " + repaired;
    }
}
