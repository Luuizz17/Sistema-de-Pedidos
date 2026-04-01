package service;

import model.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class ClienteService {
    Scanner sc = new Scanner(System.in);
    ArrayList<Cliente> clientes = new ArrayList<>();

    public void cadastrarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void listarCliente(){
        for(Cliente cliente : clientes){
            System.out.println(cliente);
        }
    }

    public Cliente buscarPorId(int id){
        for(Cliente cliente : clientes){
            if(cliente.getId() == id){
               return cliente;
            }
        }
        return null;
    }
    public void removerCliente(int id){
        Cliente cliente = buscarPorId(id);

        if(cliente != null){
            clientes.remove(cliente);
        }
    }

}
