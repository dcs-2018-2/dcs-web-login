package br.pro.ramon.dcs.web.login;

import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginFormTest {

    @Test
    public void testForm() throws IOException {
        Document html = Jsoup.connect("http://localhost:8084/dcs-web-login/index.html").get();

        Elements forms = html.getElementsByTag("form");

        Element form = forms.get(0);
        assertThat(form.attr("action"), is("login"));
        assertThat(form.attr("method"), is("POST"));

        Elements labels = form.getElementsByTag("label");
        Elements inputs = form.getElementsByTag("input");

        Element loginLabel = labels.get(0);
        assertThat(loginLabel.attr("for"), is("login"));
        assertThat(loginLabel.text(), is("Login"));

        Element loginInput = inputs.get(0);
        assertThat(loginInput.attr("type"), is("text"));
        assertThat(loginInput.attr("id"), is("login"));
        assertThat(loginInput.attr("name"), is("login"));

        Element senhaLabel = labels.get(1);
        assertThat(senhaLabel.attr("for"), is("senha"));
        assertThat(senhaLabel.text(), is("Senha"));

        Element senhaInput = inputs.get(1);
        assertThat(senhaInput.attr("type"), is("password"));
        assertThat(senhaInput.attr("id"), is("senha"));
        assertThat(senhaInput.attr("name"), is("senha"));

        Element loginButton = inputs.get(2);
        assertThat(loginButton.attr("type"), is("submit"));
    }

}
