package kr.ac.jejnu.user;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.in;
import static org.hamcrest.core.Is.is;


public class UserDaoTests {
    @Test
    public void getJeju() throws SQLException, ClassNotFoundException {
        Long id = 1l;
        String name = "abc";
        String password = "1234";

        UserDao userDao = new JejuUserDao();
        User user = userDao.get(id);

        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void insertJeju() throws SQLException, ClassNotFoundException {
        String name = "Aiden";
        String password = "1234";
        User user = new User();
        user.setName(name);
        user.setPassword(password);

        UserDao userDao = new JejuUserDao();
        userDao.insert(user);

        assertThat(user.getId(), greaterThan(1l));

        User insertedUser = userDao.get(user.getId());
        assertThat(insertedUser.getName(), is(name));
        assertThat(insertedUser.getPassword(), is(password));
    }

    @Test
    public void getHalla() throws SQLException, ClassNotFoundException {
        Long id = 1l;
        String name = "abc";
        String password = "1234";

        UserDao userDao = new HallaUserDao();
        User user = userDao.get(id);

        assertThat(user.getId(), is(id));
        assertThat(user.getName(), is(name));
        assertThat(user.getPassword(), is(password));
    }

    @Test
    public void insertHalla() throws SQLException, ClassNotFoundException {
        String name = "Aiden";
        String password = "1234";
        User user = new User();
        user.setName(name);
        user.setPassword(password);

        UserDao userDao = new HallaUserDao();
        userDao.insert(user);

        assertThat(user.getId(), greaterThan(1l));

        User insertedUser = userDao.get(user.getId());
        assertThat(insertedUser.getName(), is(name));
        assertThat(insertedUser.getPassword(), is(password));
    }
}
