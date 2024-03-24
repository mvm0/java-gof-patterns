package org.example.BehavioralPatterns.Memento;

import java.util.ArrayDeque;
import java.util.Deque;

class Item {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }

    public void getDataFromMemento(Memento memento) {
        this.state = memento.getState();
    }
}

class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class Caretaker {
    private Deque<Memento> mementos = new ArrayDeque<>();

    public void addMemento(Memento memento) {
        mementos.addFirst(memento);
    }

    public Memento getMemento() {
        return mementos.pollFirst();
    }
}

public class Main {
    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        Item item = new Item();
        item.setState("1");
        caretaker.addMemento(item.createMemento());
        item.setState("2");
        caretaker.addMemento(item.createMemento());
        item.setState("3");
        System.out.println(item.getState());
        item.getDataFromMemento(caretaker.getMemento());
        System.out.println(item.getState());
        item.getDataFromMemento(caretaker.getMemento());
        System.out.println(item.getState());
    }
}
