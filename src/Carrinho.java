import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private List<IProduto> itens = new ArrayList<>();
    private String nome; //

    public Carrinho(String nome) {
        this.nome = nome;
    }

    public void adicionar(IProduto produto) {
        itens.add(produto);
    }

    public void remover(int idProduto) {
        String nomeProdutoRemovido = "";
        try {
            nomeProdutoRemovido = itens.get(idProduto).getNome();
            itens.remove(idProduto);
        } catch (Exception e) {
            System.out.println("Indice nao existente ou não numerico!");
//            e.printStackTrace();
        }
        System.out.println("Produto " + nomeProdutoRemovido + " removido!");
    }

    public double getPreco() {
        double precoTotal = 0;
        for (IProduto p : itens) {
            // Delega o cálculo do preço a cada item
            precoTotal += p.getPreco();
        }
        return precoTotal;
    }

    public void exibir() {
        System.out.println("--- " + nome + " ---");
        int i = 1;
        for (IProduto p : itens) {
            p.exibir("  " + Integer.toString(i));
            i++;
        }
    }
}
