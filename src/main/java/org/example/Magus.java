package org.example;

public class Magus extends Character implements Healer{
    private static final int    BASE_HP     = Utils.hpFor(Utils.Level.HIGH);
    private static final Weapon BASE_WEAPON = new Weapon("Staff", Utils.powerFor(Utils.Level.LOW));

    public Magus(String name) {
        super(name, BASE_HP, BASE_WEAPON);
    }

    @Override
    public String getTypeName() {
        return "Magus";
    }

    @Override
    public String getTypeDescription() {
        return "Peut soigner ses alliés";
    }



    @Override
    public int heal(Character ally) {
        // Can not heal if ally dead or hp =maxHp
        if (ally == null) return -1;
        if (ally.getHp() <= 0 || ally.getHp() == ally.getMaxHp()) return -1;
        return ally.receiveHeal(BASE_WEAPON.getPower());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
