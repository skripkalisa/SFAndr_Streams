package Mod11.Examples.Generics;

public class Box<T> {
    private T contents;
    public Box(T contents) {
        this.contents = contents;
    }
    public T getContents() {
        return contents;
    }
    public void setContents(T contents) {
        this.contents = contents;
    }
}
