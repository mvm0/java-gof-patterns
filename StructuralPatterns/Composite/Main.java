package org.example.StructuralPatterns.Composite;

import java.util.ArrayList;
import java.util.List;

interface Thing {
    void print();
}

class Item implements Thing {
    private String name;
    private String itemValue;

    Item(String name, String value) {
        this.name = name;
        this.itemValue = value;
    }

    public String getValue() {
        return itemValue;
    }

    @Override
    public void print() {
        System.out.print("Item " + name + " | Value: " + itemValue);
    }
}

class Box implements Thing {
    private String title;
    private List<Thing> itemsInBox = new ArrayList<>();

    Box(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println("Box " + title);
        System.out.println("Items in box " + title + ":");
        for (Thing t : itemsInBox) {
            System.out.print("   ");
            t.print();
        }

    }

    public void addThingInBox(Thing thing) {
        this.itemsInBox.add(thing);
    }
}

public class Main {
    public static void main(String[] args) {
        Box B1T = new Box("Box1");
        Thing I1T = new Item("Item1", "1");
        Thing I2T = new Item("Item2", "2");

        B1T.addThingInBox(I1T);
        B1T.addThingInBox(I2T);

        Box B2T = new Box("Box2");
        B1T.addThingInBox(B2T);
        B2T.addThingInBox(new Item("Item3", "3"));
        B2T.addThingInBox(new Item("Item4", "4"));

        B1T.print();
    }
}
