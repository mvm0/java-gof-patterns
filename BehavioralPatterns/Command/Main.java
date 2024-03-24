package org.example.BehavioralPatterns.Command;

class Service{
    public void Action1(){
        System.out.println("Action1");
    }
    public void Action2(){
        System.out.println("Action2");
    }
}

abstract class Command{
    protected Service service;
    Command(Service service){
        this.service = service;
    }
   abstract void execute();
}

class ServiceCommand1 extends Command {
    ServiceCommand1(Service service) {
        super(service);
    }
    @Override
    public void execute() {
        service.Action1();
    }
}

class ServiceCommand2 extends Command {
    ServiceCommand2(Service service){
        super(service);
    }
    @Override
    public void execute() {
        service.Action2();
    }
}

class Invoker{
    private Command command;
    public void setCommand(Command command){
        this.command = command;
    }
    public void executeCommand(){
        command.execute();
    }

}

public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        Command command1 = new ServiceCommand1(service);
        Command command2 = new ServiceCommand2(service);

        Invoker invoker = new Invoker();
        invoker.setCommand(command1);
        invoker.executeCommand();
        invoker.setCommand(command2);
        invoker.executeCommand();
    }
}
