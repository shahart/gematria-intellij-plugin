package junit.framework;

import java.lang.reflect.Method;

/**
 * Created by IntelliJ IDEA.
 * User: talshah
 * Date: 07/06/2010
 */
public class MyTestCase { // TODO simplify usage, distinguish assertError vs. Application internal error (are we on our own Error (myJunit error) or neither)

    private Object obj;

    public MyTestCase() {
        obj = null;
    }

    public MyTestCase(Class clz) {
        try {
            obj = clz.newInstance();
//            System.out.println("testing class " + name.getName());
        }
        catch (Exception e) {
            e.printStackTrace();
            obj = null;
        }
    }

    protected void setUp() {}
    protected void tearDown() {}

    public static void assertTrue(boolean condition) {
        if (! condition)
            throw new Error("myJUnit - AssertionFailedError");
    }

    public static void assertEquals(int expected, int actual) {
        if (expected != actual)
            throw new Error("myJUnit - expected <" + expected + "> but was <" + actual + ">");
    }

    public int runTests() {
        int tests = 0;
        int passed = 0;
        long time = 0;

        for (Method runMethod: obj.getClass().getDeclaredMethods()) {
            if (runMethod.getName().startsWith("test") && runMethod.getParameterTypes().length == 0 && runMethod.getReturnType().equals(Void.TYPE)) // && Modifier.isPublic(m.getModifiers())
                try {
                    tests++;
//                    System.out.println("\ntesting method " + runMethod.getName());
                    setUp();
                    time = System.currentTimeMillis();
                    runMethod.invoke(obj, new Object[0]);
                    passed ++;
                }
                catch (Throwable t) {
//                    t.fillInStackTrace();
                    System.err.println(obj.getClass().getName() + "." + runMethod.getName() + " failed.");
                    t.printStackTrace();
                }
                finally {
                    tearDown();
                    System.out.println("time for " + runMethod.getName() +": " + (System.currentTimeMillis() - time));
                }
        }

        System.out.println("\n--------------------------");
        System.out.println("tests for " + obj.getClass().getName() + ": " + tests);
        System.out.println("passed: " + passed);

        return tests - passed;
    }


}
