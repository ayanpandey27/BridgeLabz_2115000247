import java.util.*;

class VotingSystem {
    private Map<String, Integer> voteMap = new HashMap<>();
    private Map<String, Integer> voteOrderMap = new LinkedHashMap<>();
    private TreeMap<String, Integer> sortedResults;

    public void castVote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrderMap.put(candidate, voteMap.get(candidate));
    }

    public void displayResultsSorted() {
        sortedResults = new TreeMap<>(voteMap);
        System.out.println("Results (Sorted by Candidate Name):");
        for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }

    public void displayResultsInOrder() {
        System.out.println("Results (Order of Votes Cast):");
        for (Map.Entry<String, Integer> entry : voteOrderMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " votes");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        VotingSystem votingSystem = new VotingSystem();

        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Charlie");
        votingSystem.castVote("Alice");
        votingSystem.castVote("Bob");

        System.out.println("\n--- Voting Results ---\n");
        votingSystem.displayResultsSorted();
        System.out.println();
        votingSystem.displayResultsInOrder();
    }
}

