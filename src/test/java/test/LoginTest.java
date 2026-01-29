package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.LoginPO;

public class LoginTest extends BaseTest{
    private static LoginPO loginPage;

    private void executarAcaoDeLogar(String email, String senha){
        loginPage.escreverEmail(email);
        loginPage.escreverSenha(senha);

        loginPage.cliqueEnter();
    }

    @BeforeAll
    public static void prepararTestes(){
        loginPage = new LoginPO(driver);
    }

    @Test
    public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios(){
        executarAcaoDeLogar("", "");

        String mensagem = loginPage.obterMensagemSpan();

        Assertions.assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazia(){
        executarAcaoDeLogar("teste", "");

        String mensagem = loginPage.obterMensagemSpan();

        Assertions.assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }

    @Test
    public void TC003_naoDeveLogarNoSistemaComEmailVazioESenhaIncorreta(){
        executarAcaoDeLogar("", "teste");

        String mensagem = loginPage.obterMensagemSpan();

        Assertions.assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }
}
