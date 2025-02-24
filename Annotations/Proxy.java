import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// Step 1: Define an interface
interface Greeting {
    void sayHello();
    void sayGoodbye();
}

// Step 2: Implement the interface
class GreetingImpl implements Greeting {
    public void sayHello() {
        System.out.println("Hello, World!");
    }

    public void sayGoodbye() {
        System.out.println("Goodbye, see you soon!");
    }
}

// Step 3: Create a Logging Proxy
class LoggingProxy implements InvocationHandler {
    private final Object target;

    public LoggingProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoking method: " + method.getName());
        return method.invoke(target, args);
    }

    public static <T> T createProxy(T target, Class<T> interfaceType) {
        return (T) Proxy.newProxyInstance(
                interfaceType.getClassLoader(),
                new Class<?>[]{interfaceType},
                new LoggingProxy(target)
        );
    }
}

// Step 4: Test the proxy
public class DynamicProxyDemo {
    public static void main(String[] args) {
        Greeting greeting = LoggingProxy.createProxy(new GreetingImpl(), Greeting.class);
        greeting.sayHello();
        greeting.sayGoodbye();
    }
}

