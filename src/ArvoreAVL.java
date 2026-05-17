public class ArvoreAVL {
    private Produto produtoRaiz;

    public Produto getProdutoRaiz() {
        return produtoRaiz;
    }

    public void setProdutoRaiz(Produto produtoRaiz) {
        this.produtoRaiz = produtoRaiz;
    }

    //Método que será chamado no main
    public Produto buscar(int codigo) {
        return buscarWhile(codigo);
    }

    //Recebe o código como chave para a busca
    public Produto buscarWhile(int codigo) {
        Produto atual = this.produtoRaiz; // Inicia a busca a partir da raiz da árvore
        while (atual != null) { // verifica se o valor não é nulo antes de continuar com as buscas, se a raiz for nulla a árvore está vazia
            if (codigo == atual.getCodigo()) { // Verifica se código passado corresponde ao do produto atual
                return atual;
            } else if (codigo < atual.getCodigo()) { // No caso do código passado ser menor que o do produto atual
                atual = atual.getEsquerda(); // Passamos como o filho à esquerda do produto atual, como o novo atual
            } else { // No caso do código passado ser maior que o do produto atual
                atual = atual.getDireita(); // Passamos como o filho à direita do produto atual, como o novo atual
            }

        }
        //Caso o while termine e o produto não seja encontrado
        return null;
    }

    public void listarProdutos(){
        if(produtoRaiz != null){
            System.out.printf(
                    "%6s %-30s %-20s %7s %8s%n",
                    "CODIGO", "NOME", "CATEGORIA", "ESTOQUE", "PREÇO"
            );
            emOrdemRecursivo(produtoRaiz);
            System.out.println();
        }else{
            System.out.println("Nenhum produto encontrado!\n");
        }

    }

    //Chamada privada que recebe a raiz da árvore como ponto inicial
    public void emOrdemRecursivo(Produto atual) {
        if (atual != null) { // Se a raiz não for nulo o programa é iniciado
            emOrdemRecursivo(atual.getEsquerda()); // Passa o filho a esquerda do antigo atual como novo atual, empilhando os produtos a esquerda de forma que o maior fica por baixo e o menor fica cima
            System.out.println(atual.toString()); // Começa a imprimir os produtos empilhados pelos método de recursão
            emOrdemRecursivo(atual.getDireita()); // Passa o filho a diteita do antigo atual como novo atual, iniciando a verificação se algo a esquerda, imprimindo, verificando a deireita e imprimindo
        }
    }

    public Produto aumentarQuantidade(int codigo, int quantidade) {
        if (quantidade > 0){ // verifca se a quantidade passada é válida
            Produto produto = buscar(codigo); // busca o produto pelo código passado
            if (produto != null) { // verifica se o produto existe
                produto.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque() + quantidade); // aumenta sua quantidade somando o que existe com a que foi passada
                return produto; // retorna o produto com a quantidade modificada
            } else {
                return null; // retorna nulo caso o produto não exista
            }
        }
        return null; // retorna nulo se a quantidade for <= 0
    }

    public void inserirProduto(Integer codigo, String nome, String categoria, Integer estoque, Double preco){
        System.out.println("--- Inserindo: " + nome + " ---");
        produtoRaiz = inserirRecursivo(produtoRaiz, codigo, nome, categoria, estoque, preco);
    }

    public Produto inserirRecursivo(Produto produto, Integer codigo, String nome, String categoria, Integer estoque, Double preco){
        //1 - Produto é adicionado
        if(produto == null){
            System.out.println("Produto " + nome + " cadastrado.");
            return new Produto(codigo,nome,categoria,estoque,preco);
        }

        //2 - Percorre os nós recursivamente até encontrar o nó vazio
        if(codigo < produto.getCodigo()){
            produto.setEsquerda(inserirRecursivo(produto.getEsquerda(),codigo,nome,categoria,estoque,preco));
        }else if (codigo > produto.getCodigo()){
            produto.setDireita(inserirRecursivo(produto.getDireita(),codigo,nome,categoria,estoque,preco));
        }else{
            System.out.println("Código já utilizado!");
            return produto;
        }

        //3 - Atualiza a altura de cada nó0
        produto.setAltura(1 + Math.max(obterAltura(produto.getEsquerda()),obterAltura(produto.getDireita())));

        //4 - Obtendo o fator de balanceamento
        int balanceamento = obterBalanceamento(produto);

        //5 - Casos de rotação
        //5.1 - Direita-Direita
        if(balanceamento > 1 && codigo > produto.getDireita().getCodigo()){
            System.out.println("Árvore desbalanceada. Fazendo rotação à esquerda.");
            return rotacaoEsquerda(produto);
        }

        //5.2 - Esquerda-Esquerda
        if(balanceamento <-1 && codigo < produto.getEsquerda().getCodigo()){
            System.out.println("Árvore desbalanceada. Fazendo rotação à direita.");
            return rotacaoDireita(produto);
        }

        //5.3 - Direita-Esquerda
        if(balanceamento > 1 && codigo < produto.getDireita().getCodigo()){
            System.out.println("Árvore desbalanceada. Fazendo uma rotação à direita e outra rotação à esquerda.");
            produto.setDireita(rotacaoDireita(produto.getDireita()));
            return rotacaoEsquerda(produto);
        }

        //5.4 - Esquerda-Direita
        if(balanceamento < -1 && codigo > produto.getEsquerda().getCodigo()){
            System.out.println("Árvore desbalanceada. Fazendo uma rotação à esquerda e outra rotação à direita.");
            produto.setEsquerda(rotacaoEsquerda(produto.getEsquerda()));
            return rotacaoDireita(produto);
        }
        return produto;
    }

    public void removerProduto(Integer codigo){
        System.out.println("--- Removendo produto de código " + codigo + " ---");
        produtoRaiz = removerRecursivo(produtoRaiz, codigo);
    }

    public Produto removerRecursivo(Produto produto, int codigo) {
        if (produto == null)
            return null;

        if (codigo < produto.getCodigo()) {
            produto.setEsquerda(removerRecursivo(produto.getEsquerda(), codigo));
        } else if (codigo > produto.getCodigo()) {
            produto.setDireita(removerRecursivo(produto.getDireita(),codigo));
        } else {
            //Casos de remoção
            // caso 1: folha
            if (produto.getEsquerda() == null && produto.getDireita() == null) {
                return null;
            }

            // caso 2: um filho
            if (produto.getEsquerda() == null) return produto.getDireita();
            if (produto.getDireita() == null) return produto.getEsquerda();

            // caso 3: dois filhos
            Produto produtoSucessor = menor(produto.getDireita());
            produto.setCodigo(produtoSucessor.getCodigo());
            produto.setNome(produtoSucessor.getNome());
            produto.setCategoria(produtoSucessor.getCategoria());
            produto.setQuantidadeEmEstoque(produtoSucessor.getQuantidadeEmEstoque());
            produto.setPreco(produtoSucessor.getPreco());

            produto.setDireita(removerRecursivo(produto.getDireita(),produtoSucessor.getCodigo()));
        }

        //3 - Atualiza a altura de cada nó
        produto.setAltura(1 + Math.max(obterAltura(produto.getEsquerda()),obterAltura(produto.getDireita())));

        //4 - Obtendo o fator de balanceamento
        int balanceamento = obterBalanceamento(produto);

        //5 - Casos de rotação
        //5.1 - Direita-Direita
        if(balanceamento > 1 && obterBalanceamento(produto.getDireita()) >= 0){
            System.out.println("Árvore desbalanceada. Fazendo rotação à esquerda.");
            return rotacaoEsquerda(produto);
        }

        //5.2 - Esquerda-Esquerda
        if(balanceamento <-1 && obterBalanceamento(produto.getEsquerda()) <= 0){
            System.out.println("Árvore desbalanceada. Fazendo rotação à direita.");
            return rotacaoDireita(produto);
        }

        //5.3 - Direita-Esquerda
        if(balanceamento > 1 && obterBalanceamento(produto.getDireita()) < 0){
            System.out.println("Árvore desbalanceada. Fazendo uma rotação à direita e outra rotação à esquerda.");
            produto.setDireita(rotacaoDireita(produto.getDireita()));
            return rotacaoEsquerda(produto);
        }

        //5.4 - Esquerda-Direita
        if(balanceamento < -1 && obterBalanceamento(produto.getEsquerda()) > 0){
            System.out.println("Árvore desbalanceada. Fazendo uma rotação à esquerda e outra rotação à direita.");
            produto.setEsquerda(rotacaoEsquerda(produto.getEsquerda()));
            return rotacaoDireita(produto);
        }

        return produto;
    }

    // Menor valor (usado na remoção)
    public static Produto menor(Produto produto) {
        while (produto.getEsquerda() != null) {
            produto = produto.getEsquerda();
        }
        return produto;
    }

    private int obterAltura(Produto produto){
        return (produto == null) ? 0 : produto.getAltura();
    }

    private int obterBalanceamento(Produto produto){
        return (produto == null) ? 0 : obterAltura(produto.getDireita()) - obterAltura(produto.getEsquerda());
    }

    private Produto rotacaoDireita(Produto produto){
        System.out.println("Rotacionando à direita em torno do produto " + produto.getNome());
        Produto x = produto.getEsquerda();
        Produto y = x.getDireita();
        x.setDireita(produto);
        produto.setEsquerda(y);
        produto.setAltura(Math.max(obterAltura(produto.getEsquerda()),obterAltura(produto.getDireita())) + 1);
        x.setAltura(Math.max(obterAltura(x.getEsquerda()),obterAltura(x.getDireita())) + 1);
        return x;
    }

    private Produto rotacaoEsquerda(Produto produto){
        System.out.println("Rotacionando à esquerda em torno do produto " + produto.getNome());
        Produto x = produto.getDireita();
        Produto y = x.getEsquerda();
        x.setEsquerda(produto);
        produto.setDireita(y);
        produto.setAltura(Math.max(obterAltura(produto.getEsquerda()),obterAltura(produto.getDireita())) + 1);
        x.setAltura(Math.max(obterAltura(x.getEsquerda()),obterAltura(x.getDireita())) + 1);
        return x;
    }
}