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

    public String getCoverageType() {
        return coverageType;
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

    public void displayAllPolicies() {
        System.out.println("All Unique Policies:");
        hashSetPolicies.forEach(System.out::println);
    }

    public void displayExpiringSoon() {
        System.out.println("\nPolicies Expiring Within 30 Days:");
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        Date thresholdDate = calendar.getTime();

        treeSetPolicies.stream()
                .filter(p -> p.getExpiryDate().before(thresholdDate))
                .forEach(System.out::println);
    }

    public void displayByCoverageType(String coverageType) {
        System.out.println("\nPolicies with Coverage Type: " + coverageType);
        hashSetPolicies.stream()
                .filter(p -> p.getCoverageType().equalsIgnoreCase(coverageType))
                .forEach(System.out::println);
    }

    public void findDuplicatePolicies() {
        System.out.println("\nDuplicate Policies Based on Policy Numbers:");
        Set<String> seenPolicyNumbers = new HashSet<>();
        Set<InsurancePolicy> duplicates = new HashSet<>();
        for (InsurancePolicy policy : linkedHashSetPolicies) {
            if (!seenPolicyNumbers.add(policy.getPolicyNumber())) {
                duplicates.add(policy);
            }
        }
        duplicates.forEach(System.out::println);
    }

    public void comparePerformance() {
        List<InsurancePolicy> policies = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            policies.add(new InsurancePolicy("P" + i, "Holder" + i, new Date(), "Auto", i * 100));
        }

        System.out.println("\nPerformance Comparison:");

        long start = System.nanoTime();
        Set<InsurancePolicy> hashSet = new HashSet<>(policies);
        long end = System.nanoTime();
        System.out.println("HashSet Add Time: " + (end - start) + " ns");

        start = System.nanoTime();
        Set<InsurancePolicy> linkedHashSet = new LinkedHashSet<>(policies);
        end = System.nanoTime();
        System.out.println("LinkedHashSet Add Time: " + (end - start) + " ns");

        start = System.nanoTime();
        Set<InsurancePolicy> treeSet = new TreeSet<>(policies);
        end = System.nanoTime();
        System.out.println("TreeSet Add Time: " + (end - start) + " ns");

        start = System.nanoTime();
        hashSet.contains(policies.get(5000));
        end = System.nanoTime();
        System.out.println("HashSet Search Time: " + (end - start) + " ns");

        start = System.nanoTime();
        linkedHashSet.contains(policies.get(5000));
        end = System.nanoTime();
        System.out.println("LinkedHashSet Search Time: " + (end - start) + " ns");

        start = System.nanoTime();
        treeSet.contains(policies.get(5000));
        end = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (end - start) + " ns");
    }

    public static void main(String[] args) {
        InsurancePolicyManagement manager = new InsurancePolicyManagement();

        manager.addPolicy(new InsurancePolicy("P1001", "Alice", new GregorianCalendar(2025, Calendar.MARCH, 15).getTime(), "Health", 500.0));
        manager.addPolicy(new InsurancePolicy("P1002", "Bob", new GregorianCalendar(2024, Calendar.JUNE, 10).getTime(), "Auto", 800.0));
        manager.addPolicy(new InsurancePolicy("P1003", "Charlie", new GregorianCalendar(2026, Calendar.JANUARY, 5).getTime(), "Home", 1200.0));
        manager.addPolicy(new InsurancePolicy("P1002", "David", new GregorianCalendar(2024, Calendar.JUNE, 10).getTime(), "Auto", 900.0)); // Duplicate Policy Number

        manager.displayAllPolicies();
        manager.displayExpiringSoon();
        manager.displayByCoverageType("Auto");
        manager.findDuplicatePolicies();
        manager.comparePerformance();
    }
}

