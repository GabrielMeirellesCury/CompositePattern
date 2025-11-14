import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static List<IProduto> catalogo = new ArrayList<>();
    private static Carrinho carrinho = new Carrinho("Carrinho", 0);
    private static Scanner scan = new Scanner(System.in);


    public static void iniciar() {
        carregarCatalogo();
        int opcao;
        do {
            System.out.println("--- Menu ---");
            System.out.println("Ver cardapio (1)");
            System.out.println("Adicionar produto (2)");
            System.out.println("Ver carrinho (3)");
            System.out.println("Encerrar compra (4)");

            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    mostrarCatalogo();
                    break;
                case 2:
                    adicionarProduto();
                    break;
                case 3:
                    mostrarCarrinho();
                    break;
                case 4:
                    encerrarCompra();
                    break;
                default:
                    System.out.println("Opcao invalida,digite novamente! \n\n");
            }
        } while (opcao != 4);
    }

    public static void carregarCatalogo() {
        ProdutoSimples burger = new ProdutoSimples("Hamburguer", 30);
        ProdutoSimples batataM = new ProdutoSimples("Batata media", 16);
        ProdutoSimples refriM = new ProdutoSimples("Refrigerante medio", 12);

        Combo combo1 = new Combo("Combo 1", 0);
        combo1.adicionar(burger);
        combo1.adicionar(batataM);
        combo1.adicionar(refriM);

        catalogo.add(combo1);
        catalogo.add(burger);
        catalogo.add(batataM);
        catalogo.add(refriM);
    }

    public static void mostrarCatalogo() {
        int i = 1; //código do produto no catalogo, para o usuario digitar quando for adicionar
        String prefix;
        for (IProduto p : catalogo) {
            prefix = Integer.toString(i);
            p.exibir(prefix);
            i++;
        }
        System.out.println("----------\n");
    }

    public static void adicionarProduto() {
        int indiceProduto;
        System.out.print("\nDigite o indice do produto a ser adicionado no carrinho: ");
        try {

            indiceProduto = scan.nextInt();
            carrinho.adicionar(catalogo.get(indiceProduto - 1));
            System.out.println("Produto " + catalogo.get(indiceProduto - 1).getNome() + " adicionado ao carrinho!");
            System.out.println();
        } catch (Exception e) {
            System.out.println("Indice não existente ou não numerico");
        }
    }

    public static void mostrarCarrinho() {

        carrinho.exibir("");
        String remover;
        scan.nextLine();
        System.out.println("Preco total: " + carrinho.getPreco());
        do {
            System.out.println("Deseja remover algum produto do carrinho? (s/n)");
            remover = scan.nextLine();
        } while (!remover.equalsIgnoreCase("s") && !remover.equalsIgnoreCase("n"));
        if (remover.equalsIgnoreCase("s")) {
            System.out.print("Digite o indice do produto (no cardapio) que deseja remover: ");
            int i = scan.nextInt();
            carrinho.remover((i - 1));
        }
        System.out.println();
    }

    public static void encerrarCompra() {
        scan.nextLine();
        System.out.println("--- Resumo da compra ---");
        System.out.println("Total: " + carrinho.getPreco());
        System.out.print("Deseja confirmar a compra? (s/n) ");
        String resp = scan.nextLine();
        if (resp.equalsIgnoreCase("s")) {
            System.out.println("Compra finalizada. Obrigado!");
            System.exit(0);
        } else {
            System.out.println("Compra cancelada.");
        }
    }

}
