public class Name {

    private String name;
    private String surname;
    private String otche;

    public Name(String name, String surname, String otche) {
        this.name = name;
        this.surname = surname;
        this.otche = otche;
    }

    public Name(String name, String surname) {
        this(name, surname, null);
    }

    public Name(String name) {
        this(name, null, null);
    }


    @Override
    public String toString() {
        return (this.name != null ? this.name + " " : "") + (this.surname != null ? this.surname + " " : "") + (this.otche != null ? this.otche + " " : "");
    }

}
