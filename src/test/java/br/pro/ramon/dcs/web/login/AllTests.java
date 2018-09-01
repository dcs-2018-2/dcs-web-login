package br.pro.ramon.dcs.web.login;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    br.pro.ramon.dcs.web.login.LoginServiceTest.class,
    br.pro.ramon.dcs.web.login.LoginServletTest.class,
    br.pro.ramon.dcs.web.login.LoginFormTest.class
})
public class AllTests {
}
