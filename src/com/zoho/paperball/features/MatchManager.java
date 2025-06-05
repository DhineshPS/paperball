package com.zoho.paperball.features;

import com.zoho.paperball.dto.*;
import java.util.List;
import java.util.Scanner;

public class MatchManager {
    private final Scanner sc;

    public MatchManager(Scanner sc) {
        this.sc = sc;
    }

    public Match startMatch(Team t1, Team t2) {
        if (t1 == null || t2 == null || t1.equals(t2)) {
            System.out.println("Invalid team selection.");
            return null;
        }
        Match match = new Match(t1, t2);
        for (Team team : List.of(t1, t2)) {
            System.out.println("Enter stats for team: " + team.getName());
            for (Player player : team.getPlayers()) {
                System.out.print("Runs for " + player.getName() + ": ");
                int runs = sc.nextInt();
                System.out.print("Wicket taken by " + player.getName() + "? (true/false): ");
                boolean wicket = sc.nextBoolean();
                match.updateScore(team, player, runs, wicket);
            }
        }
        match.showResult();
        return match;
    }
}
