public class Carrinho extends Combo{

    //o carrinho basicamente funciona do mesmo modo que um combo, e faz exatamente tudo que ele faz, com exceção de
    //aplicar o desconto nos itens do combo
    //Assim, resolvi fazer carrinho herdar de combo para sobrescrever o mét odo de pegar o preço, só pra não aplicar o desconto.
    public Carrinho(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double getPreco() {
        preco = 0;
        for (IProduto p : itens) {
            preco += p.getPreco();
        }
        return preco;
    }

    @Override
    public void exibir(String prefixo) {
        System.out.println(nome);
        int i = 1;
        for (IProduto p : itens)
        {
            p.exibir("  " + Integer.toString(i));
            i++;
        }
    }
}
