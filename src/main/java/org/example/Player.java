package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private final String name;
    private final List<Character> team;

    public Player(String name, List<Character> team) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("player name must be non-blank");
        }
        validateTeam(team);
        this.name = name;
        this.team = List.copyOf(team); // defensive copy, immutable
    }

    public String getName() {
        return name;
    }

    public List<Character> getTeam() {
        return team;
    }

    // Player's State
    public boolean isDefeated() {
        boolean b = team.stream().noneMatch(Character::isAlive);
        return b;
    }

    public int aliveCount() {
        return (int) team.stream().filter(Character::isAlive).count();
    }

    public List<Character> aliveMembers() {
        return team.stream().filter(Character::isAlive).toList();
    }

    public boolean hasType(String typeName) {
        return team.stream().anyMatch(c -> c.getTypeName().equals(typeName));
    }

    public Character findByName(String characterName) {
        return team.stream().filter(c -> c.getName().equals(characterName)).findFirst().orElse(null);
    }

    private static void validateTeam(List<Character> team) {
        if (team.size() != 3) {
            throw new IllegalArgumentException("team must contain exactly 3 characters (got " + team.size() + ")");
        }
        for (int i = 0; i < team.size(); i++) {
            if (team.get(i) == null) {
                throw new IllegalArgumentException("team contains a null character at index " + i);
            }
            if (!team.get(i).isAlive()) {
                throw new IllegalArgumentException("character at index " + i + " is not alive at start");
            }
        }
        validateUniqueTypes(team);
    }

    private static void validateUniqueTypes(List<Character> team) {
        Set<String> seen = new HashSet<>();
        for (Character c : team) {
            String type = c.getTypeName();
            if (type == null || type.isBlank()) {
                throw new IllegalArgumentException("character type name must be non-blank");
            }
            if (!seen.add(type)) {
                throw new IllegalArgumentException("duplicate character type in team: " + type);
            }
        }
    }
}
