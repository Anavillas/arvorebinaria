package primeiraAtividade;

public class Nozinho<T> {
    private T conteudo;
    private Nozinho<T> left;
    private Nozinho<T> right;

    public Nozinho(T conteudo) {
        this.conteudo = conteudo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public Nozinho<T> getLeft() {
        return left;
    }

    public void setLeft(Nozinho<T> left) {
        this.left = left;
    }

    public Nozinho<T> getRight() {
        return right;
    }

    public void setRight(Nozinho<T> right) {
        this.right = right;
    }
}
