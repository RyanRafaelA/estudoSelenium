package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {

    protected static WebDriver driver;
    private static final String PROJETO = "C:\\Users\\Public\\projetos\\estudoSelenium\\controle-de-produtos\\sistema\\login.html";

    @BeforeAll
    protected static void iniciar(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PROJETO);
    }

    @AfterAll
    protected static void finalizar(){
        driver.quit();
    }
}
