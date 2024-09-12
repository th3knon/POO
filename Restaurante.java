package com.mycompany.restaurante;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {

    public static class Cliente {
        private String nome;
        private String endereco;
        private String telefone;

        public Cliente(String nome, String endereco, String telefone) {
            this.nome = nome;
            this.endereco = endereco;
            this.telefone = telefone;
        }

        public void registrarCliente(String nome, String endereco, String telefone) {
            this.nome = nome;
            this.endereco = endereco;
            this.telefone = telefone;
        }

        public void vizualizarCliente() {
            System.out.println("Nome: " + nome);
            System.out.println("Endereço: " + endereco);
            System.out.println("Telefone: " + telefone);
        }
    }

    public static class ItemMenu {
        private String nome;
        private Double preco;

        public ItemMenu(String nome, Double preco) {
            this.nome = nome;
            this.preco = preco;
        }

        public String getDetalhesItem() {
            return nome + " - R$ " + preco;
        }

        public double calcularPreco() {
            return preco;
        }
    }

    public static class Pedido {
        private ArrayList<ItemMenu> itens;
        private Cliente cliente;
        private double total;
        private String status;

        public Pedido(Cliente cliente) {
            this.cliente = cliente;
            this.itens = new ArrayList<>();
            this.total = 0.0;
            this.status = "Pendente";
        }

        public void adicionarItem(ItemMenu item) {
            itens.add(item);
            calcularTotal();
        }

        public void calcularTotal() {
            total = 0.0;
            for (ItemMenu item : itens) {
                total += item.calcularPreco();
            }
        }

        public void vizualizarPedido() {
            System.out.println("Cliente: ");
            cliente.vizualizarCliente();
            System.out.println("Itens: ");
            for (ItemMenu item : itens) {
                System.out.println(item.getDetalhesItem());
            }
            System.out.println("TOTAL: R$ " + total);
            System.out.println("STATUS: " + status);
        }

        public void atualizarStatus(String status) {
            this.status = status;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Cliente[] clientes = new Cliente[10];
        ItemMenu[] menu = new ItemMenu[10];
        Pedido[] pedidos = new Pedido[10];

        int clienteCount = 0;
        int menuCount = 0;
        int pedidoCount = 0;
        Cliente clienteAtual = null;
        Pedido pedidoAtual = null;

        menu[menuCount++] = new ItemMenu("Hambúrguer", 15.0);
        menu[menuCount++] = new ItemMenu("Pizza", 25.0);
        menu[menuCount++] = new ItemMenu("Suco", 7.0);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1- Cadastrar cliente");
            System.out.println("2- Visualizar menu");
            System.out.println("3- Adicionar itens ao pedido");
            System.out.println("4- Finalizar pedido");
            System.out.println("5- Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    
                    System.out.println("Digite o nome do cliente:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o endereço do cliente:");
                    String endereco = scanner.nextLine();
                    System.out.println("Digite o telefone do cliente:");
                    String telefone = scanner.nextLine();

                    clientes[clienteCount++] = new Cliente(nome, endereco, telefone);
                    clienteAtual = clientes[clienteCount - 1];
                    pedidoAtual = new Pedido(clienteAtual);
                    System.out.println("Cliente cadastrado com sucesso.");
                    break;

                case 2:
                    
                    System.out.println("Menu:");
                    for (int i = 0; i < menuCount; i++) {
                        System.out.println((i + 1) + "- " + menu[i].getDetalhesItem());
                    }
                    break;

                case 3:
                    if (clienteAtual == null) {
                        System.out.println("Nenhum cliente cadastrado. Por favor, cadastre um cliente primeiro.");
                        break;
                    }
                    
                    System.out.println("Digite o número do item para adicionar ao pedido:");
                    int itemEscolhido = scanner.nextInt();
                    scanner.nextLine(); 

                    if (itemEscolhido < 1 || itemEscolhido > menuCount) {
                        System.out.println("Número de item inválido.");
                        break;
                    }

                    ItemMenu itemSelecionado = menu[itemEscolhido - 1];
                    pedidoAtual.adicionarItem(itemSelecionado);
                    System.out.println("Item adicionado ao pedido.");
                    break;

                case 4:
                    if (pedidoAtual == null) {
                        System.out.println("Nenhum pedido criado. Por favor, crie um pedido primeiro.");
                        break;
                    }
                    
                    pedidoAtual.atualizarStatus("Finalizado");
                    pedidoAtual.vizualizarPedido();
                    pedidoAtual = null;
                    clienteAtual = null;
                    System.out.println("Pedido finalizado.");
                    break;

                case 5:
                    
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
