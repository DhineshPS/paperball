package com.zoho.paperball.dto;

public class Match {
    private final Team team1;
    private final Team team2;
    private int team1Score, team2Score;

    public Match(Team t1, Team t2) {
        this.team1 = t1;
        this.team2 = t2;
        this.team1Score = 0;
        this.team2Score = 0;
    }

    public void updateScore(Team team, Player player, int runs, boolean wicket) {
        if (team.equals(team1)) {
            team1Score += runs;
        } else if (team.equals(team2)) {
            team2Score += runs;
        }
        player.addRuns(runs);
        if (wicket) player.addWicket();
    }

    public void showResult() {
        System.out.println("Match: " + team1.getName() + " vs " + team2.getName());
        System.out.println(team1.getName() + " Score: " + team1Score);
        System.out.println(team2.getName() + " Score: " + team2Score);
        if (team1Score > team2Score) {
            System.out.println("Winner: " + team1.getName());
        } else if (team2Score > team1Score) {
            System.out.println("Winner: " + team2.getName());
        } else {
            System.out.println("Match Drawn");
        }
    }
}