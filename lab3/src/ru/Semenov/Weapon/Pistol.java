package ru.Semenov.Weapon;

public class Pistol extends Weapon {
    //protected int Rounds;
    protected int maxRounds;


    public Pistol(int rnds, int max) {
        //this.Rounds = rnds;
        super(rnds);
        this.maxRounds = max;
    }

    public Pistol(int max) {
        //this.Rounds = 5;
        super(5);
        this.maxRounds = max;
    }

    /**
     * Возвращает максимально допустимое кол-во патронов в оружии
     * @return максимум патронов в оружии
     */
    public int getMax() {
        return this.maxRounds;
    }

    /**
     * Заряжает в оружиее патроны и возвращает новое кол-во патронов
     * @param count количество патронов
     * @return новое кол-во патронов
     */
    @Override
    public int reload(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("Count of rounds to reload can`t be negative.");
        }

        if (this.rounds + count > this.maxRounds) {
            int overcap = Math.abs(this.maxRounds - this.rounds - count);
            this.rounds = this.maxRounds;
            return overcap;
        }

        this.rounds += count;
        return count;
    }

    /**
     * Разряжает оружие и возвращает кол-во патронов, которые были заряжены до вызова метода
     * @return
     */
    public String discharge() {
        int Ds = this.rounds;
        this.rounds = 0;
        return "Discharged " + Ds + " rounds from pistol";
    }

    /**
     * Проверяет, заряжено ли оружие
     * @return TRUE если в оружии есть хотя бы 1 заряд, иначе  - False
     */
    public boolean isCharged() {
        return this.rounds > 0;
    }

    @Override
    public void shoot() {
        if (this.rounds > 0) {
            System.out.println("Bah! ");
            this.rounds--;
        } else System.out.println("Click! Unlucky bro");
    }

    /**
     * Стреляет несколько раз
     * @param triggers кол-во выстреллов ружья
     */
    public void shoot(int triggers) {
        for (int i = 1; i <= triggers; i++) {
            this.shoot();
        }
    }


}
