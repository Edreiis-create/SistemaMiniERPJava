package ERP.Produto;

public class Produto {

    private String nome;
    private float preco;
    private int quantidade;

    public Produto(String nome, float preco, int quantidade) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido.");
        }

        if (preco <= 0) {
            throw new IllegalArgumentException("Preço inválido.");
        }

        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade inválida.");
        }

        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public boolean adicionarEstoque(int novaQuantidade) {

        if (novaQuantidade <= 0) {
            System.out.println("Valor inválido.");
            return false;
        }

        this.quantidade += novaQuantidade;
        return true;
    }

    public boolean removerEstoque(int novaQuantidade) {

        if (novaQuantidade <= 0) {
            System.out.println("Valor inválido.");
            return false;
        }

        if (novaQuantidade > this.quantidade) {
            System.out.println("Estoque insuficiente.");
            return false;
        }

        this.quantidade -= novaQuantidade;
        return true;
    }

    public boolean alterarPreco(float novoPreco) {

        if (novoPreco <= 0) {
            System.out.println("Preço inválido.");
            return false;
        }

        this.preco = novoPreco;
        return true;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
