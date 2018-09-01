package br.pro.ramon.dcs.web.login;

import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import static org.junit.Assert.*;
import org.junit.Test;

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

    private String acessaServletPelolNavegador(String login, String senha) throws IOException {
        Document html = Jsoup.connect("http://localhost:8084/dcs-web-login/login")
                .data("login", login)
                .data("senha", senha)
                .post();

        String saida = html.body().text();

        return saida;
    }

}
