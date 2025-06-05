package com.zoho.paperball.dto;

import java.util.ArrayList;
import java.util.List;

public class Tournament {
    private final String name;
    private final List<Match> matches;

    public Tournament(String name) {
        this.name = name;
        this.matches = new ArrayList<>();
    }

    public void addMatch(Match match) {
        matches.add(match);
    }

    public String getName() {
        return name;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void showTournamentStats() {
        System.out.println("Tournament: " + name);
        for (Match match : matches) {
            match.showResult();
            System.out.println("------------------");
        }
    }
}