package org.example.BehavioralPatterns.ObserverWithEventManager;

import java.util.ArrayList;
import java.util.List;

class EventManager {
    private List<Subscriber> event1Subscribers = new ArrayList<>();
    private List<Subscriber> event2Subscribers = new ArrayList<>();

    public void addEventSubscriber(String event, Subscriber subscriber) {
        System.out.println(subscriber.getClass().getSimpleName() + " added for " + event);
        if (event.equals("event1"))
            event1Subscribers.add(subscriber);
        else if (event.equals("event2"))
            event2Subscribers.add(subscriber);
    }

    public void deleteEventSubscriber(String event, Subscriber subscriber) {
        System.out.println(subscriber.getClass().getSimpleName() + " removed for " + event);
        if (event.equals("event1"))
            event1Subscribers.remove(subscriber);
        else if (event.equals("event2"))
            event2Subscribers.remove(subscriber);
    }

    public void notifySubscribers(String event, String data) {
        if (event.equals("event1")) {
            for (Subscriber s : event1Subscribers) {
                s.update(event, data);
            }
        } else if (event.equals("event2")) {
            for (Subscriber s : event2Subscribers) {
                s.update(event, data);
            }
        }
    }
}

abstract class Subscriber {
    abstract void update(String event, String data);
}

class SubscriberA extends Subscriber {
    @Override
    void update(String event, String data) {
        System.out.println("[SA] event: " + event + " data: " + data);
    }
}

class SubscriberB extends Subscriber {
    @Override
    void update(String event, String data) {
        System.out.println("[SB] event: " + event + " data: " + data);
    }
}


public class Main {
    public static void main(String[] args) {
        Subscriber subscriberA = new SubscriberA();
        Subscriber subscriberB = new SubscriberB();

        EventManager eventManager = new EventManager();

        eventManager.addEventSubscriber("event1", subscriberA);
        eventManager.addEventSubscriber("event1", subscriberB);

        eventManager.addEventSubscriber("event2", subscriberB);

        eventManager.notifySubscribers("event1", "ABC");
        eventManager.deleteEventSubscriber("event1", subscriberB);
        eventManager.notifySubscribers("event1", "CBA");

        eventManager.notifySubscribers("event2", "AAA");
    }
}
