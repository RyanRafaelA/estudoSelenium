package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.ControleProdutoPO;
import page.LoginPO;

public class ControleProdutoTest extends BaseTest{
    private LoginPO loginPage;
    private ControleProdutoPO controleProdutoPage;

    @BeforeEach
    public void prepararTestes(){
        loginPage = new LoginPO(driver);

        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        controleProdutoPage = new ControleProdutoPO(driver);

        Assertions.assertEquals(controleProdutoPage.obterTituloPagina(), "Controle de Produtos");
    }

    @Test
    public void TC001_deveAbrirModalParaCadastroAoClicarNoBotaoCriar(){
        controleProdutoPage.cliqueAdicionar();

        String titulo = controleProdutoPage.obterTituloModal();

        Assertions.assertEquals(titulo, "Produto");
    }

    @Test
    public void TC002_naoDeveSerPossivelCadastraUmProdutoSemPreencherTodosOsCampos(){
        controleProdutoPage.cliqueAdicionar();

        controleProdutoPage.cadastrarProduto("00001", "Martelo", 15, 59.9, "");

        String mensagem = controleProdutoPage.obterMensagemSpan();

        Assertions.assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
    }
}
