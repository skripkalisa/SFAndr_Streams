package Mod11.Examples.Generics;

public class Main {
    public static <Elephant, Monkey, Wolf> void main(String[] args) {
        Crate<Elephant> crateForElephant = new Crate<>(); // создали клетку для слона
        Crate<Monkey> crateForMonkey = new Crate<>(); // и клетку для обезьяны
        Crate<Wolf> crateForWolf = new Crate<>(); // и клетку для волка
// как видите, нам не потребовалось определять каждый раз новый класс для клеток
        Elephant elephant = crateForElephant.getContents();
        Monkey monkey = crateForMonkey.getContents();
        Wolf wolf = crateForWolf.getContents();


        Box<Integer> integerBox = new Box<>(15);
        Number number = integerBox.getContents(); // строка 4
        System.out.println(number.getClass().getSimpleName());
//crateForElephant.setContents(new Wolf()); // compile error
    }
}
