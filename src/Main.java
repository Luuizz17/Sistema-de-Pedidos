import Enums.StatusPedido;

import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import model.Produto;

import service.ClienteService;
import service.PedidoService;
import service.ProdutoService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ClienteService clienteService = new ClienteService();
        ProdutoService produtoService = new ProdutoService();
        PedidoService pedidoService = new PedidoService();

        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE PEDIDOS =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Cadastrar produto");
            System.out.println("4 - Listar produtos");
            System.out.println("5 - Criar pedido");
            System.out.println("6 - Adicionar item ao pedido");
            System.out.println("7 - Listar pedidos");
            System.out.println("8 - Alterar status do pedido");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n=== CADASTRAR CLIENTE ===");
                    Cliente cliente = new Cliente();

                    System.out.print("ID do cliente: ");
                    cliente.setId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Nome do cliente: ");
                    cliente.setNome(sc.nextLine());

                    System.out.print("Email do cliente: ");
                    cliente.setEmail(sc.nextLine());

                    clienteService.cadastrarCliente(cliente);
                    System.out.println("Cliente cadastrado com sucesso.");
                    break;

                case 2:
                    System.out.println("\n=== LISTA DE CLIENTES ===");
                    clienteService.listarCliente();
                    break;

                case 3:
                    System.out.println("\n=== CADASTRAR PRODUTO ===");
                    Produto produto = new Produto();

                    System.out.print("ID do produto: ");
                    produto.setId(sc.nextInt());
                    sc.nextLine();

                    System.out.print("Nome do produto: ");
                    produto.setNome(sc.nextLine());

                    System.out.print("Preço do produto: ");
                    produto.setPreco(sc.nextDouble());

                    System.out.print("Estoque do produto: ");
                    produto.setEstoque(sc.nextInt());
                    sc.nextLine();

                    produtoService.cadastrarProduto(produto);
                    System.out.println("Produto cadastrado com sucesso.");
                    break;

                case 4:
                    System.out.println("\n=== LISTA DE PRODUTOS ===");
                    produtoService.listarProduto();
                    break;

                case 5:
                    System.out.println("\n=== CRIAR PEDIDO ===");

                    System.out.print("ID do pedido: ");
                    int idPedido = sc.nextInt();
                    sc.nextLine();

                    System.out.print("ID do cliente: ");
                    int idCliente = sc.nextInt();
                    sc.nextLine();

                    Cliente clientePedido = clienteService.buscarPorId(idCliente);

                    if (clientePedido != null) {
                        Pedido pedido = new Pedido(idPedido, clientePedido);
                        pedidoService.criarPedido(pedido);
                        System.out.println("Pedido criado com sucesso.");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("\n=== ADICIONAR ITEM AO PEDIDO ===");

                    System.out.print("ID do pedido: ");
                    int pedidoId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("ID do produto: ");
                    int produtoId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Quantidade: ");
                    int quantidade = sc.nextInt();
                    sc.nextLine();

                    Produto produtoPedido = produtoService.buscarPorId(produtoId);
                    Pedido pedidoEncontrado = pedidoService.buscarPorId(pedidoId);

                    if (produtoPedido != null && pedidoEncontrado != null) {
                        if (produtoPedido.getEstoque() >= quantidade) {
                            ItemPedido item = new ItemPedido(produtoPedido, quantidade);
                            pedidoService.adicionarItemNoPedido(pedidoId, item);

                            produtoPedido.setEstoque(produtoPedido.getEstoque() - quantidade);

                            System.out.println("Item adicionado ao pedido com sucesso.");
                        } else {
                            System.out.println("Estoque insuficiente.");
                        }
                    } else {
                        System.out.println("Pedido ou produto não encontrado.");
                    }
                    break;

                case 7:
                    System.out.println("\n=== LISTA DE PEDIDOS ===");
                    pedidoService.listarPedidos();
                    break;

                case 8:
                    System.out.println("\n=== ALTERAR STATUS DO PEDIDO ===");

                    System.out.print("ID do pedido: ");
                    int idAlterar = sc.nextInt();
                    sc.nextLine();

                    System.out.println("1 - PENDENTE");
                    System.out.println("2 - PAGO");
                    System.out.println("3 - ENVIADO");
                    System.out.println("4 - CANCELADO");
                    System.out.print("Escolha o novo status: ");
                    int statusOpcao = sc.nextInt();
                    sc.nextLine();

                    StatusPedido novoStatus = null;

                    switch (statusOpcao) {
                        case 1:
                            novoStatus = StatusPedido.PENDENTE;
                            break;
                        case 2:
                            novoStatus = StatusPedido.PAGO;
                            break;
                        case 3:
                            novoStatus = StatusPedido.ENVIADO;
                            break;
                        case 4:
                            novoStatus = StatusPedido.CANCELADO;
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }

                    if (novoStatus != null) {
                        pedidoService.alterarStatus(idAlterar, novoStatus);
                        System.out.println("Status alterado com sucesso.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}