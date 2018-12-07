package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Calculate task class test.
 * @author Ilya B 
 * @version 1
 * @since 06.12.18
 */
public class CalculateTest {
    /**
     * Test echo.
     */

    @Test
    public void whenAddOnePlusOneThenTwo() {
        double num1 = 1.0d;
        double num2 = 1.0d;
        double expect = 2.0d;
        Calculate calc = new Calculate();
        calc.add(num1, num2);
        double result = calc.getResult();
        assertThat(result, is(expect));
    }

    @Test
    public void whenSubstractTwoMinusOneThenOne() {
        double num1 = 2.0d;
        double num2 = 1.0d;
        double expect = 1.0d;
        Calculate calc = new Calculate();
        calc.subtract(num1, num2);
        double result = calc.getResult();
        assertThat(result, is(expect));
    }
    @Test
    public void whenDivTwoOnTwoThenOne() {
        double num1 = 2.0d;
        double num2 = 2.0d;
        double expect = 1.0d;
        Calculate calc = new Calculate();
        calc.div(num1, num2);
        double result = calc.getResult();
        assertThat(result, is(expect));
    }

    @Test
    public void whenMultiplyTwoOnOneThenTwo() {
        double num1 = 2.0d;
        double num2 = 1.0d;
        double expect = 2.0d;
        Calculate calc = new Calculate();
        calc.multiply(num1, num2);
        double result = calc.getResult();
        assertThat(result, is(expect));
    }
}