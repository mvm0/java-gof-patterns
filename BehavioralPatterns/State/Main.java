package org.example.BehavioralPatterns.State;

interface State {
    void doAction();

    void setContext(Context context);
}

class StateA implements State {
    Context context;

    @Override
    public void doAction() {
        System.out.println("StateA action");
        context.setState(new StateB());
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }
}

class StateB implements State {
    Context context;

    @Override
    public void doAction() {
        System.out.println("StateB action");
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }
}

class Context {
    State state;

    public Context(State state) {
        this.state = state;
        state.setContext(this);
    }

    public void setState(State state) {
        this.state = state;
        state.setContext(this);
    }

    public void doAction() {
        System.out.println("Common action #1");
        state.doAction();
        System.out.println("Common action #2");
    }
}

public class Main {
    public static void main(String[] args) {
        Context context = new Context(new StateA());
        context.doAction();
        System.out.println();
        context.doAction();
        System.out.println();
        context.setState(new StateA());
        context.doAction();
    }
}
