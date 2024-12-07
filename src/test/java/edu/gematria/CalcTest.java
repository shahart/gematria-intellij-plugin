package edu.gematria;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalcTest {

    @Test
    public void testCalc() {
        String str = "אבגדהוזחטי";
        assertEquals((1+10)*10/2, Calc.calc(str));

        str = "יכלמנסעפצק";
        assertEquals((10+100)*10/2, Calc.calc(str));
    }


}