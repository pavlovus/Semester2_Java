package ua.com.laboratory02;

import java.util.ArrayList;
import java.util.List;

public class ItemGroup implements Group {

    private final List<Item> items;

    private String name;
    private String description;

    /**
     * Constructs a new ItemGroup with the specified name and description.
     * Initializes an empty list of items.
     *
     * @param name the name of the item group
     * @param description the description of the item group
     */
    public ItemGroup(String name, String description) {
        this.name = name;
        this.description = description;
        items = new ArrayList<>();
    }

    /**
     * Adds an item to the group if no item with the same name (case-insensitive) exists.
     *
     * @param item the item to be added to the group
     * @throws ItemUniquenessException if an item with the same name already exists in the group
     */
    public void addItem(Item item) throws ItemUniquenessException {
        for (Item it : items)
            if (it.getName().equalsIgnoreCase(item.getName()))
                throw new ItemUniquenessException();
        items.add(item);
    }

    /**
     * Removes the specified item from the group.
     * The comparison is done by reference (identity comparison).
     *
     * @param item the item to be removed from the group
     */
    public void removeItem(Item item) {
        for (int i = 0; i < items.size(); i++)
            if (item == items.get(i)) {
                items.remove(i);
                break;
            }
    }

    /**
     * Returns a string representation of the item group including its items, name, and description.
     *
     * @return a string representation of the item group
     */
    @Override
    public String toString() {
        return "ItemGroup{" +
                "items=" + items +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    /**
     * Gets the list of items in this group.
     *
     * @return the list of items in this group
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Gets the name of this item group.
     *
     * @return the name of the item group
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the description of this item group.
     *
     * @return the description of the item group
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the name of this item group.
     *
     * @param name the new name for the item group
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the description of this item group.
     *
     * @param description the new description for the item group
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
