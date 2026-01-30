package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {

    protected static WebDriver driver;
    private static final String PROJETO = "C:\\Users\\Public\\projetos\\estudoSelenium\\controle-de-produtos\\sistema\\login.html";

    @BeforeEach
    protected void iniciar(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(PROJETO);
    }

    @AfterEach
    protected void finalizar(){
        driver.quit();
    }
}
