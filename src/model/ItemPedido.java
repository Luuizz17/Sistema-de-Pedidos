package model;

public class ItemPedido {

    private int quantidade ;
    private double subtotal;
    private  Produto produto;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        valorFinal();
    }

    public String toString(){
        return "Produto: " + produto.getNome() +
                " | Qtd: " + getQuantidade() +
                " | Subtotal: R$ " + String.format("%.2f" , subtotal);
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        valorFinal();
    }

    public void valorFinal() {
   subtotal = produto.getPreco() * quantidade;
   }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        valorFinal();
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
