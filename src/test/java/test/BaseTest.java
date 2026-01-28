package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {

    protected static WebDriver driver;
    private static final String URL_BASE = "";

    @BeforeAll
    protected static void iniciar(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    @AfterAll
    protected static void finalizar(){
        driver.quit();
    }
}
