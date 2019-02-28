package ru.job4j.stream;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import static org.junit.Assert.*;

public class ProfileTest {

    @Test
    public void collect() {
        Address address1 = new Address("Москва");
        Address address2 = new Address("СПб");
        Address address3 = new Address("Тула");
        List<Profile> profiles = Arrays.asList(new Profile(address1),
                new Profile(address2),
                new Profile(address3));
        List<Address> result = new Profile(address1).collect(profiles);
        List<Address> expected = Arrays.asList(address1,
                address2,
                address3);
        assertThat(result, is(expected));
    }

    @Test
    public void collectDistinctAddresses() {
        Address address1 = new Address("Москва");
        Address address2 = new Address("СПб");
        Address address3 = new Address("Тула");
        Address address4 = new Address("Тула");
        List<Profile> profiles = Arrays.asList(new Profile(address1),
                new Profile(address2),
                new Profile(address3),
                new Profile(address4));
        List<Address> result = new Profile(address1).collect(profiles);
        List<Address> expected = Arrays.asList(address1,
                address2,
                address3);
        assertThat(result, is(expected));
    }

}