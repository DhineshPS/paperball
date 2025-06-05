package com.zoho.paperball.features;

import com.zoho.paperball.dto.*;
import java.util.List;
import java.util.Scanner;

public class TeamManager {
    private final List<Team> teams;
    private final Scanner sc;

    public TeamManager(List<Team> teams, Scanner sc) {
        this.teams = teams;
        this.sc = sc;
    }

    public void createTeam() {
        System.out.print("Enter team name: ");
        String name = sc.nextLine();
        teams.add(new Team(name));
        System.out.println("Team '" + name + "' created.");
    }

    public void addPlayerToTeam() {
        Team team = selectTeam();
        if (team != null) {
            System.out.print("Enter player name: ");
            String name = sc.nextLine();
            team.addPlayer(new Player(name));
            System.out.println("Player added to team: " + team.getName());
        }
    }

    public Team selectTeam() {
        if (teams.isEmpty()) {
            System.out.println("No teams available.");
            return null;
        }
        for (int i = 0; i < teams.size(); i++) {
            System.out.println((i + 1) + ". " + teams.get(i).getName());
        }
        System.out.print("Select team number: ");
        int index = sc.nextInt();
        sc.nextLine();
        return (index < 1 || index > teams.size()) ? null : teams.get(index - 1);
    }
}
