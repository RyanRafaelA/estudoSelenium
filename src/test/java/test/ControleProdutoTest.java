package test;

import build.Produto;
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

        Produto produto = new Produto.ProdutoBuilder()
                .codigo("0001")
                .nome("Martelo")
                .quantidade(15)
                .valor(59.9)
                .data("").build();

        controleProdutoPage.cadastrarProduto(produto);

        String mensagem = controleProdutoPage.obterMensagemSpan();

        Assertions.assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
    }
}
