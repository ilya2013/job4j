package set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {

    @Test
    public void add() {
        SimpleSet<Integer> simpleSet = new SimpleSet<Integer>();
        simpleSet.add(1);
        simpleSet.add(1);
        Iterator iterator = simpleSet.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next().toString(), is("1"));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void add2() {
        SimpleSet<Integer> simpleSet = new SimpleSet<Integer>();
        simpleSet.add(1);
        simpleSet.add(1);
        simpleSet.add(2);
        Iterator iterator = simpleSet.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next().toString(), is("2"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next().toString(), is("1"));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void add3() {
        SimpleSet<Integer> simpleSet = new SimpleSet<Integer>();
        simpleSet.add(1);
        simpleSet.add(1);
        simpleSet.add(1);
        simpleSet.add(1);
        Iterator iterator = simpleSet.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next().toString(), is("1"));
        assertThat(iterator.hasNext(), is(false));
    }
    }

