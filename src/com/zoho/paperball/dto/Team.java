package com.zoho.paperball.dto;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private final String name;
    private final List<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " | Players: " + players.size();
    }
}