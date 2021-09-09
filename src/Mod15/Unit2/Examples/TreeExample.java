package Mod15.Unit2.Examples;

public class TreeExample {
    static class Wallet {
        double money;
    }

    static class Phone {
        double chargeLevel;
    }

    static class Backpack {
        Wallet wallet;
        Phone phone;
    }

    static class Person {
        String name;
        Backpack backpack;
    }

    public static void main(String[] args) {
        Person person = createPerson();
        // 2
    }

    private static Person createPerson() {
        Phone phone = new Phone();
        phone.chargeLevel = 75;

        Wallet wallet = new Wallet();
        wallet.money = 142;

        Backpack backpack = new Backpack();
        backpack.wallet = wallet;
        backpack.phone = phone;

        Person person = new Person();
        person.name = "Eugene";
        person.backpack = backpack;

        return person; // 1
    }
}
