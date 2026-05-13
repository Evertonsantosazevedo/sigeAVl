public class Produtos {
    private Integer codigo;
    private String nome;
    private String categoria;
    private Integer quantidadeEmEstoque;
    private Double preco;
    private Produtos esquerda;
    private Produtos direita;

    public Produtos() {
    }

    public Produtos(Integer codigo, String nome, String categoria, Integer quantidadeEmEstoque, Double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.preco = preco;
        this.direita = null;
        this.esquerda = null;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(Integer quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Produtos getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Produtos esquerda) {
        this.esquerda = esquerda;
    }

    public Produtos getDireita() {
        return direita;
    }

    public void setDireita(Produtos direita) {
        this.direita = direita;
    }
}
