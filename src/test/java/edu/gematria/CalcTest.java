package edu.gematria;

//import junit.framework.TestCase;
import junit.framework.MyTestCase;
//import org.apache.log4j.BasicConfigurator;

public class CalcTest extends MyTestCase {

    public static void main(String[] s) {
        new MyTestCase(CalcTest.class).runTests();
    }

    public void testCalc() {
        String str = "אבגדהוזחטי";
        assertEquals((1+10)*10/2, Calc.calc(str));

        str = "יכלמנסעפצק";
        assertEquals((10+100)*10/2, Calc.calc(str));
    }

    public void setUp() {
//        BasicConfigurator.configure();
    }

}