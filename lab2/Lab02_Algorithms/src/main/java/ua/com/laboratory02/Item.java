package ua.com.laboratory02;

import java.io.Serializable;

public class Item implements Serializable {

    private String name;
    private String decsr;
    private String manufacturer;
    private int price;
    private int count;

    /**
     * Constructs a new Item with the specified properties.
     *
     * @param name the name of the item
     * @param decsr the description of the item
     * @param manufacturer the manufacturer of the item
     * @param price the price of the item (must be non-negative)
     * @param count the quantity of the item (must be non-negative)
     * @throws IllegalPriceException if the price is negative
     * @throws IllegalCountException if the count is negative
     */
    public Item(String name, String decsr, String manufacturer, int price, int count)
            throws IllegalPriceException, IllegalCountException {
        if (price < 0) throw new IllegalPriceException();
        if (count < 0) throw new IllegalCountException();
        this.name = name;
        this.decsr = decsr;
        this.manufacturer = manufacturer;
        this.price = price;
        this.count = count;
    }

    /**
     * Gets the name of the item.
     *
     * @return the name of the item
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the item.
     *
     * @param name the new name of the item
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the price of the item.
     *
     * @return the price of the item
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the item.
     *
     * @param price the new price of the item (must be non-negative)
     * @throws IllegalPriceException if the price is negative
     */
    public void setPrice(int price) throws IllegalPriceException {
        if (price < 0) throw new IllegalPriceException();
        this.price = price;
    }

    /**
     * Gets the manufacturer of the item.
     *
     * @return the manufacturer of the item
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets the manufacturer of the item.
     *
     * @param manufacturer the new manufacturer of the item
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Gets the description of the item.
     *
     * @return the description of the item
     */
    public String getDecsr() {
        return decsr;
    }

    /**
     * Gets the count (quantity) of the item.
     *
     * @return the count of the item
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets the description of the item.
     *
     * @param decsr the new description of the item
     */
    public void setDecsr(String decsr) {
        this.decsr = decsr;
    }

    /**
     * Sets the count (quantity) of the item.
     *
     * @param count the new count of the item (must be non-negative)
     * @throws IllegalCountException if the count is negative
     */
    public void setCount(int count) throws IllegalCountException {
        if (count < 0) throw new IllegalCountException();
        this.count = count;
    }

    /**
     * Calculates the total value of the item (price multiplied by count).
     *
     * @return the total value of the item
     */
    public int getSum(){
        return getPrice()*getCount();
    }

    /**
     * Returns a string representation of the item showing manufacturer, price, and count.
     *
     * @return a string representation of the item
     */
    public String toString() {
        return "Виробник - " + manufacturer + ", ціна - " + price + ", к-сть - " + count;
    }
}

