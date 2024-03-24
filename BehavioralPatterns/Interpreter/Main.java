package org.example.BehavioralPatterns.Interpreter;

import java.util.Stack;

interface Expression {
    int interpret(Expression context);
}

class Number implements Expression {
    int number;

    Number(int number) {
        this.number = number;
    }

    @Override
    public int interpret(Expression context) {
        return number;
    }
}

class Plus implements Expression {
    Expression expressionLeft;
    Expression expressionRight;

    public Plus(Expression expressionLeft, Expression expressionRight) {
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    @Override
    public int interpret(Expression context) {
        return expressionLeft.interpret(context) + expressionRight.interpret(context);
    }
}

class Minus implements Expression {
    Expression expressionLeft;
    Expression expressionRight;

    public Minus(Expression expressionLeft, Expression expressionRight) {
        this.expressionLeft = expressionLeft;
        this.expressionRight = expressionRight;
    }

    @Override
    public int interpret(Expression context) {
        return expressionLeft.interpret(context) - expressionRight.interpret(context);
    }
}

class Evaluate implements Expression {
    Expression evaluate;

    public Evaluate(String expression) {
        Stack<Expression> expressions = new Stack<>();
        String expressionReverse = new StringBuilder(expression).reverse().toString();
        for (String p : expressionReverse.split("\\D")) {
            expressions.push(new Number(Integer.parseInt(p)));
        }
        for (String s : expression.split("\\d")) {
            if (s.equals("+"))
                expressions.push(new Plus(expressions.pop(), expressions.pop()));
            else if (s.equals("-"))
                expressions.push(new Minus(expressions.pop(), expressions.pop()));
        }
        evaluate = expressions.pop();
    }

    @Override
    public int interpret(Expression context) {
        return evaluate.interpret(context);
    }
}

public class Main {
    public static void main(String[] args) {
        String expression = "1+2-3+6";
        Evaluate evaluate = new Evaluate(expression);
        System.out.println(evaluate.interpret(evaluate));
    }
}
