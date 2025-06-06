package ru.Semenov.Weapon;

public class Gun extends Pistol{

    private final int speed;

    public Gun() {
        super(30);
        this.speed = 30;
    }

    public Gun(int max) {
        super(max);
        this.speed = max/2;
    }

    public Gun(int max, int Speed) {
        super(max);
        this.speed = Speed;
    }


    @Override
    public void shoot() {
        for (int i = 1; i <= this.speed; i++) {
            if (this.rounds > 0) {
                System.out.println("Bah!");
                this.rounds--;
            } else System.out.println("Click! Unlucky bro");

        }
    }

    /**
     * Вариация метода shoot позволяющая стрелять на протяжении времени
     * @param Time время, в течении которого будет производится выстрелы
     */
    @Override
    public void shoot(int Time) {
        for (int i = 1; i <= this.speed *Time; i++) {
            if (this.rounds > 0) {
                System.out.println("Bah!");
                this.rounds--;
            } else System.out.println("Click!");
        }
    }
}
