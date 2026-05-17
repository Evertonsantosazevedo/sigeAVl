import java.util.Scanner;

public class Modulo {
    private Scanner scanner = new Scanner(System.in);
    ArvoreAVL arvoreAVL = new ArvoreAVL();

    public void menuPrincipal() {
        int opcao;
        do {
            System.out.print("1. Cadastro de produto\n2. Buscar produto\n3. Remover produto\n4. Atualizar estoque de um produto\n5. Listar produtos\n\nEscolha uma opção: ");
            opcao = scanner.nextInt();
            if (opcao < 1 || opcao > 5){
                System.out.println("Opção inválida! Tente novamente.\n");
            }
        } while (opcao < 1 || opcao > 5);

        switch (opcao) {
            case 1:
                cadastroDeProduto();
                break;
            case 2:
                buscarProduto();
                break;
            case 3:
                removerProduto();
                break;
            case 4:
                atualizarEstoque();
                break;
            case 5:
                listarProdutos();
                break;
        }
    }

    private void listarProdutos() {
        arvoreAVL.listarProdutos();
        menuPrincipal();
    }

    private void atualizarEstoque() {
        System.out.print("\nInforme o código do produto: ");
        int codigo = scanner.nextInt();
        int estoque;
        scanner.nextLine();
        Produto produto = arvoreAVL.buscar(codigo);

        if (produto != null) {
            System.out.print("\nQuantidade em estoque: ");

            do {
                estoque = scanner.nextInt();
            } while (estoque < 0);
            scanner.nextLine();
            produto.setQuantidadeEmEstoque(estoque);
            //produto.setQuantidadeEmEstoque(estoque + produto.getQuantidadeEmEstoque());
            System.out.println("\nEstoque atualizado!");
        } else System.out.println("Produto não encontrado!");
        menuPrincipal();
    }

    private void removerProduto() {
        if (arvoreAVL.getProdutoRaiz() != null) {
            System.out.print("\nInforme o código do produto: ");
            int codigo = scanner.nextInt();
            scanner.nextLine();
            Produto produto = arvoreAVL.buscar(codigo);
            if (produto != null) {
                System.out.println("Produto encontrado! Será removido.");
                arvoreAVL.removerProduto(produto.getCodigo());
            } else System.out.println("Produto não encontrado!");
        } else {
            System.out.println("\nNenhum produto encontrado!");
        }
        menuPrincipal();
    }

    private void buscarProduto() {
        System.out.print("\nInforme o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        Produto produto = arvoreAVL.buscar(codigo);
        if (produto != null) {
            System.out.println("Produto encontrado!");
            System.out.printf(
                    "%6s %-30s %-20s %7s %5s%n",
                    "CODIGO", "NOME", "CATEGORIA", "ESTOQUE", "PREÇO"
            );

            System.out.println(produto);
        } else System.out.println("Produto não encontrado!");
        menuPrincipal();
    }

    private void cadastroDeProduto() {
        System.out.print("\nInforme o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Informe o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Informe a categoria do produto: ");
        String categoria = scanner.nextLine();
        System.out.print("Informe a quantidade inicial do estoque do produto: ");
        int estoque = scanner.nextInt();
        System.out.print("Informe o preço do produto: ");
        Double preco = scanner.nextDouble();

        arvoreAVL.inserirProduto(codigo, nome, categoria, estoque, preco);

//        Produto produto = new Produto(codigo,nome,categoria, estoque,preco);
        System.out.println(String.format("\n\nResumo do produto\nCódigo: %d\nNome: %s" +
                "\nCategoria: %s\nEstoque inicial: %d unidades\nPreço: %.2f\n", codigo, nome, categoria, estoque, preco));

        menuPrincipal();
    }


    public static void main(String[] args) {
        Modulo modulo = new Modulo();
        modulo.arvoreAVL.inserirProduto(5, "Arroz", "Cereal", 50, 19.99);
        modulo.arvoreAVL.inserirProduto(4, "Feijão", "Cereal", 80, 14.99);
        modulo.arvoreAVL.inserirProduto(6, "Macarrão", "Massa", 40, 7.99);
        modulo.menuPrincipal();


    }


}