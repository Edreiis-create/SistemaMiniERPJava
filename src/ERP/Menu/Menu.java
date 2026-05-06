package ERP.Menu;

import ERP.Cadastro.Cadastro;
import ERP.Produto.Produto;
import ERP.Usuarios.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Cadastro cadastro = new Cadastro();

        ArrayList<Usuario> usuarios = new ArrayList<>();

        usuarios.add(new Usuario("Admin", "GERENTE", "123", 1));
        usuarios.add(new Usuario("Admin2", "FUNCIONARIO", "567", 2));
        usuarios.add(new Usuario("Admin3", "GERENTE", "101112", 3));
        usuarios.add(new Usuario("Admin4", "FUNCIONARIO", "8910", 4));

        Usuario usuarioAtual = null;

        int tentativas = 3;
        boolean senhavalida = false;

        while (tentativas > 0 && !senhavalida) {

            System.out.println("Nome: ");
            String n = entrada.nextLine();

            Usuario encontrado = null;

            for (Usuario u : usuarios) {
                if (u.getNome().equalsIgnoreCase(n)) {
                    encontrado = u;
                    break;
                }
            }

            if (encontrado != null) {

                while (!senhavalida && tentativas > 0) {

                    System.out.println("Senha: ");
                    String senha = entrada.nextLine();

                    if (senha.equals(encontrado.getSenha())) {
                        senhavalida = true;
                        usuarioAtual = encontrado;

                        System.out.println("Login realizado com sucesso!");
                        System.out.println("Bem-vindo, " + usuarioAtual.getNome());

                    } else {
                        tentativas--;
                        System.out.println("Senha incorreta. Tentativas: " + tentativas);
                    }
                }

            } else {
                tentativas--;
                System.out.println("Usuário não encontrado. Tentativas: " + tentativas);
            }

            if (tentativas == 0) {
                System.out.println("Acesso bloqueado.");
                System.exit(0);
            }
        }

        int opcao;

        do {
            System.out.println("""
                MENU
                1 - Cadastro
                2 - Sair
            """);

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {

                case 1 -> menuCadastro(entrada, cadastro, usuarioAtual);

                case 2 -> System.out.println("Saindo...");

                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 2);

        entrada.close();
    }

    public static void menuCadastro(Scanner entrada, Cadastro cadastro, Usuario usuarioAtual) {

        int opcao;

        do {
            System.out.println("""
                --- CADASTRO ---
                1 - Adicionar Produto
                2 - Listar Produtos
                3 - Buscar Produto
                4 - Remover Produto
                5 - Atualizar Preço
                6 - Adicionar Estoque
                7 - Remover Estoque
                0 - Voltar
            """);

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {

                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = entrada.nextLine();

                    System.out.print("Preço: ");
                    float preco = entrada.nextFloat();

                    System.out.print("Quantidade: ");
                    int qtd = entrada.nextInt();
                    entrada.nextLine();

                    Produto p = new Produto(nome, preco, qtd);

                    cadastro.adicionarProduto(p, usuarioAtual);
                }

                case 2 -> cadastro.listarProdutos();

                case 3 -> {
                    System.out.print("Nome: ");
                    String nome = entrada.nextLine();

                    Produto encontrado = cadastro.buscarProduto(nome);

                    if (encontrado != null) {
                        System.out.println(
                                "Nome: " + encontrado.getNome() +
                                        " | Preço: " + encontrado.getPreco() +
                                        " | Quantidade: " + encontrado.getQuantidade()
                        );
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                }

                case 4 -> {
                    System.out.print("Nome: ");
                    String nome = entrada.nextLine();
                    cadastro.removerProduto(nome, usuarioAtual);
                }

                case 5 -> {
                    System.out.print("Nome: ");
                    String nome = entrada.nextLine();

                    System.out.print("Novo preço: ");
                    float novoPreco = entrada.nextFloat();
                    entrada.nextLine();

                    cadastro.atualizarPreco(nome, novoPreco, usuarioAtual);
                }

                case 6 -> {
                    System.out.print("Nome: ");
                    String nome = entrada.nextLine();

                    System.out.print("Quantidade: ");
                    int addQtd = entrada.nextInt();
                    entrada.nextLine();

                    cadastro.adicionarEstoque(nome, addQtd);
                }

                case 7 -> {
                    System.out.print("Nome: ");
                    String nome = entrada.nextLine();

                    System.out.print("Quantidade: ");
                    int remQtd = entrada.nextInt();
                    entrada.nextLine();

                    cadastro.removerEstoqueProduto(nome, remQtd);
                }

                case 0 -> System.out.println("Voltando...");

                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}