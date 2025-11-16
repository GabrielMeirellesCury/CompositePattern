import java.util.ArrayList;
import java.util.List;

public class Combo implements IProduto {
    protected String nome;
    protected List<IProduto> itens = new ArrayList<>();


    public Combo(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPreco() {
        double preco = 0;
        for (IProduto p : itens) {
            preco += p.getPreco();
        }
        //desconto de 10% no preço do combo:
        preco *= 0.9;
        return preco;
    }

    @Override
    public void exibir(String prefixo) {
        System.out.println(prefixo + " - " + nome + " (R$" + getPreco() + ") ");
        int i = 1;
        for (IProduto p : itens) {
            p.exibir(prefixo + "    " + Integer.toString(i));
            i++;
        }
    }

    public void adicionar(IProduto produto) {
        itens.add(produto);
    }

    public void remover(int idProduto) {
        String nomeProdutoRemovido = "";
        try {
            nomeProdutoRemovido = itens.get(idProduto).getNome();
            itens.remove(idProduto);
            System.out.println("Produto " + nomeProdutoRemovido + " removido!");
        } catch (Exception e) {
            System.out.println("Indice nao existente ou não numerico!");
//            e.printStackTrace();
        }
    }
}
