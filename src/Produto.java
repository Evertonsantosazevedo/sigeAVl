public class Produto {
    private Integer codigo;
    private String nome;
    private String categoria;
    private Integer quantidadeEmEstoque;
    private Double preco;
    private Produto esquerda;
    private Produto direita;
    private Integer altura;

    public Produto() {
    }

    public Produto(Integer codigo, String nome, String categoria, Integer quantidadeEmEstoque, Double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.categoria = categoria;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.preco = preco;
        this.direita = null;
        this.esquerda = null;
        this.altura = 1;
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

    public Produto getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Produto esquerda) {
        this.esquerda = esquerda;
    }

    public Produto getDireita() {
        return direita;
    }

    public void setDireita(Produto direita) {
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
        return String.format(
                "%6d %-30s %-20s %7d %8.2f",
                codigo,
                nome,
                categoria,
                quantidadeEmEstoque,
                preco
        );
    }
}
