package ru.Semenov.Weapon;

abstract public class Weapon {
    protected int rounds;

    public Weapon(int ammo) {
        this.rounds = ammo;
    }

    /**
     * Возвращает количество патронов
     * @return количество патронов
     */
    public int getRounds() {
        return this.rounds;
    }

    /**
     * Заряжает в оружие патроны и возращает сколько патронов было заряжено
     * @param ammo количество патронов
     * @return кол-во патронов
     */
    public int reload(int ammo) {
        if (ammo < 0) throw new RuntimeException();
        int tmp = ammo;
        this.rounds = ammo;
        return tmp;
    }

    /**
     * Заставляет оружие стрелять
     */
    public abstract void shoot();

    @Override
    public String toString() {
        return Integer.toString(this.rounds);
    }



}
