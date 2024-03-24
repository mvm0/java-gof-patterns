package org.example.BehavioralPatterns.TemplateMethod;

abstract class AbstractClass {
    public final void templateMethod() {
        step1();
        step2();
        step3();
    }

    public void step1() {
        System.out.println("Common step 1");
    }

    abstract void step2();

    public void step3() {
        System.out.println("Common step 3");
    }
}

class ClassA extends AbstractClass {
    @Override
    public void step1() {
        System.out.println("ClassA step1");
    }

    @Override
    public void step2() {
        System.out.println("ClassA step2");
    }
}

class ClassB extends AbstractClass {
    @Override
    public void step2() {
        System.out.println("ClassB step2");
    }

    @Override
    public void step3() {
        System.out.println("ClassB step3");
    }
}

public class Main {
    public static void main(String[] args) {
        AbstractClass tmp = new ClassA();
        tmp.templateMethod();
        System.out.println();
        tmp = new ClassB();
        tmp.templateMethod();
    }
}
