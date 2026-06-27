

/**
 * Представление полного имени (имя, фамилия, отчество).
 */
public class Name {
    private final String name;
    private final String surname;
    private final String otchestvo;

    /**
     * Полное имя со всеми частями.
     *
     * @param name  имя
     * @param surname   фамилия
     * @param otchestvo отчество
     */
    public Name(String name, String surname, String otchestvo) {
        this.name = name;
        this.surname = surname;
        this.otchestvo = otchestvo;
    }

    /**
     * Имя и фамилия без отчества.
     *
     * @param name имя
     * @param surname  фамилия
     */
    public Name(String name, String surname) {
        this(name, surname, null);
    }

    /**
     * Только имя.
     *
     * @param name имя
     */
    public Name(String name) {
        this(name, null, null);
    }

    /**
     * Формирует полное имя с пробелами.
     *
     * @return строка вида "Имя Фамилия Отчество"
     */
    @Override
    public String toString() {
        return (this.name != null ? this.name + " " : "")
                + (this.surname != null ?
                    this.surname + " " : "")
                + (this.otchestvo != null ?
                    this.otchestvo + " " : "");
    }

}
