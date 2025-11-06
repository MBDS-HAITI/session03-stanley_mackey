package org.example;

public class Colossus extends Character{
    public Colossus(String name, int maxHp, Weapon weapon) {
        super(name, maxHp, weapon);
    }

    @Override
    public String getTypeName() {
        return "";
    }
}
