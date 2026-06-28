package ru.Semenov.Persons;

import ru.Semenov.Weapon.Weapon;


/**
 * Стрелок, который может иметь оружие и стрелять.
 */
public class Shooter {
    private String name;
    private Weapon weapon = null;

    /**
     * Создаёт стрелка с именем.
     *
     * @param name имя стрелка
     */
    public Shooter(String name) {
            this.name = name;
    }

    /**
     * Устанавливает имя.
     *
     * @param name новое имя
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Вооружает стрелка.
     *
     * @param weapon оружие
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    /**
     * Производит выстрел, если есть оружие.
     */
    public void Shoot() {
        if (this.weapon != null) {
            weapon.shoot();
        } else {
            System.out.println(this.name +
                    ": i cant participate in shooting " +
                    "without a weapon");
        }
    }

}
