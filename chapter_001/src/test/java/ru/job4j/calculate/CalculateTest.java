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
    public void whenTakeNameThenEchoPlusName() {
        String input = "Ilya B";
        String expect = "Echo, echo, echo : Ilya B";
        Calculate calc = new Calculate();
        String result = calc.echo(input);
        assertThat(result, is(expect));
    }

}