

/**
 * Человек с именем и ростом.
 */
public class Human {
    private final String name;
    private final int height;

    /**
     * Создаёт человека.
     *
     * @param name   имя
     * @param height рост в сантиметрах
     */
    public Human(String name, int height) {
        this.name = name;
        this.height = height;
    }

    /**
     * Возвращает строку с именем и ростом.
     *
     * @return отформатированная строка
     */
    @Override
    public String toString() {
        return this.name + ", Height: " + this.height;
    }
}
