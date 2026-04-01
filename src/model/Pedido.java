package model;

import Enums.StatusPedido;

import java.util.ArrayList;

public class Pedido {

    private int id;
    private Cliente cliente;
    private StatusPedido status ;
    private double total = 0;

    private ArrayList<ItemPedido> itens;

    public  Pedido(int id , Cliente cliente){
        this.id = id;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.status = StatusPedido.PENDENTE;
        this.total = 0;
    }

    public void adicionarItem(ItemPedido item){
      itens.add(item);
      calcularTotal();
    }
    public void calcularTotal(){
        total = 0;

        for(ItemPedido item : itens){
            total+= item.getSubtotal();
        }
    }

    public void removerItem(ItemPedido item){
        itens.remove(item);
        calcularTotal();
    }

    public String toString(){
        return "Pedido ID: " + id +
                " | Cliente: " + cliente.getNome() +
                " | Status: " + status +
                " | Total: R$ " + String.format("%.2f", total);
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemPedido> itens) {
        this.itens = itens;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
