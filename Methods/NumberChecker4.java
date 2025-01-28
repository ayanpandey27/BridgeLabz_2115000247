public class NumberChecker {

    public static int[] findFactors(int number) {
        int[] factors = new int[number]; 
        int count = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                factors[count++] = i;
            }
        }
        int[] result = new int[count];
        System.arraycopy(factors, 0, result, 0, count);
        return result;
    }

    public static int findGreatestFactor(int number) {
        int[] factors = findFactors(number);
        int greatest = factors[0];
        for (int factor : factors) {
            if (factor > greatest) {
                greatest = factor;
            }
        }
        return greatest;
    }

    public static int findSumOfFactors(int number) {
        int[] factors = findFactors(number);
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    public static int findProductOfFactors(int number) {
        int[] factors = findFactors(number);
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    public static double findProductOfCubeOfFactors(int number) {
        int[] factors = findFactors(number);
        double product = 1;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
    }

    public static boolean isPerfectNumber(int number) {
        int sum = findSumOfFactors(number);
        return sum == number;
    }

    public static boolean isAbundantNumber(int number) {
        int sum = findSumOfFactors(number);
        return sum > number;
    }

    public static boolean isDeficientNumber(int number) {
        int sum = findSumOfFactors(number);
        return sum < number;
    }

    public static boolean isStrongNumber(int number) {
        int temp = number;
        int sum = 0;
        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == number;
    }

    public static int factorial(int number) {
        int fact = 1;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        int number = 28;
        int number2 = 12;
        int number3 = 6;
        int number4 = 145;

        System.out.println("Factors of " + number + ": ");
        for (int factor : findFactors(number)) {
            System.out.print(factor + " ");
        }

        System.out.println("\nGreatest factor of " + number + ": " + findGreatestFactor(number));
        System.out.println("Sum of factors of " + number + ": " + findSumOfFactors(number));
        System.out.println("Product of factors of " + number + ": " + findProductOfFactors(number));
        System.out.println("Product of cubes of factors of " + number + ": " + findProductOfCubeOfFactors(number));

        System.out.println("\nIs " + number + " a perfect number? " + isPerfectNumber(number));
        System.out.println("Is " + number2 + " an abundant number? " + isAbundantNumber(number2));
        System.out.println("Is " + number3 + " a deficient number? " + isDeficientNumber(number3));
        System.out.println("Is " + number4 + " a strong number? " + isStrongNumber(number4));
    }
}

