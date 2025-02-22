import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.*;
import java.util.*;

//  Banking Transactions
class BankAccountTest {
    @Test
    void testDeposit() {
        double balance = 100.0 + 50.0;
        assertEquals(150.0, balance);
    }

    @Test
    void testWithdraw() {
        double balance = 100.0 - 50.0;
        assertEquals(50.0, balance);
    }

    @Test
    void testWithdrawInsufficientFunds() {
        double balance = 100.0;
        assertThrows(IllegalArgumentException.class, () -> {
            if (balance < 200.0) throw new IllegalArgumentException("Insufficient funds");
        });
    }
}

// Password Strength Validator
class PasswordValidatorTest {
    @Test
    void testValidPassword() {
        String password = "StrongP@ss1";
        boolean isValid = password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*");
        assertTrue(isValid);
    }

    @Test
    void testInvalidPassword() {
        String password = "weak";
        boolean isValid = password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*");
        assertFalse(isValid);
    }
}

//  Temperature Converter
class TemperatureConverterTest {
    @Test
    void testCelsiusToFahrenheit() {
        double fahrenheit = (25.0 * 9/5) + 32;
        assertEquals(77.0, fahrenheit);
    }

    @Test
    void testFahrenheitToCelsius() {
        double celsius = (98.6 - 32) * 5/9;
        assertEquals(37.0, celsius, 0.1);
    }
}

//  Date Formatter
class DateFormatterTest {
    @Test
    void testValidDateFormat() {
        String inputDate = "2024-02-22";
        String formattedDate = inputDate.replaceAll("(\\d{4})-(\\d{2})-(\\d{2})", "$3-$2-$1");
        assertEquals("22-02-2024", formattedDate);
    }

    @Test
    void testInvalidDateFormat() {
        String inputDate = "22-02-2024";
        boolean isValid = inputDate.matches("\\d{4}-\\d{2}-\\d{2}");
        assertFalse(isValid);
    }
}

//  User Registration
class UserRegistrationTest {
    @Test
    void testValidRegistration() {
        String username = "user123";
        String email = "user@example.com";
        String password = "Password1";
        boolean isValid = email.contains("@") && password.length() >= 8;
        assertTrue(isValid);
    }

    @Test
    void testInvalidRegistration() {
        String username = "user123";
        String email = "invalid-email";
        String password = "pass";
        assertThrows(IllegalArgumentException.class, () -> {
            if (!email.contains("@") || password.length() < 8) {
                throw new IllegalArgumentException("Invalid registration");
            }
        });
    }
}
