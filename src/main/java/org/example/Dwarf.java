package org.example;

public class Dwarf extends Character {

    private static final int    BASE_HP     = Utils.hpFor(Utils.Level.LOW);
    private static final Weapon BASE_WEAPON = new Weapon("Axe", Utils.powerFor(Utils.Level.VERY_HIGH));

    public Dwarf(String name) {
        super(name, BASE_HP, BASE_WEAPON);
    }

    @Override
    public String getTypeName() {
        return "Dwarf";
    }

    @Override
    public String getTypeDescription() {
        return "Très fort mais fragile";
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
