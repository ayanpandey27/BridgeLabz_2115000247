import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class User {
    private String role;

    public User(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

class SecureService {
    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Admin task executed.");
    }

    @RoleAllowed("USER")
    public void userTask() {
        System.out.println("User task executed.");
    }

    public void executeTask(User user, String methodName) {
        try {
            Method method = this.getClass().getMethod(methodName);
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                String requiredRole = method.getAnnotation(RoleAllowed.class).value();
                if (user.getRole().equals(requiredRole)) {
                    method.invoke(this);
                } else {
                    System.out.println("Access Denied!");
                }
            } else {
                method.invoke(this);
            }
        } catch (Exception e) {
            System.out.println("Error executing method: " + e.getMessage());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SecureService service = new SecureService();
        User admin = new User("ADMIN");
        User normalUser = new User("USER");

        System.out.println("Admin trying to execute adminTask:");
        service.executeTask(admin, "adminTask");

        System.out.println("\nUser trying to execute adminTask:");
        service.executeTask(normalUser, "adminTask");

        System.out.println("\nUser trying to execute userTask:");
        service.executeTask(normalUser, "userTask");
    }
}

