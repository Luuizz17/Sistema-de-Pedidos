package service;

import model.Produto;

import java.util.ArrayList;
import java.util.Scanner;

public class ProdutoService {

    Scanner sc = new Scanner(System.in);
    ArrayList<Produto> produtos = new ArrayList<>();

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void listarProduto() {
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    public Produto buscarPorId(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;

            }
        }
        return null;
    }

    public void atualizarEstoque(int id , int novoEstoque) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produto.setEstoque(novoEstoque);
            }
        }
    }

    public void removerProduto(int id){
        Produto produto = buscarPorId(id);

        if(produto != null){
            produtos.remove(produto);
        }
    }

}