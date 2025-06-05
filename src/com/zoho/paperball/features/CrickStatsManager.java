package com.zoho.paperball.features;

import com.zoho.paperball.dto.*;
import java.util.*;

public class CrickStatsManager {
    private final Scanner sc = new Scanner(System.in);
    private final List<Team> teams = new ArrayList<>();
    private final List<Tournament> tournaments = new ArrayList<>();
    private final TeamManager teamManager = new TeamManager(teams, sc);
    private final TournamentManager tournamentManager = new TournamentManager(tournaments, sc);
    private final MatchManager matchManager = new MatchManager(sc);

    public void run() {
        int choice;
        do {
            System.out.println("---------------------------------------------------");
            System.out.println("\nCrickStats - Console-Based Cricket Score Manager");
            System.out.println("---------------------------------------------------");
            System.out.println("1. Create Team");
            System.out.println("2. Add Player to Team");
            System.out.println("3. Start a Match");
            System.out.println("4. Create Tournament");
            System.out.println("5. Add Match to Tournament");
            System.out.println("6. View Tournament Stats");
            System.out.println("7. Exit");
            System.out.println("---------------------------------------------------");
            System.out.print("Enter your choice: ");

                choice = Integer.parseInt(sc.nextLine());
                System.out.println("Invalid input. Please enter a number.");

            switch (choice) {
                case 1 -> teamManager.createTeam();
                case 2 -> teamManager.addPlayerToTeam();
                case 3 -> matchManager.startMatch(teamManager.selectTeam(), teamManager.selectTeam());
                case 4 -> tournamentManager.createTournament();
                case 5 -> {
                    Tournament t = tournamentManager.selectTournament();
                    Team t1 = teamManager.selectTeam();
                    Team t2 = teamManager.selectTeam();
                    if (t != null && t1 != null && t2 != null && !t1.equals(t2)) {
                        Match m = matchManager.startMatch(t1, t2);
                        if (m != null) {
                            tournamentManager.addMatchToTournament(t, m);
                        }
                    } else {
                        System.out.println("Invalid input for adding match to tournament.");
                    }
                }
                case 6 -> {
                    Tournament t = tournamentManager.selectTournament();
                    if (t != null) tournamentManager.viewTournamentStats(t);
                }
                case 7 -> System.out.println("Exiting CrickStats. Thank you!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 7);
    }
}
