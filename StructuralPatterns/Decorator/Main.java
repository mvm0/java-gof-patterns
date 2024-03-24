package org.example.StructuralPatterns.Decorator;

interface ItemAction {
    void actionA();

    void actionB();
}

class ItemA implements ItemAction {

    @Override
    public void actionA() {
        System.out.println("ItemA ActionA");
    }

    @Override
    public void actionB() {
        System.out.println("ItemA ActionB");
    }
}

class ItemB implements ItemAction {

    @Override
    public void actionA() {
        System.out.println("ItemB ActionA");
    }

    @Override
    public void actionB() {
        System.out.println("ItemB ActionB");
    }
}

abstract class DecoratorItem implements ItemAction {
    protected ItemAction item;

    DecoratorItem(ItemAction item) {
        this.item = item;
    }
}

class DItem extends DecoratorItem {
    DItem(ItemAction item) {
        super(item);
    }

    @Override
    public void actionA() {
        System.out.println("DItem works for actionA()");
        item.actionA();
    }

    @Override
    public void actionB() {
        System.out.println("DItem works for actionB()");
        item.actionB();
    }
}

class DItem2 extends DecoratorItem {
    DItem2(ItemAction item) {
        super(item);
    }

    @Override
    public void actionA() {
        System.out.println("DItem2 works for actionA()");
        item.actionA();
    }

    @Override
    public void actionB() {
        System.out.println("DItem2 works for actionB()");
        item.actionB();
    }
}

public class Main {
    public static void main(String[] args) {
        ItemA itemA = new ItemA();
        itemA.actionA();
        itemA.actionB();

        ItemB itemB = new ItemB();
        itemB.actionA();
        itemB.actionB();

        DecoratorItem dItem = new DItem(itemA);
        dItem.actionA();
        dItem.actionB();

        DecoratorItem dItem2 = new DItem2(itemB);
        dItem2.actionA();
        dItem2.actionB();
    }
}
