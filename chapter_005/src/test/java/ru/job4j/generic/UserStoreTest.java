package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserStoreTest {

    @Test
    public void whenAddUserThenGetFindthatUser() throws TooManyElements {
        UserStore userStore = new UserStore(4);
        userStore.add(new User("10"));
        userStore.add(new User("10"));
        userStore.add(new User("11"));
        String expected = "10";
        User result = (User) userStore.findById("10");
        assertThat(result.getId(), is(expected));
    }

    @Test
    public void whenAddRoleThenGetFindthatRole() throws TooManyElements {
        RoleStore roleStore = new RoleStore(4);
        roleStore.add(new Role("10"));
        roleStore.add(new Role("10"));
        roleStore.add(new Role("11"));
        String expected = "10";
        Role result = (Role) roleStore.findById("10");
        assertThat(result.getId(), is(expected));
    }

    @Test
    public void when3AddRoleAfterDelete2ThenGetFindStayedRole() throws TooManyElements {
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
    public void whenAddRoleThenGetF3indthatRole() throws TooManyElements {
        RoleStore roleStore = new RoleStore(4);
        roleStore.add(new User("10"));
    }
}