package org.example.CreationalPatterns.Singleton;

class SimpleSingleton{
    public static final SimpleSingleton singleton = new SimpleSingleton();
    private SimpleSingleton(){};
    public void print(){
        System.out.println("SimpleSingleton");
    }
}

class SimpleThreadSafeSingleton{
    private static volatile SimpleThreadSafeSingleton singleton = new SimpleThreadSafeSingleton();
    private SimpleThreadSafeSingleton(){}
    public static SimpleThreadSafeSingleton getInstance(){
        return singleton;
    }
    public void print(){
        System.out.println("SimpleThreadSafeSingleton");
    }
}

class LazySingleton{
    private static LazySingleton singleton;
    private LazySingleton(){}
    public static LazySingleton getInstance(){
        if(singleton == null)
            singleton = new LazySingleton();
        return singleton;
    }
    public void print(){
        System.out.println("LazySingleton");
    }
}

class DoubleCheckSingleton{
    private static volatile DoubleCheckSingleton singleton;
    private DoubleCheckSingleton(){}
    public static DoubleCheckSingleton getInstance(){
        if(singleton == null){
            synchronized (DoubleCheckSingleton.class){
                if(singleton == null){
                    singleton = new DoubleCheckSingleton();
                }
            }
        }
        return singleton;
    }
    public void print(){
        System.out.println("DoubleCheckSingleton");
    }
}

class NestedClassSingleton{
    private static class Holder{
        private static final NestedClassSingleton singleton = new NestedClassSingleton();
    }
    private NestedClassSingleton(){}
    public static NestedClassSingleton getInstance(){
        return Holder.singleton;
    }
    public void print(){
        System.out.println("NestedClassSingleton");
    }
}

enum EnumSingleton{
    singleton;
    public void print(){
        System.out.println("EnumSingleton");
    }
}

public class Main {
    public static void main(String[] args) {
        SimpleSingleton.singleton.print();
        SimpleThreadSafeSingleton.getInstance().print();
        LazySingleton.getInstance().print();
        DoubleCheckSingleton.getInstance().print();
        NestedClassSingleton.getInstance().print();
        EnumSingleton.singleton.print();
    }
}
