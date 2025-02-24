import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class Software {
    @BugReport(description = "Null pointer exception in edge cases")
    @BugReport(description = "Memory leak when handling large inputs")
    public void process() {
        System.out.println("Processing data...");
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Method method = Software.class.getMethod("process");

        if (method.isAnnotationPresent(BugReports.class)) {
            BugReports bugReports = method.getAnnotation(BugReports.class);
            for (BugReport bug : bugReports.value()) {
                System.out.println("Bug: " + bug.description());
            }
        }
    }
}

