import java.time.LocalDate;
import java.util.*;

class Policy {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
    public String toString() {
        return policyNumber + " - " + policyholderName + " - " + expiryDate + " - " + coverageType + " - $" + premiumAmount;
    }
}

class InsurancePolicySystem {
    Map<String, Policy> policyMap = new HashMap<>();
    Map<String, Policy> orderedPolicies = new LinkedHashMap<>();
    TreeMap<LocalDate, List<Policy>> expirySortedPolicies = new TreeMap<>();

    public void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicies.put(policy.policyNumber, policy);
        expirySortedPolicies.computeIfAbsent(policy.expiryDate, k -> new ArrayList<>()).add(policy);
    }

    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<Policy> getPoliciesExpiringSoon(int days) {
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(days);
        List<Policy> expiringPolicies = new ArrayList<>();
        expirySortedPolicies.subMap(today, threshold).values().forEach(expiringPolicies::addAll);
        return expiringPolicies;
    }

    public List<Policy> getPoliciesByHolder(String policyholderName) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.policyholderName.equalsIgnoreCase(policyholderName)) {
                result.add(policy);
            }
        }
        return result;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<LocalDate> iterator = expirySortedPolicies.keySet().iterator();
        while (iterator.hasNext()) {
            LocalDate expiryDate = iterator.next();
            if (expiryDate.isBefore(today)) {
                for (Policy policy : expirySortedPolicies.get(expiryDate)) {
                    policyMap.remove(policy.policyNumber);
                    orderedPolicies.remove(policy.policyNumber);
                }
                iterator.remove();
            } else {
                break;
            }
        }
    }

    public void displayAllPolicies() {
        for (Policy policy : orderedPolicies.values()) {
            System.out.println(policy);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        InsurancePolicySystem system = new InsurancePolicySystem();

        system.addPolicy(new Policy("P1001", "Alice", LocalDate.now().plusDays(10), "Health", 500));
        system.addPolicy(new Policy("P1002", "Bob", LocalDate.now().plusDays(40), "Auto", 300));
        system.addPolicy(new Policy("P1003", "Alice", LocalDate.now().minusDays(5), "Home", 700));

        System.out.println("Retrieve Policy P1001:");
        System.out.println(system.getPolicyByNumber("P1001"));

        System.out.println("\nPolicies Expiring Within 30 Days:");
        system.getPoliciesExpiringSoon(30).forEach(System.out::println);

        System.out.println("\nPolicies for Alice:");
        system.getPoliciesByHolder("Alice").forEach(System.out::println);

        System.out.println("\nRemoving Expired Policies...");
        system.removeExpiredPolicies();

        System.out.println("\nAll Policies After Removal:");
        system.displayAllPolicies();
    }
}

