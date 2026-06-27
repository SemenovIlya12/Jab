

/**
 * Модель пистолета с ограниченным боезапасом.
 */
public class Pistol {
    private int rounds;
    private static final int DEFAULT_NUM_ROUNDS = 5;

    /**
     * Создает пистолет с заданым кол-вом патронов
     * @param rounds кол-во патронов
     */
    public Pistol(int rounds) {
        this.rounds = rounds;
    }

    /**
     * Создает пистолет с стандартным кол-вом патронов
     */
    public Pistol() {
        this.rounds = DEFAULT_NUM_ROUNDS;
    }

    /**
     * Производит выстрел
     */
    public void shoot() {
        if (this.rounds > 0) {
            System.out.println("Bah!");
            this.rounds--;
        } else System.out.println("Click");
    }

}
