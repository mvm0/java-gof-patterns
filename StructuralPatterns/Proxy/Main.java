package org.example.StructuralPatterns.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

interface Action {
    void print();

    void print2();
}

class Service implements Action {

    @Override
    public void print() {
        System.out.println("Service Action");
    }

    @Override
    public void print2() {
        System.out.println("Service Action2");
    }
}

class Proxy implements Action {
    private Service service;

    Proxy(Service service) {
        this.service = service;
    }

    @Override
    public void print() {
        System.out.println("Logging...");
        service.print();
        System.out.println("End");
    }

    @Override
    public void print2() {
        System.out.println("Logging...");
        service.print();
        System.out.println("End");
    }
}

public class Main {
    public static void main(String[] args) {
        new Service().print();

        new Proxy(new Service()).print();

        Action s = (Action) java.lang.reflect.Proxy.newProxyInstance(Service.class.getClassLoader(),
                Service.class.getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("print")) {
                            System.out.println("dynamic-proxy logging...");
                            method.invoke(new Service());
                            System.out.println("dynamic-proxy end");
                        }
                        return null;
                    }
                });
        s.print();

    }
}
