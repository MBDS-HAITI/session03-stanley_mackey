package org.example;

public class Warrior extends Character{

    private static final int    BASE_HP     = Utils.hpFor(Utils.Level.MEDIUM);
    private static final Weapon BASE_WEAPON = new Weapon("Sword", Utils.powerFor(Utils.Level.MEDIUM));

    public Warrior(String name) {
        super(name, BASE_HP, BASE_WEAPON);
    }

    @Override
    public String getTypeName() {
        return "WARRIOR";
    }

    @Override
    public String getTypeDescription() {
        return "Attaquant équilibré";
    }

    @Override
    public void action(Character character,int actonType) {
        if(actonType==2)return;
        attack(character);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
