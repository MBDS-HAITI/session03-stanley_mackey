package org.example;

public final class Utils {

    public enum Level {
        LOW,       
        MEDIUM,    
        HIGH,       
        VERY_HIGH   
    }

    // Weapon Power
    public static final int POWER_LOW       = 30; 
    public static final int POWER_MEDIUM    = 40; 
    public static final int POWER_HIGH      = 50; 
    public static final int POWER_VERY_HIGH = 60; 

    // Hit Points
    public static final int HP_LOW          = 40;  
    public static final int HP_MEDIUM       = 60;  
    public static final int HP_HIGH         = 80;  
    public static final int HP_VERY_HIGH    = 100;

    public static int powerFor(Level level) {
        return switch (level) {
            case LOW       -> POWER_LOW;
            case MEDIUM    -> POWER_MEDIUM;
            case HIGH      -> POWER_HIGH;
            case VERY_HIGH -> POWER_VERY_HIGH;
        };
    }

    public static int hpFor(Level level) {
        return switch (level) {
            case LOW       -> HP_LOW;
            case MEDIUM    -> HP_MEDIUM;
            case HIGH      -> HP_HIGH;
            case VERY_HIGH -> HP_VERY_HIGH;
        };
    }
}
