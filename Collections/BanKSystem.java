import java.util.*;

class BankingSystem {
    private Map<String, Double> accounts = new HashMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();

    public void addAccount(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
    }

    public void deposit(String accountNumber, double amount) {
        accounts.put(accountNumber, accounts.getOrDefault(accountNumber, 0.0) + amount);
    }

    public void requestWithdrawal(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        } else {
            System.out.println("Account not found: " + accountNumber);
        }
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            System.out.println("Processing withdrawal for Account: " + accountNumber);
        }
    }

    public void displaySortedByBalance() {
        TreeMap<Double, String> sortedAccounts = new TreeMap<>();
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            sortedAccounts.put(entry.getValue(), entry.getKey());
        }

        System.out.println("Accounts Sorted by Balance:");
        for (Map.Entry<Double, String> entry : sortedAccounts.entrySet()) {
            System.out.println("Account: " + entry.getValue() + " - Balance: $" + entry.getKey());
        }
    }

    public void displayAccounts() {
        System.out.println("All Accounts:");
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            System.out.println("Account: " + entry.getKey() + " - Balance: $" + entry.getValue());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.addAccount("A101", 5000.00);
        bank.addAccount("A102", 2500.50);
        bank.addAccount("A103", 10000.75);
        bank.addAccount("A104", 7500.30);

        System.out.println("\n--- Banking System ---\n");
        bank.displayAccounts();
        System.out.println();
        bank.displaySortedByBalance();

        bank.requestWithdrawal("A102");
        bank.requestWithdrawal("A104");

        System.out.println("\nProcessing Withdrawals:\n");
        bank.processWithdrawals();
    }
}

