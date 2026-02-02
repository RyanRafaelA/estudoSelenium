package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ControleProdutoPO extends BasePO{
    @FindBy(id = "btn-adicionar")
    private WebElement buttonAdicionar;

    @FindBy(css = "ul>li>a.nav-link")
    private WebElement linkVoltar;

    @FindBy(css = "div.modal-header>h4")
    private WebElement tituloModal;

    public ControleProdutoPO(WebDriver driver) {
        super(driver);
    }

    public void cliqueAdicionar(){
        clique(buttonAdicionar);
        clique(buttonAdicionar);
    }

    public String obterTituloModal(){
        return tituloModal.getText();
    }
}
