package org.example;

public class Dwarf extends Character {

    public Dwarf(String name, int maxHp, Weapon weapon) {
        super(name, maxHp, weapon);
    }

    @Override
    public String getTypeName() {
        return "";
    }
}
