package ua.com.laboratory02;

import java.util.ArrayList;

public class Store<Group> extends ArrayList<ItemGroup> {
    /**
     * Retrieves an item by its name (case-insensitive) from all item groups.
     *
     * @param name the name of the item to retrieve
     * @return the Item with the specified name, or null if no such item exists
     */
    public Item getItem(String name) {
        for (ItemGroup group : this) {
            for (Item item : group.getItems()) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return item;
                }
            }
        }
        return null;
    }

    /**
     * Adds an item to a specific group by the group's name.
     * Ensures that item names remain unique across all groups (case-insensitive).
     *
     * @param grName the name of the group to which the item will be added
     * @param item the Item to be added to the specified group
     * @throws ItemUniquenessException if an item with the same name exists in any group
     */
    public void addItemToGroup(String grName, Item item) throws ItemUniquenessException {
        for (ItemGroup group : this) {
            for (Item item1 : group.getItems()) {
                if (item.getName().equalsIgnoreCase(item1.getName())) {
                    throw new ItemUniquenessException();
                }
            }
        }

        for (ItemGroup group : this) {
            if (group.getName().equalsIgnoreCase(grName)) {
                group.addItem(item);
            }
        }
    }
}
