package org.example.BehavioralPatterns.ObserverWithPublisher;

import java.util.ArrayList;
import java.util.List;

class Publisher{
    private List<Subscriber> subscribers = new ArrayList<>();
    private String state = "A";
    public void addSubscriber(Subscriber subscriber){
        System.out.println(subscriber.getClass().getSimpleName() + " added");
        subscribers.add(subscriber);
    }
    public void deleteSubscriber(Subscriber subscriber){
        System.out.println(subscriber.getClass().getSimpleName() + " removed");
        subscribers.remove(subscriber);
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        notifySubscribers();
    }

    public void notifySubscribers(){
        for(Subscriber s : subscribers){
            s.update(this);
        }
    }
}

abstract class Subscriber{
    abstract void update(Publisher context);
}

class SubscriberA extends Subscriber{
    @Override
    void update(Publisher context) {
        System.out.println("SA: publisher change his state.");
        System.out.println("SA: new Publisher state: " + context.getState());
    }
}

class SubscriberB extends Subscriber{
    @Override
    void update(Publisher context) {
        System.out.println("SB: publisher changed his state");
        System.out.println("SB: new Publisher state: " + context.getState());
    }
}


public class Main {
    public static void main(String[] args) {
        Subscriber subscriberA = new SubscriberA();
        Subscriber subscriberB = new SubscriberB();

        Publisher publisher = new Publisher();
        publisher.addSubscriber(subscriberA);
        publisher.addSubscriber(subscriberB);
        publisher.setState("B");
        publisher.deleteSubscriber(subscriberA);
        publisher.setState("C");
    }
}
