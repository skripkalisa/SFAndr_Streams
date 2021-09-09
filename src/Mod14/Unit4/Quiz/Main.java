import java.util.Optional;

public class Main {
    public static void main(String[] args) {
//        Задание 14.4.1
//        String text = "Hello";
//        Optional<String> opt = Optional.of(refactorText(text)); // строка 1
//        System.out.println(opt.isPresent());

//        Задание 14.4.2
//        String text = "Hello";
//        Optional<String> opt = Optional.ofNullable(refactorText(text)); // строка 1
//        System.out.println(opt.orElse(new IllegalStateException())); // строка 2

//        Задание 14.4 .3
//        String hello = "Hello";
//        Optional<String> opt = Optional.ofNullable(hello); // строка 1
//        hello = null;
//        opt.ifPresent(System.out::println);
//
//         Задание 14.4.4
        Optional<Integer> optional = Optional.empty();
        if (optional.isPresent()) {
            System.out.println(optional.get());
        } else {
            System.out.println(optional.orElseGet(() -> 5)); // строка 1
        }

    }

    private static String refactorText(String text) {
        if (text.length() >= 5) {
            return null;
        } else {
            return text + " refactored";
        }
    }
}
