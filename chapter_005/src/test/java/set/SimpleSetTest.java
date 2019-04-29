package set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {

    @Test
    public void add1StringElementThenGet1() {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add("1");
        simpleSet.add("1");
        Iterator iterator = simpleSet.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("1"));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void whenAdd1And1And2ThenGet1And2() {
        SimpleSet<Integer> simpleSet = new SimpleSet<Integer>();
        simpleSet.add(1);
        simpleSet.add(1);
        simpleSet.add(2);
        Iterator iterator = simpleSet.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void thenOnly1ThenGet1() {
        SimpleSet<Integer> simpleSet = new SimpleSet<Integer>();
        simpleSet.add(1);
        simpleSet.add(1);
        simpleSet.add(1);
        simpleSet.add(1);
        Iterator iterator = simpleSet.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void add5AndNullAnd7ThenGet5Null7() {
        SimpleSet<Integer> simpleSet = new SimpleSet<Integer>();
        simpleSet.add(5);
        simpleSet.add(null);
        simpleSet.add(7);
        Iterator iterator = simpleSet.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(5));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(nullValue()));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(7));
        assertThat(iterator.hasNext(), is(false));
    }
}

