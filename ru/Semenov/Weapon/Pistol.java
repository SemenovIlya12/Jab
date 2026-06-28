package ru.Semenov.Weapon;

/**
 * Пистолет с ограниченным магазином.
 */

public class Pistol extends Weapon {
    private static final int DEFAULT_ROUNDS = 5;

    protected int maxRounds;

    /**
     * Создаёт пистолет с заданными начальным
     * и максимальным запасом.
     * @param rounds    начальное количество патронов
     * @param maxRounds максимальная ёмкость
     */
    public Pistol(int rounds, int max) {
        super(rounds);
        this.maxRounds = max;
    }

    /**
     * Создаёт пистолет с 5 патронами и
     * заданной максимальной ёмкостью.
     * @param maxRounds максимальная ёмкость
     */
    public Pistol(int maxRounds) {
        super(DEFAULT_ROUNDS);
        this.maxRounds = maxRounds;
    }

    /**
     * Возвращает максимальную ёмкость.
     *
     * @return максимальное количество патронов
     */
    public int getMax() {
        return this.maxRounds;
    }

    /**
     * Перезаряжает пистолет, учитывая максимальную ёмкость.
     *
     * @param count количество патронов для перезарядки
     * @return реально добавленное количество
     * @throws IllegalArgumentException если count < 0
     */
    public int reload(int count) {
        if (count < 0) {
            throw new IllegalArgumentException(
                    "Count of rounds to " +
                    "reload can`t be negative.");
        }

        final int freeSpace = this.maxRounds - this.rounds;
        final int toAdd = Math.min(count, freeSpace);
        this.rounds += toAdd;
        return toAdd;
    }

    /**
     * Разряжает пистолет, возвращая
     * количество извлечённых патронов.
     * @return количество разряженных патронов
     */
    public String discharge() {
        final int removed = this.rounds;
        this.rounds = 0;
        return removed;
    }

    /**
     * Проверяет, заряжен ли пистолет.
     *
     * @return true, если есть патроны
     */
    public boolean isCharged() {
        return this.rounds > 0
    }

    /**
     * Производит одиночный выстрел.
     */
    public void shoot() {
        if (this.rounds > 0) {
            System.out.println("Bah! ");
            this.rounds --;
        } else System.out.println("Click!);
    }

    /**
     * Производит серию выстрелов.
     * @param count количество выстрелов
     */
    public void shoot(int triggers) {
        for (int i = 1; i <= triggers; i++) {
            this.shoot();
        }
    }


}
