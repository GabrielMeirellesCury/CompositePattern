public class Carrinho extends Combo{

    //o carrinho basicamente funciona do mesmo modo que um combo, e faz exatamente tudo que ele faz, com exceção de
    //aplicar o desconto nos itens do combo, ele tambem exibe um pouco diferente
    //Assim, resolvi fazer carrinho herdar de combo para sobrescrever o mét odo de pegar o preço, só pra não aplicar o desconto.
    public Carrinho(String nome, double preco) {
        super(nome, preco);
    }

    @Override
    public double getPreco() { //diferente do combo pq nao aplica o desconto
        preco = 0;
        for (IProduto p : itens) {
            preco += p.getPreco();
        }
        return preco;
    }

    @Override
    public void exibir(String prefixo) {
        System.out.println(nome); //não sei oq fazer com o prefixo, não posso tirar o parametro, mas nao sei como usar
        int i = 1;
        for (IProduto p : itens)
        {
            p.exibir("  " + Integer.toString(i));
            i++;
        }
    }
}
