package at.sw2017.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CalculatorUnitTest {

    @Test
    public void testDoAddition() throws Exception {
        int result = Calculations.doAddition(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testDoSubtraction() throws Exception {
        int result = Calculations.doSubtraction(7, 2);
        assertEquals(5, result);
    }

    @Test
    public void testDoMultiplication() throws Exception {
        int result = Calculations.doMultiplication(2, 3);
        assertEquals(6, result);
    }

    @Test
    public void testDoDivision() throws Exception {
        int result = Calculations.doDivision(8, 4);
        assertEquals(2, result);
    }

    @Test
    public void testDoDivision1() throws Exception {
        int result = Calculations.doDivision(8, 0);
        assertEquals(0, result);
    }

    @Test
    public void testDoDivision2() throws Exception {
        int result = Calculations.doDivision(11, 4);
        assertEquals(2, result);
    }
}