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

    @FindBy(id = "codigo")
    private WebElement inputCodigo;

    @FindBy(id = "nome")
    private WebElement inputNome;

    @FindBy(id = "quantidade")
    private WebElement inputQuantidade;

    @FindBy(id = "valor")
    private WebElement inputValor;

    @FindBy(id = "data")
    private WebElement inputData;

    @FindBy(id = "btn-salvar")
    private WebElement buttonSalvar;

    @FindBy(id = "btn-sair")
    private WebElement buttonSair;

    @FindBy(id = "mensagem")
    private WebElement spanMensagem;

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

    public void cadastrarProduto(String codigo, String nome, Integer quantidade, Double valor, String data){
        escrever(inputCodigo, codigo);
        escrever(inputNome, nome);
        escrever(inputQuantidade, quantidade.toString());
        escrever(inputValor, valor.toString());
        escrever(inputData, data);

        buttonSalvar.click();

    }

    public String obterMensagemSpan(){
        return obterMensagem(spanMensagem);
    }
}
