package Mod10.Task;

public class YouShallNotPass extends Exception {

    public YouShallNotPass(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "You Shall Not Pass {"
                + ", message= " + getMessage()
                + "} ";
    }
}
