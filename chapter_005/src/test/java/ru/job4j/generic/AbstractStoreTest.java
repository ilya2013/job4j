package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AbstractStoreTest {

    @Test
    public void whenAddUserThenGetFindthatUser() {
        UserStore userStore = new UserStore(4);
        userStore.add(new User("10"));
        userStore.add(new User("10"));
        userStore.add(new User("11"));
        String expected = "10";
        User result = userStore.findById("10");
        assertThat(result.getId(), is(expected));
    }
    @Test
    public void whenAddRoleThenGetFindthatRole() {
        RoleStore roleStore = new RoleStore(4);
        roleStore.add(new Role("10"));
        roleStore.add(new Role("10"));
        roleStore.add(new Role("11"));
        String expected = "10";
        Role result = roleStore.findById("10");
        assertThat(result.getId(), is(expected));
    }

    @Test
    public void when3AddRoleAfterDelete2ThenGetFindStayedRole() {
        RoleStore roleStore = new RoleStore(4);
        Role role1 = new Role("10");
        Role role2 = new Role("10");
        Role role3 = new Role("11");
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.add(role3);
        roleStore.delete(role1.getId());
        roleStore.delete(role3.getId());
        String expected = "10";
        Base result = roleStore.findById("10");
        assertThat(result.getId(), is(expected));
    }

    @Test
    public void whenTryFindRoleWithUnexistingIdThenFalse() {
        RoleStore roleStore = new RoleStore(4);
        Role expected = null;
        Role role1 = new Role("10");
        Role role2 = null;
        Role role3 = new Role("11");
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.add(role3);
        Role result = roleStore.findById("12");
        assertThat(result, is(expected));
    }

    @Test (expected = TooManyElements.class)
    public void whenAddTooManyElements() {
        RoleStore roleStore = new RoleStore(2);
        Role expected = null;
        Role role1 = null;
        Role role2 = null;
        Role role3 = null;
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.delete(null);
        roleStore.add(role3);
    }

    @Test
    public void whenReplaceElementThenOnThePlaceOfOldOneWillBeNewOne() {
        RoleStore roleStore = new RoleStore(23);
        Role expected = null;
        Role role1 = new Role("10");
        Role role2 = null;
        Role role3 = new Role("11");
        Role role4 = new Role("13");
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.add(role3);
        roleStore.replace("11", role4);
        assertThat(roleStore.findById("13"), is(role4));
    }
    @Test
    public void whenReplaceUnexistingElementThenFalse() {
        RoleStore roleStore = new RoleStore(23);
        boolean expected = false;
        Role role1 = new Role("10");
        Role role2 = new Role("13");
        roleStore.add(role1);
        assertThat(roleStore.replace("11", role2), is(expected));
    }


    @Test
    public void whenDeleteUnexistingElementThenFalse() {
        RoleStore roleStore = new RoleStore(23);
        boolean expected = false;
        Role role1 = new Role("10");
        roleStore.add(role1);
        assertThat(roleStore.delete("11"), is(expected));
    }

    @Test
    public void whenDeleteExistingElementThenTrue() {
        RoleStore roleStore = new RoleStore(23);
        boolean expected = true;
        Role role1 = new Role("10");
        roleStore.add(role1);
        assertThat(roleStore.delete("10"), is(expected));
    }
}