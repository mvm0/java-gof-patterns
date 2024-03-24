package org.example.StructuralPatterns.Adapter;

class OldService {
    private String oldServiceValue;

    OldService() {
    }

    OldService(String value) {
        this.oldServiceValue = value;
    }

    public String getOldServiceValue() {
        return oldServiceValue;
    }
}

class NewService {
    private Integer newServiceValue;

    NewService() {
    }

    NewService(Integer value) {
        this.newServiceValue = value;
    }

    public Integer getNewServiceValue() {
        return newServiceValue;
    }
}

class OldService_NewService_Adapter extends NewService {
    private final OldService oldService;

    OldService_NewService_Adapter(OldService oldService) {
        this.oldService = oldService;
    }

    @Override
    public Integer getNewServiceValue() {
        return Integer.valueOf(oldService.getOldServiceValue());
    }
}

class ServiceValueChecker {
    public static void check(NewService client) {
        if (client.getNewServiceValue() >= 18)
            System.out.println("OK");
        else
            System.out.println("Error");
    }
}

public class Main {
    public static void main(String[] args) {
        OldService oldService = new OldService("18");
        // ServiceValueChecker.check(oldService1); // error
        NewService newService = new NewService(17);
        ServiceValueChecker.check(newService);
        OldService_NewService_Adapter oldNewService = new OldService_NewService_Adapter(oldService);
        ServiceValueChecker.check(oldNewService);
    }
}
