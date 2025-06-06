package ru.Semenov.Persons;

import ru.Semenov.Weapon.*;

public class Shooter {
    private String name;
    private Weapon weapon;

    public Shooter(String name) {
            this.name = name;
            this.weapon = null;
    }

    /**
     * Устанавливает стрелку имя
     * @param name имя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Устанавливает стрелку оружие
     * @param wep оружие
     */
    public void setWeapon(Weapon wep) {
        this.weapon = wep;
    }

    /**
     * Заствляет стрелка.. стрелять
     */
    public void shoot() {
        if (this.weapon != null) {
            weapon.shoot();
        } else {
            System.out.println(this.name + ": i cant participate in shooting without a weapon");
        }
    }

}
