package ru.job4j.condition;

import org.junit.Test;
import ru.job4j.calculator.Fit;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void whenOneOnePoint1AndZeroZeroPont2When14() {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(0, 0);
        double distance = point1.distanceTo(point2);
        assertThat(distance, closeTo(1.4, 0.1));
    }
}