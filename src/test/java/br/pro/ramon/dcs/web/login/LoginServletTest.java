package br.pro.ramon.dcs.web.login;

import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginServletTest {

    @Test
    public void testLoginAutorizado() throws IOException {
        String login = "admin";
        String senha = "r**t";

        String saida = acessaServletPelolNavegador(login, senha);

        assertThat(saida, is("Autorizado"));
    }

    @Test
    public void testLoginErrado() throws IOException {
        String login = "usuario";
        String senha = "r**t";

        String saida = acessaServletPelolNavegador(login, senha);

        assertThat(saida, is("Não Autorizado"));
    }

    @Test
    public void testSenhaErrada() throws IOException {
        String login = "admin";
        String senha = "123456";

        String saida = acessaServletPelolNavegador(login, senha);

        assertThat(saida, is("Não Autorizado"));
    }

    @Test
    public void testLoginESenhaErrados() throws IOException {
        String login = "usuario";
        String senha = "123456";

        String saida = acessaServletPelolNavegador(login, senha);

        assertThat(saida, is("Não Autorizado"));
    }

    public String acessaServletPelolNavegador(String login, String senha) throws IOException {
        String urlBase = "http://localhost:8084/dcs-web-login";
        String servlet = "/login";
        String url = urlBase + servlet;

        String saida = Jsoup.connect(url)
                .data("login", login)
                .data("senha", senha)
                .method(Method.POST)
                .execute()
                .charset("ISO-8859-1")
                .body();

        return saida;
    }

}
