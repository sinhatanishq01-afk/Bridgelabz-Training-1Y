package com.gla.Generics;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> votes = new HashMap<>();

        String[] voteStream = {
                "Aman", "Riya", "Aman", "Rahul", "Riya",
                "Aman", "Riya", "Rahul", "Aman", "Riya"
        };

        for (String candidate : voteStream) {
            votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        }

        String winner = null;
        int maxVotes = 0;

        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        System.out.println("Vote Count:");
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("\nWinner: " + winner + " with " + maxVotes + " votes");
    }
}