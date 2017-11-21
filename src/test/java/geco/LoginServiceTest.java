package geco;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LoginServiceTest {

    String[] loginsString = {"login1", "login2", "login3", "login4", "login5"};
    LoginService logins = new LoginService(loginsString);

    @Test
    public void loginExists() throws Exception {
        assertTrue(logins.loginExists("login1"));
        assertTrue(logins.loginExists("login2"));
        assertTrue(logins.loginExists("login3"));
        assertTrue(logins.loginExists("login4"));
        assertTrue(logins.loginExists("login5"));
        assertFalse(logins.loginExists("login6"));
    }

    @Test
    public void addLogin() throws Exception {
        assertFalse(logins.loginExists("login6"));
        logins.addLogin("login6");
        assertTrue(logins.loginExists("login6"));
    }

    @Test
    public void findAllLoginsStartingWith() throws Exception {
        logins.addLogin("Log1");
        logins.addLogin("Log2");
        logins.addLogin("Log3");
        List<String> loginsList = new ArrayList<String>();
        loginsList = logins.findAllLoginsStartingWith("Log");
        assertTrue(loginsList.size() == 3);
        for (int i = 0; i < 3; i++){
            int loginNum = i + 1;
            assertTrue(loginsList.get(i).equals("Log" + loginNum));
        }

    }

    @Test
    public void findAllLogins() throws Exception {
        List<String> loginsList= new ArrayList<String>();
        loginsList = logins.findAllLogins();
        for (int i = 0; i < loginsList.size(); i++)
            assertTrue(loginsList.get(i).equals(loginsString[i]));
    }

}
