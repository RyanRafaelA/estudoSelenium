package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.LoginPO;

public class LoginTest extends BaseTest{
    private static LoginPO loginPage;

    @BeforeEach
    public void prepararTestes(){
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

    @Test
    public void TC005_naoDeveLogarNoSistemaComEmailCorretoESenhaIncorreta(){
        loginPage.executarAcaoDeLogar("admin@admin.com", "teste");

        String mensagem = loginPage.obterMensagemSpan();

        Assertions.assertEquals(mensagem, "E-mail ou senha inválidos");
    }

    @Test
    public void TC006_naoDeveLogarNoSistemaComEmailIncorretoESenhaCorreta(){
        loginPage.executarAcaoDeLogar("Aadmin@admin.com", "admin@123");

        String mensagem = loginPage.obterMensagemSpan();

        Assertions.assertEquals(mensagem, "E-mail ou senha inválidos");
    }

    @Test
    public void TC007_deveLogarNoSistemaComEmailESenhaCorretos(){
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        Assertions.assertEquals(loginPage.obterTituloPagina(), "Controle de Produtos");
    }
}
