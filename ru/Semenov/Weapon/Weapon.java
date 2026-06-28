package ru.Semenov.Weapon;


public abstract class Weapon {
    protected int rounds;

    /**
     * Создаёт оружие с заданным боезапасом.
     *
     * @param ammo начальное количество патронов
     */
    public Weapon(int ammo) {
        this.rounds = ammo;
    }

    /**
     * Возвращает текущий боезапас.
     *
     * @return количество патронов
     */
    public int getRounds() {
        return this.rounds;
    }

    /**
     * Перезаряжает оружие на указанное количество патронов.
     *
     * @param ammo количество патронов для перезарядки
     * @return реально добавленное количество
     * @throws IllegalArgumentException если ammo < 0
     */
    public int reload(int ammo) {
        if (ammo < 0) {
            throw new IllegalArgumentException(
                    "Ammo amount cant be negative"
            )
        }
        int tmp = ammo;
        this.rounds = ammo;
        return tmp;
    }

    /**
     * Возвращает строковое представление
     * @return строковое представление
     */
    @Override
    public String toString() {
        return this.getRounds()
    }

    /**
     * Производит выстрел.
     */

    public abstract void shoot();

}
