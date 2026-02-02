package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePO {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePO(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    protected void clique(WebElement elemento){
        wait.until(ExpectedConditions.visibilityOf(elemento));
        elemento.click();
    }

    protected void escrever(WebElement elemento, String texto){
        wait.until(ExpectedConditions.visibilityOf(elemento));
        elemento.clear();
        elemento.sendKeys(texto);
    }

    protected String obterMensagem(WebElement elemento){
        wait.until(ExpectedConditions.visibilityOf(elemento));
        return elemento.getText();
    }

    public String obterTituloPagina(){
        return  driver.getTitle();
    }
}
