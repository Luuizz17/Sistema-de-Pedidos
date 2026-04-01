package model;

public class Produto {

    private int id;
    private double preco;
    private int estoque;
    private String nome;

    @Override
    public String toString(){
        return "ID: " + id +
                " | Produto: " + nome +
                " | Preço: R$ " + String.format("%.2f", preco) +
                " | Estoque: " + estoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
