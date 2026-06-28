package ru.Semenov.Persons;


/**
 * Представление полного имени (имя, фамилия, отчество).
 */
public class Name {
    private final String name;
    private final String surname;
    private final String otchestvo;

    /**
     * Создаёт полное имя.
     *
     * @param name       имя
     * @param surname    фамилия
     * @param otchestvo отчество
     * @throws IllegalArgumentException если все части null
     * или пусты
     */
    public Name(String name,
                String surname,
                String otchestvo) {
        if (isNullOrEmpty(name)
                && isNullOrEmpty(surname)
                && isNullOrEmpty(otchestvo)) {
            throw new IllegalArgumentException(
                    "Хотя бы одна часть имени " +
                            "должна быть задана.");
        }

        this.name = name;
        this.surname = surname;
        this.otchestvo = otchestvo;
    }

    /**
     * Создаёт имя с фамилией (без отчества).
     *
     * @param name    имя
     * @param surname фамилия
     */
    public Name(String name, String surname) {
        this(name, surname, null);
    }

    /**
     * Создаёт только имя.
     *
     * @param name имя
     */
    public Name(String name) {
        this(name, null, null);
    }

    /**
     * Формирует строку с частями имени.
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

    /**
     * Вспомогательная функция для проверки на пустоту строки
     * @param s строка
     * @return True (строка пуста) / False (строка не пуста)
     */
    private boolean isNullOrEmpty(final String s) {
        return s == null || s.trim().isEmpty();
    }

}
