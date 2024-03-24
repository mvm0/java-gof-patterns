package org.example.StructuralPatterns.Facade;

class ItemA {
    public void action() {
        System.out.println("ItemA works");
    }
}

class ItemB {
    public void action() {
        System.out.println("ItemB works");
    }
}

class ItemC {
    public void action() {
        System.out.println("ItemC works");
    }
}

class FacadeI {
    public void action() {
        ItemA itemA = new ItemA();
        ItemB itemB = new ItemB();
        ItemC itemC = new ItemC();
        itemA.action();
        itemB.action();
        itemC.action();
    }
}

public class Main {
    public static void main(String[] args) {
        // without Facade
        ItemA itemA = new ItemA();
        ItemB itemB = new ItemB();
        ItemC itemC = new ItemC();
        itemA.action();
        itemB.action();
        itemC.action();
        System.out.println();
        // with Facade
        FacadeI facadeI = new FacadeI();
        facadeI.action();
    }
}
