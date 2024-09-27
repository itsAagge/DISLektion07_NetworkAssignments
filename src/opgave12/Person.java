package opgave12;

public class Person {
    private int id;
    private String navn;
    private String by;

    public Person(int id, String navn, String by) {
        this.id = id;
        this.navn = navn;
        this.by = by;
    }

    public int getId() {
        return id;
    }

    public String getNavn() {
        return navn;
    }

    public String getBy() {
        return by;
    }

    @Override
    public String toString() {
        return "(" + this.id + " " + this.navn + " " + this.by + ")";
    }
}
