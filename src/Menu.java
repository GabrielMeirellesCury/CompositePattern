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
        //adicionando combos e produtos no menu
        ProdutoSimples burger = new ProdutoSimples("Hamburguer Evandro", 30);
        ProdutoSimples burger2 = new ProdutoSimples("Hamburguer Americo", 37);
        ProdutoSimples burger3 = new ProdutoSimples("Hamburguer Murta", 32);
        ProdutoSimples burger4 = new ProdutoSimples("Hamburguer Alexandre", 43);
        ProdutoSimples burger5 = new ProdutoSimples("Hamburguer Tinos", 29);
        ProdutoSimples batataM = new ProdutoSimples("Batata media", 16);
        ProdutoSimples batataP = new ProdutoSimples("Batata pequena", 12);
        ProdutoSimples batataG = new ProdutoSimples("Batata grande", 20);
        ProdutoSimples refriM = new ProdutoSimples("Refrigerante medio", 9);
        ProdutoSimples refriP = new ProdutoSimples("Refrigerante pequeno", 7);
        ProdutoSimples refriG = new ProdutoSimples("Refrigerante grande", 12);

        ProdutoSimples sobremesa1 = new ProdutoSimples("Casquinha", 3);
        ProdutoSimples sobremesa2 = new ProdutoSimples("Milkshake de chocolate", 12);
        ProdutoSimples sobremesa3 = new ProdutoSimples("Pudim", 8);
        ProdutoSimples sobremesa4 = new ProdutoSimples("Acai", 15);

        //Combos:
        Combo combo1 = new Combo("Combo Evandro", 0);
        combo1.adicionar(burger);
        combo1.adicionar(batataM);
        combo1.adicionar(refriM);

        Combo combo2 = new Combo("Combo Murtada Dupla", 0);
        combo2.adicionar(burger3);
        combo2.adicionar(burger3);
        combo2.adicionar(batataG);
        combo2.adicionar(refriG);

        Combo combo3 = new Combo("Combo Infantil", 0);
        combo3.adicionar(burger5);
        combo3.adicionar(batataP);
        combo3.adicionar(refriP);
        combo3.adicionar(sobremesa1);

        Combo combo4 = new Combo("Combo Premium Alexandre", 0);
        combo4.adicionar(burger4);
        combo4.adicionar(batataG);
        combo4.adicionar(refriG);
        combo4.adicionar(sobremesa2);

        Combo combo5 = new Combo("Combo Americada", 0);
        combo5.adicionar(burger2);
        combo5.adicionar(batataM);
        combo5.adicionar(refriG);
        combo5.adicionar(sobremesa3);

        Combo combo6 = new Combo("Combo Fitness", 0);
        combo6.adicionar(burger5);
        combo6.adicionar(refriP);
        combo6.adicionar(sobremesa4);

        //adicionando no catalogo:
        catalogo.add(combo1);
        catalogo.add(combo2);
        catalogo.add(combo3);
        catalogo.add(combo4);
        catalogo.add(combo5);
        catalogo.add(combo6);

        catalogo.add(burger);
        catalogo.add(burger2);
        catalogo.add(burger3);
        catalogo.add(burger4);
        catalogo.add(burger5);

        catalogo.add(batataP);
        catalogo.add(batataM);
        catalogo.add(batataG);

        catalogo.add(refriP);
        catalogo.add(refriM);
        catalogo.add(refriG);

        catalogo.add(sobremesa1);
        catalogo.add(sobremesa2);
        catalogo.add(sobremesa3);
        catalogo.add(sobremesa4);
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
            System.out.print("Digite o indice do produto do carrinho que deseja remover: ");
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
