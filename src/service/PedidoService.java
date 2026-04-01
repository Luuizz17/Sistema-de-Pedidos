package service;

import Enums.StatusPedido;
import model.ItemPedido;
import model.Pedido;

import java.util.ArrayList;

public class PedidoService {

    ArrayList<Pedido> pedidos = new ArrayList<>();

    public void criarPedido(Pedido pedido){
     pedidos.add(pedido);
    }

    public void listarPedidos(){
        for(Pedido pedido : pedidos){
            System.out.println(pedido);
        }
    }

    public Pedido buscarPorId(int id){
        for(Pedido pedido : pedidos){

            if(pedido.getId() == id){
                return pedido;
            }
        }
        return null;
    }

    public void removerPedido(int id){
        Pedido pedido = buscarPorId(id);

        if(pedido != null){
            pedidos.remove(pedido);
        }
    }

    public void alterarStatus(int id , StatusPedido novoStatus){

        Pedido pedido = buscarPorId(id);
        if(pedido !=null) {
           pedido.setStatus(novoStatus);
        }
    }

    public void adicionarItemNoPedido(int idPedido , ItemPedido item){

     Pedido pedido = buscarPorId(idPedido);

     if(pedido != null){
         pedido.adicionarItem(item);
     }
    }
}
