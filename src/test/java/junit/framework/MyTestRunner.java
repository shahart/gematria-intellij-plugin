package junit.framework;

import edu.gematria.CalcTest;

/**
 * Created by IntelliJ IDEA.
 * User: talshah
 * Date: 07/06/2010
 * To change this template use File | Settings | File Templates.
 */
public class MyTestRunner {
    public static void main(String[] s) {
        int failed = 0;
        long time = System.currentTimeMillis();

        failed += new MyTestCase(CalcTest.class).runTests();

        System.out.println("\n--------------------------");
        System.out.println("total failed: " + failed);
        System.out.println("total time: [msec] " + (System.currentTimeMillis() - time));
    }
}
