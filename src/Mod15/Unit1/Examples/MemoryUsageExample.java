package Mod15.Unit1.Examples;

public class MemoryUsageExample {
    private static class Person {
        private final String name;
        private int age;

        private Person(String name) {
            this.name = name; // 6
        }

        public void setAge(int age) {
            this.age = age; // 7
        }
    }


    // 1
    public static void main(String[] args) { // 2
        String name = "Eugene"; // 3
        int age = 26; // 4

        Person person = new Person(name); // 5
        person.setAge(age); // 7
    } // 8
}
