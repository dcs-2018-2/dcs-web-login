package br.pro.ramon.dcs.web.login;

import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginServiceTest {

    @Test
    public void testLoginAutorizado() throws IOException {
        String login = "admin";
        String senha = "r**t";

        LoginService svc = new LoginService();
        boolean autorizado = svc.isAutorizado(login, senha);

        assertThat(autorizado, is(true));
    }

    @Test
    public void testLoginErrado() throws IOException {
        String login = "usuario";
        String senha = "r**t";

        LoginService svc = new LoginService();
        boolean autorizado = svc.isAutorizado(login, senha);

        assertThat(autorizado, is(false));
    }

    @Test
    public void testSenhaErrada() throws IOException {
        String login = "admin";
        String senha = "123456";

        LoginService svc = new LoginService();
        boolean autorizado = svc.isAutorizado(login, senha);

        assertThat(autorizado, is(false));
    }

    @Test
    public void testLoginESenhaErrados() throws IOException {
        String login = "usuario";
        String senha = "123456";

        LoginService svc = new LoginService();
        boolean autorizado = svc.isAutorizado(login, senha);

        assertThat(autorizado, is(false));
    }

}
