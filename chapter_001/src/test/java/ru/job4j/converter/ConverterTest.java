package ru.job4j.converter;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Currency convert task class test.
 * @author Ilya B
 * @version 1
 * @since 06.12.18
 */
public class ConverterTest {
  @Test
  public void whenConvert76RubbleToEuroThenOneEuro() {
      int rub = 76;
      int expect = 1;
      int result;
      Converter conv = new Converter();
      result = conv.rubToEuro(rub);
      assertThat(result, is(expect));
  }

    @Test
    public void whenConvertOneEuroToRubThen76Rub() {
        int euro = 1;
        int expect = 76;
        int result;
        Converter conv = new Converter();
        result = conv.euroToRub(euro);
        assertThat(result, is(expect));
    }

    @Test
    public void whenConvert66RubbleToDollarThenOneDollar() {
        int rub = 66;
        int expect = 1;
        int result;
        Converter conv = new Converter();
        result = conv.rubToDollar(rub);
        assertThat(result, is(expect));
    }

    @Test
    public void whenConvertOneDollarToRubThen66Rub() {
        int dollar = 1;
        int expect = 66;
        int result;
        Converter conv = new Converter();
        result = conv.dollarToRub(dollar);
        assertThat(result, is(expect));
    }

}
