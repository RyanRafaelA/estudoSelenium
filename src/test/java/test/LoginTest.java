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
        loginPage.inputEmail.sendKeys("");
        loginPage.inputSenha.sendKeys("");

        loginPage.buttonEntrar.click();

        String mensagem = loginPage.obterMensagem();

        Assertions.assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
    }
}
