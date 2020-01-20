import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCalculate {

    private Calculator calculator;

    @Before
    public void init(){
        calculator = new Calculator();
    }

    @Test
    public void emptyStringReturnsZero() throws Exception {
        assertEquals(calculator.calculate(""),0);
    }

    @Test
    public void singleValueIsReplied() throws Exception {
        assertEquals(calculator.calculate("1"),1);
    }

    @Test
    public void twoNumbersCommaDelimitedReturnSum() throws Exception {
        assertEquals(calculator.calculate("1,1"),2);
    }

    @Test
    public void twoNumbersNewLineDelimitedReturnSum() throws Exception {
        assertEquals(calculator.calculate("1\n1"),2);
    }

    @Test
    public void threeNumbersDelimitedEitherWayReturnSum() throws Exception {
        assertEquals(calculator.calculate("1,1,1"),3);
    }

    @Test(expected=Exception.class)
    public void negativeNumbersThrowAnException() throws Exception {
        calculator.calculate("-1");
    }


    @Test
    public void numbersGreaterThan1000AreIgnored() throws Exception{
        assertEquals(calculator.calculate("10,10,1001"),20);
    }
}
