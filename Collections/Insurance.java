import java.util.*;

class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InsurancePolicy policy = (InsurancePolicy) obj;
        return policyNumber.equals(policy.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return policyNumber + " - " + policyholderName + " - " + expiryDate + " - " + coverageType + " - $" + premiumAmount;
    }
}

public class InsurancePolicyManagement {
    private Set<InsurancePolicy> hashSetPolicies = new HashSet<>();
    private Set<InsurancePolicy> linkedHashSetPolicies = new LinkedHashSet<>();
    private Set<InsurancePolicy> treeSetPolicies = new TreeSet<>();

    public void addPolicy(InsurancePolicy policy) {
        hashSetPolicies.add(policy);
        linkedHashSetPolicies.add(policy);
        treeSetPolicies.add(policy);
    }

    public void displayPolicies() {
        System.out.println("HashSet (Unordered, Fast Lookups):");
        hashSetPolicies.forEach(System.out::println);

        System.out.println("\nLinkedHashSet (Insertion Order):");
        linkedHashSetPolicies.forEach(System.out::println);

        System.out.println("\nTreeSet (Sorted by Expiry Date):");
        treeSetPolicies.forEach(System.out::println);
    }

    public static void main(String[] args) {
        InsurancePolicyManagement manager = new InsurancePolicyManagement();

        manager.addPolicy(new InsurancePolicy("P1001", "Alice", new GregorianCalendar(2025, Calendar.MARCH, 15).getTime(), "Health", 500.0));
        manager.addPolicy(new InsurancePolicy("P1002", "Bob", new GregorianCalendar(2024, Calendar.JUNE, 10).getTime(), "Auto", 800.0));
        manager.addPolicy(new InsurancePolicy("P1003", "Charlie", new GregorianCalendar(2026, Calendar.JANUARY, 5).getTime(), "Home", 1200.0));

        manager.displayPolicies();
    }
}

