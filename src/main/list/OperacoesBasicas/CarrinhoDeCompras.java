package main.list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    //atributo
    private List<Item> itemList;

    public CarrinhoDeCompras() {
        this.itemList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        Item item = new Item(nome, preco, quantidade);
        this.itemList.add(item);
    }

    public void removerItem(String nome){
        List<Item> itensParaRemover = new ArrayList<>();
        if (!itemList.isEmpty()){
            for (Item i : itemList){
                if (i.getNome().equalsIgnoreCase(nome)){
                    itensParaRemover.add(i);
                }
            }
            itemList.removeAll(itensParaRemover);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public double calcularValorTotal(){
        double valorTotal = 0d;
        if(!itemList.isEmpty()){
            for (Item i : itemList){
                double valorItem = i.getPreco() * i.getQuantidade();
                valorTotal += valorItem;
            }
            return valorTotal;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public void exibirItens(){
        if (!itemList.isEmpty()){
            System.out.println(this.itemList);
        } else {
            System.out.println("A lista está vazia!");
        }

    }

    @Override
    public String toString() {
        return "CarrinhoDeCompras{" +
                "itens=" + itemList +
                '}';
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        //Adicionando itens ao carrinho
        carrinhoDeCompras.adicionarItem("Computador", 1000.00, 1);
        carrinhoDeCompras.adicionarItem("Mouse", 10.00, 2);
        carrinhoDeCompras.adicionarItem("Teclado", 20.00, 1);
        carrinhoDeCompras.adicionarItem("Impressora", 600.00, 3);

        //Exibindo os itens do carrinho e mostrando o total
        carrinhoDeCompras.exibirItens();
        System.out.println("O total do carrinho é: "+ carrinhoDeCompras.calcularValorTotal());

        //Removendo um item do carrinho
        carrinhoDeCompras.removerItem("Teclado");

        //Exibindo os itens atualizados no carrinho
        carrinhoDeCompras.exibirItens();

        //Calculando e exibindo o valor total da compra
        System.out.println("O total da compra é: "+ carrinhoDeCompras.calcularValorTotal());

    }
}
