package ERP.Cadastro;

import ERP.Produto.Produto;
import ERP.Usuarios.Usuario;

import java.util.ArrayList;

public class Cadastro {

    private final ArrayList<Produto> produtos = new ArrayList<>();

    public void listarProdutos() {

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (Produto p : produtos) {
            System.out.println(
                    "Nome: " + p.getNome() +
                            " | Preço: " + p.getPreco() +
                            " | Quantidade: " + p.getQuantidade()
            );
        }
    }

    public Produto buscarProduto(String nome) {

        if (nome == null || nome.isBlank()) {
            return null;
        }

        for (Produto p : produtos) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }

        return null;
    }

    public void adicionarProduto(Produto produto, Usuario usuario) {

        if (produto == null) {
            System.out.println("Produto inválido.");
            return;
        }

        if (!usuario.getTipo().equals("GERENTE")) {
            System.out.println("Acesso negado. Apenas gerente pode adicionar produtos.");
            return;
        }

        Produto existente = buscarProduto(produto.getNome());

        if (existente == null) {
            produtos.add(produto);
            System.out.println("Produto adicionado.");
        } else {
            System.out.println("Produto já existe.");
        }
    }

    public void removerProduto(String nome, Usuario usuario) {

        Produto p = buscarProduto(nome);

        if (!usuario.getTipo().equals("GERENTE")) {
            System.out.println("Acesso negado. Apenas gerente pode adicionar produtos.");
            return;
        }

        if (p != null) {
            produtos.remove(p);
            System.out.println("Produto removido.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void atualizarPreco(String nome, float novoPreco, Usuario usuario) {

        Produto p = buscarProduto(nome);

        if (!usuario.getTipo().equals("GERENTE")) {
            System.out.println("Acesso negado. Apenas gerente pode adicionar produtos.");
            return;
        }

        if (p != null) {

            boolean sucesso = p.alterarPreco(novoPreco);

            if (sucesso) {
                System.out.println("Preço atualizado.");
            } else {
                System.out.println("Falha ao atualizar preço.");
            }

        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void adicionarEstoque(String nome, int quantidade) {

        Produto p = buscarProduto(nome);

        if (p != null) {

            boolean sucesso = p.adicionarEstoque(quantidade);

            if (sucesso) {
                System.out.println("Estoque atualizado.");
            } else {
                System.out.println("Falha ao adicionar estoque.");
            }

        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void removerEstoqueProduto(String nome, int quantidade) {

        Produto p = buscarProduto(nome);

        if (p != null) {

            boolean sucesso = p.removerEstoque(quantidade);

            if (sucesso) {
                System.out.println("Estoque atualizado.");
            } else {
                System.out.println("Falha ao remover estoque.");
            }

        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}
