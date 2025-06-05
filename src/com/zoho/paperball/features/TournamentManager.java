package com.zoho.paperball.features;

import com.zoho.paperball.dto.*;

import java.util.List;
import java.util.Scanner;

public class TournamentManager {
    private final List<Tournament> tournaments;
    private final Scanner sc;

    public TournamentManager(List<Tournament> tournaments, Scanner sc) {
        this.tournaments = tournaments;
        this.sc = sc;
    }

    public void createTournament() {
        System.out.print("Enter tournament name: ");
        String name = sc.nextLine();
        tournaments.add(new Tournament(name));
        System.out.println("Tournament '" + name + "' created.");
    }

    public void addMatchToTournament(Tournament tournament, Match match) {
        tournament.addMatch(match);
        System.out.println("Match added to tournament: " + tournament.getName());
    }

    public void viewTournamentStats(Tournament tournament) {
        tournament.showTournamentStats();
    }

    public Tournament selectTournament() {
        if (tournaments.isEmpty()) {
            System.out.println("No tournaments available.");
            return null;
        }
        for (int i = 0; i < tournaments.size(); i++) {
            System.out.println((i + 1) + ". " + tournaments.get(i).getName());
        }
        System.out.print("Select tournament number: ");
        int index = sc.nextInt();
        sc.nextLine();
        return (index < 1 || index > tournaments.size()) ? null : tournaments.get(index - 1);
    }
}
