package Models;

public class Squad {
    private String name;
    private int size;
    private  String cause;

    public Squad(String name, int size, String cause) {
        this.name = name;
        this.size = size;
        this.cause = cause;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public String getCause() {
        return cause;
    }
}
