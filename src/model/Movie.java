package model;
public class Movie {
    private final String name;
    private final int release;

    public Movie(String name, int release) {
        this.name = name;
        this.release = release;
    }

    public String getName() {
        return name;
    }

    public int getRelease() {
        return release;
    }
}
