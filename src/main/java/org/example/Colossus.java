package org.example;

public class Colossus extends Character{
    private static final int    BASE_HP     = Utils.hpFor(Utils.Level.VERY_HIGH);
    private static final Weapon BASE_WEAPON = new Weapon("Sword", Utils.powerFor(Utils.Level.MEDIUM));

    public Colossus(String name) {
        super(name, BASE_HP, BASE_WEAPON);
    }

    @Override
    public String getTypeName() {
        return "Colossus";
    }

    @Override
    public String getTypeDescription() {
        return "Très résistant";
    }
}
