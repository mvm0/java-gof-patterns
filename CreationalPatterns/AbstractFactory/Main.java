package org.example.CreationalPatterns.AbstractFactory;

import java.util.Scanner;

abstract class Item1 {
    abstract void item1Action();
}

class Item1_1 extends Item1 {
    @Override
    void item1Action() {
    }
}

class Item1_2 extends Item1 {
    @Override
    void item1Action() {
    }
}

abstract class Item2 {
    abstract void item2Action();
}

class Item2_1 extends Item2 {
    @Override
    void item2Action() {
    }
}

class Item2_2 extends Item2 {
    @Override
    void item2Action() {
    }
}

abstract class AbstractFactory {
    public abstract Item1 createItem1();

    public abstract Item2 createItem2();
}

class ItemN_1Factory extends AbstractFactory {
    @Override
    public Item1 createItem1() {
        System.out.println("Creating Item1_1");
        return new Item1_1();
    }

    @Override
    public Item2 createItem2() {
        System.out.println("Creating Item2_1");
        return new Item2_1();
    }
}

class ItemN_2Factory extends AbstractFactory {
    @Override
    public Item1 createItem1() {
        System.out.println("Creating Item1_2");
        return new Item1_2();
    }

    @Override
    public Item2 createItem2() {
        System.out.println("Creating Item2_2");
        return new Item2_2();
    }
}

public class Main {
    public static void main(String[] args) {

        System.out.println("Choose style for Item: ");
        Scanner console = new Scanner(System.in);
        String factoryType = console.nextLine();
        AbstractFactory factory;

        if (factoryType.equals("1"))
            factory = new ItemN_1Factory();
        else if (factoryType.equals("2"))
            factory = new ItemN_2Factory();
        else
            throw new RuntimeException("Unknown type!");

        Item1 item1 = factory.createItem1();
        Item2 item2 = factory.createItem2();

    }
}
