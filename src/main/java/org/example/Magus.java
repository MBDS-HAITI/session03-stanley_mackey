package org.example;

public class Magus extends Character implements Healer{
    private static final int    BASE_HP     = Utils.hpFor(Utils.Level.HIGH);
    private static final Weapon BASE_WEAPON = new Weapon("Staff", Utils.powerFor(Utils.Level.LOW));

    public Magus(String name) {
        super(name, BASE_HP, BASE_WEAPON);
    }

    @Override
    public String getTypeName() {
        return "MAGUS";
    }

    @Override
    public String getTypeDescription() {
        return "Peut soigner ses alliés";
    }


    @Override
    public void action(Character character,int actionType)  {
        if (actionType==1){
            attack(character);
        } else if (actionType==2) {
            heal(character);
        }
    }



    @Override
    public void heal(Character ally) {
        // Can not heal if ally dead or hp =maxHp
        System.out.println("%s is healing %s".formatted(this,ally));
        if (ally == null) return ;
        if (ally.getHp() <= 0 || ally.getHp() == ally.getMaxHp()) return ;
        ally.receiveHeal(BASE_WEAPON.getPower());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
