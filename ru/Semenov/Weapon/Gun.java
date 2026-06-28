package ru.Semenov.Weapon;


/**
 * Автоматическое оружие (пулемёт)
 * с фиксированной скорострельностью.
 */
public class Gun extends Pistol{
    private static final int DEFAULT_MAX = 30;

    private final int speed;

    /**
     * Создаёт пулемёт с максимальной ёмкостью
     * 30 и скорострельностью 30.
     */
    public Gun() {
        super(DEFAULT_MAX);
        this.Speed = DEFAULT_MAX;
    }

    /**
     * Создаёт пулемёт с заданной максимальной ёмкостью
     * и скорострельностью max/2.
     *
     * @param max максимальная ёмкость
     */
    public Gun(int max) {
        super(max);
        this.speed = max/2;
    }

    /**
     * Создаёт пулемёт с заданной максимальной
     * ёмкостью и скорострельностью.
     * @param max   максимальная ёмкость
     * @param speed скорострельность
     */
    public Gun(int max, int speed) {
        super(max);
        this.speed = speed;
    }

    /**
     * Одна очередь выстрелов.
     */
    public void shoot() {
        for (int i = 1; i <= this.speed; i++) {
            if (this.Rounds > 0) {
                System.out.println("Bah!");
                this.Rounds --;
            } else System.out.println("Click!");

        }
    }

    /**
     * Несколько очередей.
     *
     * @param times количество очередей
     */
    public void shoot(int Time) {
        for (int i = 0; i < times; i++) {
            this.shoot();
        }
    }
}
