import java.util.HashSet;
import java.util.Set;

public class OTPGenerator {

    // Method to generate a 6-digit OTP number
    public static int generateOTP() {
        // Generate a 6-digit number using Math.random()
        return (int) (Math.random() * 900000) + 100000;
    }

    // Method to validate if all OTPs generated are unique
    public static boolean areOTPsUnique(int[] otps) {
        // Create a Set to store unique OTPs
        Set<Integer> otpSet = new HashSet<>();
        
        for (int otp : otps) {
            // If OTP already exists in Set, return false
            if (!otpSet.add(otp)) {
                return false;
            }
        }
        
        // If all OTPs were unique, return true
        return true;
    }

    public static void main(String[] args) {
        // Create an array to hold 10 OTPs
        int[] otps = new int[10];

        // Generate 10 OTP numbers and store them in the array
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
        }

        // Print the generated OTPs
        System.out.println("Generated OTPs:");
        for (int otp : otps) {
            System.out.println(otp);
        }

        // Check if the OTPs are unique
        if (areOTPsUnique(otps)) {
            System.out.println("All OTPs are unique.");
        } else {
            System.out.println("Some OTPs are duplicated.");
        }
    }
}

