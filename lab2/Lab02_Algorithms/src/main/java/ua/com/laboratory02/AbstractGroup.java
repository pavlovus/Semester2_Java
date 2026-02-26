package ua.com.laboratory02;

import java.util.ArrayList;
import java.util.List;

public class AbstractGroup implements Group{

    private String name;
    private List<Group> contents;

    public AbstractGroup(String name) {
        this.name = name;
        this.contents = new ArrayList<>();
    }

    public void addGroup(Group group) {
        contents.add(group);
    }

    public void removeGroup(Group group) {
        for (int i = 0; i <  contents.size(); i++)
            if (contents.get(i) == group) contents.remove(i);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "AbstractGroup{" +
                "name='" + name + '\'' +
                ", contents=" + contents +
                '}';
    }
}
