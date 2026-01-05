package edu.gematria

import org.junit.Assert
import org.junit.Test

class CalcKtTest {

    @Test
    fun testCalcKt() {
        var str = "אבגדהוזחטי"
        Assert.assertEquals(((1 + 10) * 10 / 2).toLong(), CalcKt.calc(str).toLong())

        str = "יכלמנסעפצק"
        Assert.assertEquals(((10 + 100) * 10 / 2).toLong(), CalcKt.calc(str).toLong())

        Assert.assertEquals(((10 + 100) * 10 / 2).toLong(), edu.gematria.Calc.calc(str).toLong()) // from Artifactory

        Assert.assertEquals(((10 + 100) * 10 / 2).toLong(), Calc.calc(str).toLong())

    }
}