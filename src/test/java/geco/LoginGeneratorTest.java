
package geco;

import org.junit.Test;


import static org.junit.Assert.*;

public class LoginGeneratorTest {


    public LoginGenerator initialize(){
        LoginService loginService = new LoginService(new String[]{"JROL", "BPER", "CGUR", "JDUP", "JRAL", "JRAL1"});
        LoginGenerator loginGenerator = new LoginGenerator(loginService);
        return loginGenerator;
    }

    @Test
    public void generateLoginForNomAndPrenom() throws Exception {
        LoginGenerator loginGenerator = initialize();
        String login = loginGenerator.generateLoginForNomAndPrenom("Durand", "Paul");
        assertEquals("PDUR", login);
        loginGenerator = initialize();
        login = loginGenerator.generateLoginForNomAndPrenom("Rolling", "Jean");
        assertEquals("JROL1", login);
        loginGenerator = initialize();
        login = loginGenerator.generateLoginForNomAndPrenom("Dùrand", "Paul");
        assertEquals("PDUR", login);
    }

    @Test
    public void generateLoginForSameNomAndPrenom() throws Exception {
        LoginGenerator loginGenerator = initialize();
        String login = loginGenerator.generateLoginForNomAndPrenom("Ralling", "John");
        assertEquals("JRAL2", login);
    }

}
