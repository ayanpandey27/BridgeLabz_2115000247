import java.lang.reflect.Method;

class PerformanceTest {
    public void fastMethod() {
        System.out.println("Fast method executed");
    }

    public void slowMethod() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {}
        System.out.println("Slow method executed");
    }
}

public class MethodExecutionTimer {
    public static void measureExecutionTime(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            long start = System.nanoTime();
            method.invoke(obj);
            long end = System.nanoTime();
            System.out.println("Execution Time: " + (end - start) / 1_000_000 + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        PerformanceTest test = new PerformanceTest();
        measureExecutionTime(test, "fastMethod");
        measureExecutionTime(test, "slowMethod");
    }
}

