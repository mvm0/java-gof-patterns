package org.example.CreationalPatterns.Builder;

class Item1 {
    private String value1;
    private String value2;
    private String value3;

    Item1(String value1, String value2, String value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }
}

class Item2 {
    private String value1;
    private String value2;
    private String value3;

    Item2(String value1, String value2, String value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }
}

interface Builder {
    Builder setValue1(String value1);

    Builder setValue2(String value2);

    Builder setValue3(String value3);
}

class Item1Builder implements Builder {
    private String value1;
    private String value2;
    private String value3;

    @Override
    public Item1Builder setValue1(String value1) {
        this.value1 = value1;
        return this;
    }

    @Override
    public Item1Builder setValue2(String value2) {
        this.value2 = value2;
        return this;
    }

    @Override
    public Item1Builder setValue3(String value3) {
        this.value3 = value3;
        return this;
    }

    public Item1 getResult() {
        return new Item1(value1, value2, value3);
    }
}

class Item2Builder implements Builder {
    private String value1;
    private String value2;
    private String value3;

    @Override
    public Item2Builder setValue1(String value1) {
        this.value1 = value1;
        return this;
    }

    @Override
    public Item2Builder setValue2(String value2) {
        this.value2 = value2;
        return this;
    }

    @Override
    public Item2Builder setValue3(String value3) {
        this.value3 = value3;
        return this;
    }

    public Item2 getResult() {
        return new Item2(value1, value2, value3);
    }
}

public class Main {
    public static void main(String[] args) {
        Item1Builder item1Builder = new Item1Builder().setValue1("1").setValue2("2").setValue3("3");
        Item2Builder item2Builder = new Item2Builder().setValue1("3").setValue2("2").setValue3("1");
        Item1 item1 = item1Builder.getResult();
        Item2 item2 = item2Builder.getResult();
    }
}
