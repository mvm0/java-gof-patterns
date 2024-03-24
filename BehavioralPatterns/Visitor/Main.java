package org.example.BehavioralPatterns.Visitor;

interface Visitor {
    void visit(ElementA element);

    void visit(ElementB element);
}

class MyVisitor implements Visitor {
    @Override
    public void visit(ElementA element) {
        System.out.println("Element A");
        element.action2();
    }

    @Override
    public void visit(ElementB element) {
        System.out.println("Element B");
        element.action2();
    }
}

interface Element {
    void action(Visitor visitor);
}

class ElementA implements Element {
    @Override
    public void action(Visitor visitor) {
        visitor.visit(this);
    }

    public void action2() {
        System.out.println("[A] action2");
    }
}

class ElementB implements Element {
    @Override
    public void action(Visitor visitor) {
        visitor.visit(this);
    }

    public void action2() {
        System.out.println("[B] action2");
    }
}

public class Main {
    public static void main(String[] args) {
        Element element = new ElementA();
        element.action(new MyVisitor());
        element = new ElementB();
        element.action(new MyVisitor());
    }
}
