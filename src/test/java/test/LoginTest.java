package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.LoginPO;

public class LoginTest extends BaseTest{
    private static LoginPO loginPage;

    @BeforeAll
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
    }

    @Test
    public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios(){
        loginPage.executarAcaoDeLogar("", "");

        String mensagem = loginPage.obterMensagemSpan();

        Assertions.assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazia(){
        loginPage.executarAcaoDeLogar("teste", "");

        String mensagem = loginPage.obterMensagemSpan();

        Assertions.assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC003_naoDeveLogarNoSistemaComEmailVazioESenhaIncorreta(){
        loginPage.executarAcaoDeLogar("", "teste");

        String mensagem = loginPage.obterMensagemSpan();

        Assertions.assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC004_naoDeveLogarNoSistemaComEmailIncorretoESenhaIncorreta(){
        loginPage.executarAcaoDeLogar("teste", "teste");

        String mensagem = loginPage.obterMensagemSpan();

        Assertions.assertEquals(mensagem, "E-mail ou senha inválidos");
    }
}
