package Mod10.Examples;

public class MyException extends ArithmeticException {
    private int detail;
    public MyException(int detail, String message) {
        super(message);
        this.detail = detail;
    }

    public MyException() {

    }

    @Override
    public String toString() {
        return "MyException{"
                + "detail=" + detail
                + ", message=" + getMessage()
                + "} ";
    }
}
