package org.example;

public class Weapon {
    // Display name (e.g., "Sword", "Staff", "Hammer", "Axe"). 
    private final String name;

    // Flat attack power (non-negative). 
    private final int power;


    public Weapon(String name, int power) {
        // Check Validation Before
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name must be non-blank");
        }
        if (power < 0) {
            throw new IllegalArgumentException("power must be >= 0");
        }
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return name + " (" + power + ")";
    }
}
