package org.example;

import org.example.Utils.ActionType;

public abstract class Character implements Attacker {
    // name of Character, Can't modify after
    private final String name;

    // Maximum hit points (> 0). Fixed by the chosen type.
    private final int maxHp;

    // Current hit points in [0, maxHp].
    private int hp;

    //Character "has a" Weapon. Power is type-defined.
    private final Weapon weapon;

    //  Constructor
    public Character(String name, int maxHp, Weapon weapon) {
        // Check Validation Before
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name must be non-blank");
        }
        if (maxHp <= 0) {
            throw new IllegalArgumentException("maxHp must be > 0");
        }
        if (weapon == null) {
            throw new IllegalArgumentException("weapon must be non-null");
        }
        this.name = name;
        this.maxHp = maxHp;
        this.weapon = weapon;
        this.hp = maxHp; // hp = maxHp Initially
    }

    // Accessors (read-only for invariants)
    public final String getName() {
        return name;
    }

    public final int getMaxHp() {
        return maxHp;
    }

    public final int getHp() {
        return hp;
    }

    public final Weapon getWeapon() {
        return weapon;
    }

    // alive if hp > 0. Dead characters cannot act or be healed. Can't override
    public final boolean isAlive() {
        return hp > 0;
    }

    // Core combat mechanics (common, safe, spec-compliant)
    public final int receiveDamage(int amount) {
        // Cannot take damage if dead; amount must be > 0
        if (!isAlive() || amount <= 0) return 0;
        int before = hp;
        // hp >=0
        hp = Math.max(0, hp - amount);
        // Apply damage
        return before - hp;
    }

    protected final int receiveHeal(int amount) {
        // Cannot receive healing if dead; amount must be > 0
        if (!isAlive() || amount <= 0) return 0;
        int before = hp;
        // hp <= maxHp
        hp = Math.min(maxHp, hp + amount);
        // Apply healing
        return hp - before;
    }

    @Override
    public int attack(Character target) {
        if (target == null) return 0;
        int power = Math.max(0, weapon.getPower()); // Weapon API kept minimal
        if (power == 0) return 0;
        return target.receiveDamage(power);
    }

    @Override
    public String toString() {
        return "Character {Type = " + getTypeName() + ", name='" + name +", maxHp=" + maxHp + ", hp=" + hp +", weapon=" + weapon + "}";
    }

    public abstract String getTypeName();

    public abstract String getTypeDescription();

//    public abstract void action();

}
