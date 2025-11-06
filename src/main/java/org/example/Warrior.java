package org.example;

public class Warrior extends Character{

    private static final int    BASE_HP     = 100;
    private static final Weapon BASE_WEAPON = new Weapon("Sword", 20);

    public Warrior(String name, int maxHp, Weapon weapon) {
        super(name, maxHp, weapon);
    }

    @Override
    public String getTypeName() {
        return "Warrior";
    }
}
