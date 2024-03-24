package org.example.BehavioralPatterns.Strategy;

interface Strategy {
    void execute(String data);
}

class StrategyA implements Strategy {
    @Override
    public void execute(String data) {
        data = data.toUpperCase();
        System.out.println("[SA] message: " + data);
    }
}

class StrategyB implements Strategy {
    @Override
    public void execute(String data) {
        data = data.toLowerCase();
        System.out.println("[SB] message: " + data);
    }
}

class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void doAction(String data) {
        strategy.execute(data);
    }
}

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new StrategyA());
        context.doAction("Hello");
        context.doAction("Bye");

        context.setStrategy(new StrategyB());
        context.doAction("TEST");

    }
}
