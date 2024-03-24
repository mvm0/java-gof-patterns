package org.example.BehavioralPatterns.Mediator;

abstract class Component {
    protected Mediator mediator;

    Component(Mediator mediator) {
        this.mediator = mediator;
    }
}

class ComponentA extends Component {
    private String status = "ON";

    ComponentA(Mediator mediator) {
        super(mediator);
    }

    public void changeStatus() {
        this.status = status.equals("ON") ? "OFF" : "ON";
        System.out.println("Component A new status: " + this.status);
    }

    public void incrementCBValue() {
        mediator.notify(this, "incrementCBValue");
    }

    public void decrementCBValue() {
        mediator.notify(this, "decrementCBValue");
    }
}

class ComponentB extends Component {
    private Integer value = 0;

    ComponentB(Mediator mediator) {
        super(mediator);
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
        System.out.println("Component B new value: " + this.value);
    }

    public void changeCAStatus() {
        mediator.notify(this, "changeCAStatus");
    }
}

interface Mediator {
    void notify(Component component, String event);
}

class MediatorA implements Mediator {
    private ComponentA componentA;
    private ComponentB componentB;

    MediatorA() {
        this.componentA = new ComponentA(this);
        this.componentB = new ComponentB(this);
    }

    public ComponentA getComponentA() {
        return componentA;
    }

    public ComponentB getComponentB() {
        return componentB;
    }

    @Override
    public void notify(Component component, String event) {
        if (component == componentA) {
            if (event.equals("incrementCBValue"))
                componentB.setValue(componentB.getValue() + 1);
            else if (event.equals("decrementCBValue"))
                componentB.setValue(componentB.getValue() - 1);
        } else if (component == componentB) {
            componentA.changeStatus();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MediatorA mediator = new MediatorA();
        ComponentA componentA = mediator.getComponentA();
        ComponentB componentB = mediator.getComponentB();

        componentA.incrementCBValue();
        componentA.incrementCBValue();
        componentA.decrementCBValue();

        componentB.changeCAStatus();
        componentB.changeCAStatus();
    }
}
