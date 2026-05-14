public class Produtos {
    private Integer codigo;
    private String nome;
    private String categoria;
    private Integer estoque;
    private Double preco;
    private Produtos esquerda;
    private Produtos direita;
    private Integer altura;

    public Produtos() {
    }

    public Produtos(Integer codigo, String nome, String categoria, Integer estoque, Double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.estoque = estoque;
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

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
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

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return String.format("\n\nResumo do produto\nCódigo: %d\nNome: %s" +
                "\nCategoria: %s\nEstoque inicial: %d unidades\nPreço: %.2f",codigo,nome,categoria,estoque,preco);
    }
}
