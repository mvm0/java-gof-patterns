package org.example.BehavioralPatterns.ChainOfResponsibility;

abstract class BaseHandler {
    protected BaseHandler nextHandler;

    public BaseHandler setNext(BaseHandler handler) {
        this.nextHandler = handler;
        return nextHandler;
    }

    public boolean checkNext(String tmp) {
        return nextHandler != null;
    }

    abstract String handleRequest(String tmp);
}

class Handler1 extends BaseHandler {
    @Override
    public String handleRequest(String tmp) {
        if (checkNext(tmp))
            tmp = nextHandler.handleRequest(tmp);
        else
            tmp = "Handler 1: " + tmp;
        return tmp;
    }
}

class Handler2 extends BaseHandler {
    @Override
    public String handleRequest(String tmp) {
        if (checkNext(tmp))
            tmp = nextHandler.handleRequest(tmp);
        tmp = "Handler 2: " + tmp;
        return tmp;
    }
}

class Handler3 extends BaseHandler {
    @Override
    public String handleRequest(String tmp) {
        tmp = "Handler 3: " + tmp;
        if (checkNext(tmp))
            tmp = nextHandler.handleRequest(tmp);
        return tmp;
    }
}


public class Main {
    public static void main(String[] args) {
        BaseHandler handler1 = new Handler1();
        BaseHandler handler2 = new Handler2();
        BaseHandler handler3 = new Handler3();
        handler1.setNext(handler2).setNext(handler3);
        System.out.println(handler1.handleRequest("Hello!"));
    }
}
