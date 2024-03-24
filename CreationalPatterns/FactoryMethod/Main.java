package org.example.CreationalPatterns.FactoryMethod;

import java.util.Scanner;

abstract class Item {
    abstract void action();
}

class Item1 extends Item {
    @Override
    void action() {

    }
}

class Item2 extends Item {
    @Override
    void action() {

    }
}

abstract class Factory {
    abstract Item createItem();
}

class Item1Factory extends Factory {
    @Override
    Item createItem() {
        return new Item1();
    }
}

class Item2Factory extends Factory {
    @Override
    Item createItem() {
        return new Item2();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Choose object type: ");
        Scanner console = new Scanner(System.in);
        String factory = console.nextLine();
        Factory factoryType;
        if (factory.equals("1"))
            factoryType = new Item1Factory();
        else if (factory.equals("2"))
            factoryType = new Item2Factory();
        else
            throw new RuntimeException("Unknown factory type");
        factoryType.createItem().action();

    }
}
