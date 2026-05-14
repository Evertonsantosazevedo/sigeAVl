public class ArvoreAVL {

    private Produtos raiz;

    //Método que será chamado no main
    public void buscar(int codigo) {
        buscarRecursivo(this.raiz, codigo);
    }

    //Método que faz a busca na árvore
    private void buscarRecursivo(Produtos atual, int codigo) {

        //Verifica se é null indicando que ou árvore é vazia se for a a raíz, ou que chegou ao final sem encontrar o produto
        if (atual == null) {
            System.out.println("Produto não econtrado!");
        } else if (codigo == atual.getCodigo()) { // Verifica se e código e o código do produto são iguais
            System.out.println(atual.toString());
        } else if (codigo < atual.getCodigo()) { // Se o código passado for menor que o código do produto atual, a busca segue para a esquerda
            //É chamado de maneira recursiva o buscar, que agora segue com o filho a esquerda do antigo atual
            buscarRecursivo(atual.getEsquerda(), codigo);
        } else { // Se o código passado for maior que o código do produto atual, a busca segue para a direita
            //É chamado de maneira recursiva o buscar, que agora segue com o filho a direita do antigo atual
            buscarRecursivo(atual.getDireita(), codigo);
        }
    }

    //Recebe o código como chave para a busca
    public void buscarWhile(int codigo) {
        Produtos atual = this.raiz; // Inicia a busca a partir da raiz da árvore
        while (atual != null) { // verifica se o valor não é nulo antes de continuar com as buscas, se a raiz for nulla a árvore está vazia
            if (codigo == atual.getCodigo()) { // Verifica se código passado corresponde ao do produto atual
                System.out.println(atual.toString()); // Exibe o produto
                return; // Como o produto foi encontrado saímos do método
            } else if (codigo < atual.getCodigo()) { // No caso do código passado ser menor que o do produto atual
                atual = atual.getEsquerda(); // Passamos como o filho à esquerda do produto atual, como o novo atual
            } else { // No caso do código passado ser maior que o do produto atual
                atual = atual.getDireita(); // Passamos como o filho à direita do produto atual, como o novo atual
            }

        }
        //Caso o while termine e o produto não seja encontrado
        System.out.println("Produto não encontrado !");
    }


    public void imprimirEmOrdem() {
        if (this.raiz == null) { // verifica se árvore está vazia
            System.out.println("Nenhum produto adicionado no estoque !");
        } else {
            // se árvore não está vaiz, chama o método recursivo privado que percorre sua estrutura
            emOrdemRecursivo(this.raiz);
        }

    }

    //Chamada privada que recebe a raiz da árvore como ponto inicial
    private void emOrdemRecursivo(Produtos atual) {
        if (atual != null) { // Se a raiz não for nulo o programa é iniciado
            emOrdemRecursivo(atual.getEsquerda()); // Passa o filho a esquerda do antigo atual como novo atual, empilhando os produtos a esquerda de forma que o maior fica por baixo e o menor fica cima
            System.out.println(atual.toString()); // Começa a imprimir os produtos empilhados pelos método de recursão
            emOrdemRecursivo(atual.getDireita()); // Passa o filho a diteita do antigo atual como novo atual, iniciando a verificação se algo a esquerda, imprimindo, verificando a deireita e imprimindo
        }
    }


}
