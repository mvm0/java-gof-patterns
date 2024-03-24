package org.example.CreationalPatterns.Prototype;

abstract class Item {
    protected String value1;
    protected String value2;

    Item() {
    }

    Item(Item target) {
        if (target != null) {
            this.value1 = target.value1;
            this.value2 = target.value2;
        }
    }

    public abstract Item clone();

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Item)) return false;
        Item item2 = (Item) object2;
        return item2.value1 == value1 && item2.value2 == value2;
    }
}

class Item1 extends Item {
    private String value3;

    Item1() {
    }

    Item1(Item1 target) {
        super(target);
        this.value3 = target.value3;
    }

    @Override
    public Item clone() {
        return new Item1(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Item1) || !super.equals(object2)) return false;
        Item1 item2 = (Item1) object2;
        return item2.value3 == value3;
    }
}

class Item2 extends Item {
    private String value4;

    Item2() {
    }

    Item2(Item2 target) {
        super(target);
        this.value4 = target.value4;
    }

    @Override
    public Item clone() {
        return new Item2(this);
    }

    @Override
    public boolean equals(Object object2) {
        if (!(object2 instanceof Item2) || !super.equals(object2)) return false;
        Item2 item2 = (Item2) object2;
        return item2.value4 == value4;
    }
}

public class Main {
    public static void main(String[] args) {
        Item item1_1 = new Item1();
        Item item1_2 = item1_1.clone();
        System.out.println("item1_1 == item1_2: " + (item1_1 == item1_2));
        System.out.println("equals: " + (item1_1.equals(item1_2)));
        Item item2_1 = new Item2();
        Item item2_2 = item2_1.clone();
        System.out.println("item1_1 == item1_2: " + (item1_1 == item1_2));
        System.out.println("equals: " + (item1_1.equals(item1_2)));
    }
}
