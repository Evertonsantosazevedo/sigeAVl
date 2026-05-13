import java.util.Scanner;

public class Modulo {
    private Scanner scanner = new Scanner (System.in);

    public void menuPrincipal(){
        int opcao;
        System.out.print("1. Cadastro de produto\n2. Buscar produto\n3. Atualizar produto\n4. Listar produtos\n\nEscolha uma opção: ");
        do {
            opcao = scanner.nextInt();
        }while(opcao<1 || opcao >4);

        switch(opcao){
            case 1:
                cadastroDeProduto();
            case 2:
//                buscarProduto();
            case 3:
//                atualizarProduto();
            case 4:
//                listarProdutos();
        }
    }

    private void cadastroDeProduto() {
        System.out.print("\nInforme o código do produto: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("\nInforme o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("\nInforme a categoria do produto: ");
        String categoria = scanner.nextLine();
        System.out.print("\nInforme a quantidade inicial do estoque do produto: ");
        int estoque = scanner.nextInt();
        System.out.print("\nInforme o preço do produto: ");
        Double preco = scanner.nextDouble();

//        Produtos produto = new Produtos(codigo,nome,categoria, estoque,preco);

        System.out.println(String.format("\n\nResumo do produto\nCódigo: %d\nNome: %s" +
                "\nCategoria: %s\nEstoque inicial: %d unidades\nPreço: %.2f",codigo,nome,categoria,estoque,preco));
    }


    public static void main(String[] args){
        Modulo modulo = new Modulo();
        modulo.menuPrincipal();
    }


}
