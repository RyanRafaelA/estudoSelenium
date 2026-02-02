package build;

import page.ControleProdutoPO;

public class Produto {
    private String codigo;
    private String nome;
    private Integer quantidade;
    private Double valor;
    private String data;

    private Produto(ProdutoBuilder builder){
        this.codigo = builder.codigo;
        this.nome = builder.nome;
        this.quantidade = builder.quantidade;
        this.valor = builder.valor;
        this.data = builder.data;
    }

    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public String getData() { return data; }
    public Integer getQuantidade() { return quantidade; }
    public Double getValor() { return valor; }

    public static class ProdutoBuilder{
        private String codigo;
        private String nome;
        private Integer quantidade;
        private Double valor;
        private String data;

        public ProdutoBuilder codigo(String codigo){
            this.codigo = codigo;
            return this;
        }
        public ProdutoBuilder nome(String nome){
            this.nome = nome;
            return this;
        }
        public ProdutoBuilder quantidade(Integer quantidade){
            this.quantidade = quantidade;
            return this;
        }
        public ProdutoBuilder valor(Double valor){
            this.valor = valor;
            return this;
        }
        public ProdutoBuilder data(String data){
            this.data = data;
            return this;
        }

        public Produto build(){
            return new Produto(this);
        }
    }

}
