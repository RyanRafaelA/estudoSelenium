package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{
    @FindBy(id = "email")
    private WebElement inputEmail;

    @FindBy(id = "senha")
    private WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    private WebElement buttonEntrar;

    @FindBy(css = "form.form-login>div.alert>span")
    private WebElement spanMensagem;


    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public String obterMensagemSpan(){
        return obterMensagem(spanMensagem);
    }

    public void escreverEmail(String email){
        escrever(inputEmail, email);
    }

    public void escreverSenha(String senha){
        escrever(inputSenha, senha);
    }

    public void cliqueEnter(){
        clique(buttonEntrar);
    }
}
