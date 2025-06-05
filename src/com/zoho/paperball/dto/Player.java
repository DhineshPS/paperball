package com.zoho.paperball.dto;

public class Player {
    private final String name;
    private int runs;
    private int wickets;

    public Player(String name) {
        this.name = name;
        this.runs = 0;
        this.wickets = 0;
    }

    public void addRuns(int runs) {
        this.runs += runs;
    }

    public void addWicket() {
        this.wickets++;
    }

    public String getName() {
        return name;
    }

    public int getRuns() {
        return runs;
    }

    public int getWickets() {
        return wickets;
    }

    @Override
    public String toString() {
        return name + " | Runs: " + runs + " | Wickets: " + wickets;
    }
}