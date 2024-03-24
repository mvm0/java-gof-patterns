package org.example.StructuralPatterns.Flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Item {
    private ItemType type;
    private String value1;
    private String value2;

    Item(ItemType type, String value1, String value2) {
        this.type = type;
        this.value1 = value1;
        this.value2 = value2;
    }
}

class ItemType {
    private String typeName;
    private String typeValue;

    ItemType(String name, String value) {
        this.typeName = name;
        this.typeValue = value;
    }
}

class ItemTypeFactory { // To reduce memory usage
    private static HashMap<String, ItemType> types = new HashMap<>();

    public static ItemType getTreeType(String name, String value) {
        ItemType tmp = types.get(name);
        if (tmp == null) {
            tmp = new ItemType(name, value);
            types.put(name, tmp);
        }
        return tmp;
    }
}

public class Main {
    public static void main(String[] args) {
        ItemType type1 = ItemTypeFactory.getTreeType("Type1", "1");
        ItemType type2 = ItemTypeFactory.getTreeType("Type2", "2");

        List<Item> items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            items.add(new Item(type1, String.valueOf(i), String.valueOf(i)));
        }
        for (int i = 0; i < 100; i++) {
            items.add(new Item(type2, String.valueOf(i), String.valueOf(i)));
        }
    }
}
