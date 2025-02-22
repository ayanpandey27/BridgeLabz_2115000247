import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.*;
import java.util.*;

// Calculator Class and Tests
class CalculatorTest {
    @Test
    void testAdd() {
        int result = 2 + 3;
        assertEquals(5, result);
    }

    @Test
    void testSubtract() {
        int result = 3 - 2;
        assertEquals(1, result);
    }

    @Test
    void testMultiply() {
        int result = 2 * 3;
        assertEquals(6, result);
    }

    @Test
    void testDivide() {
        int result = 6 / 3;
        assertEquals(2, result);
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> { int result = 5 / 0; });
    }
}

// String Utility Methods
class StringUtilsTest {
    @Test
    void testReverse() {
        String result = new StringBuilder("abc").reverse().toString();
        assertEquals("cba", result);
    }

    @Test
    void testIsPalindrome() {
        boolean result = "madam".equalsIgnoreCase(new StringBuilder("madam").reverse().toString());
        assertTrue(result);
    }

    @Test
    void testToUpperCase() {
        String result = "hello".toUpperCase();
        assertEquals("HELLO", result);
    }
}

//  List Operations
class ListManagerTest {
    List<Integer> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
    }

    @Test
    void testAddElement() {
        list.add(5);
        assertTrue(list.contains(5));
    }

    @Test
    void testRemoveElement() {
        list.add(5);
        list.remove(Integer.valueOf(5));
        assertFalse(list.contains(5));
    }

    @Test
    void testGetSize() {
        list.add(1);
        list.add(2);
        assertEquals(2, list.size());
    }
}

//  Testing Exception Handling
class ExceptionHandlingTest {
    @Test
    void testDivideByZeroException() {
        assertThrows(ArithmeticException.class, () -> { int result = 10 / 0; });
    }
}

//  Database Connection Tests
class DatabaseConnectionTest {
    DatabaseConnection db;

    @BeforeEach
    void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    @AfterEach
    void tearDown() {
        db.disconnect();
    }

    @Test
    void testConnection() {
        assertNotNull(db);
    }
}

//  Parameterized Test
class NumberUtilsTest {
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 7, 9})
    void testIsEven(int number) {
        boolean result = number % 2 == 0;
        assertEquals(number % 2 == 0, result);
    }
}

// Performance Testing
class PerformanceTest {
    @Test
    @Timeout(2)
    void testLongRunningTask() {
        assertDoesNotThrow(() -> Thread.sleep(3000));
    }
}

//  File Handling Tests
class FileProcessorTest {
    static final String FILE_NAME = "testfile.txt";

    @Test
    void testWriteAndRead() throws IOException {
        FileWriter writer = new FileWriter(FILE_NAME);
        writer.write("Hello World");
        writer.close();

        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
        String result = reader.readLine();
        reader.close();

        assertEquals("Hello World", result);
    }

    @Test
    void testFileExists() throws IOException {
        FileWriter writer = new FileWriter(FILE_NAME);
        writer.write("test");
        writer.close();

        File file = new File(FILE_NAME);
        assertTrue(file.exists());
    }

    @Test
    void testFileNotFoundException() {
        assertThrows(IOException.class, () -> {
            BufferedReader reader = new BufferedReader(new FileReader("nonexistent.txt"));
            reader.readLine();
        });
    }
}
