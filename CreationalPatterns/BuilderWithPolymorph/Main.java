package org.example.CreationalPatterns.BuilderWithPolymorph;

abstract class Item {
    protected String value1;
    protected String value2;
    protected String value3;
}

class Item1 extends Item {
    Item1(String value1, String value2, String value3) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
    }
}

class Item2 extends Item {
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

    Item getResult();
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
        Builder item1Builder = new Item1Builder().setValue1("1").setValue2("2").setValue3("3");
        Builder item2Builder = new Item2Builder().setValue1("3").setValue2("2").setValue3("1");
        Item item1 = item1Builder.getResult();
        Item item2 = item2Builder.getResult();
    }
}
