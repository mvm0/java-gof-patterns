package org.example.StructuralPatterns.Bridge;

abstract class Device {
    protected String value1;
    protected Integer value2;

    abstract void setValue1(String value1);

    abstract void setValue2(Integer value2);

    abstract void action1();

    abstract void action2();
}

class DeviceA extends Device {

    @Override
    void setValue1(String value) {
        this.value1 = value;
    }

    @Override
    void setValue2(Integer value) {
        this.value2 = value;
    }

    @Override
    public void action1() {
        System.out.println(this.getClass().getName() + ". value1: " + value1);
    }

    @Override
    public void action2() {
        System.out.println(this.getClass().getName() + ". value2: " + value2);
    }
}

class DeviceB extends Device {

    @Override
    void setValue1(String value) {
        this.value1 = value;
    }

    @Override
    void setValue2(Integer value) {
        this.value2 = value;
    }

    @Override
    public void action1() {
        System.out.println(this.getClass().getName() + ". value1: " + value1);
    }

    @Override
    public void action2() {
        System.out.println(this.getClass().getName() + ". value2: " + value2);
    }
}

class DeviceAbs {
    private Device device;

    DeviceAbs() {
    }

    DeviceAbs(Device device) {
        this.device = device;
    }

    public void setValue1(String value) {
        device.setValue1(value);
        device.action1();
    }

    public void setValue2(Integer value) {
        device.setValue2(value);
        device.action2();
    }

}

public class Main {
    public static void main(String[] args) {
        Device[] devices = {new DeviceA(), new DeviceB()};
        DeviceAbs deviceAbs;
        for (Device device : devices) {
            deviceAbs = new DeviceAbs(device);
            deviceAbs.setValue1("10");
            deviceAbs.setValue2(20);
        }

    }
}
