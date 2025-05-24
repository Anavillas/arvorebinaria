import java.util.LinkedList;
import java.util.Queue;

public class Atividade {
    public static void main(String[] args){
        Tree arvore = new Tree();

        Node raiz = new Node("A");
        raiz.setLeft(new Node("B"));
        raiz.setRight(new Node("C"));

        raiz.getLeft().setLeft(new Node("D"));
        raiz.getLeft().setRight(new Node("E"));
        raiz.getRight().setRight(new Node("F"));

        arvore.setRaiz(raiz);

        int total = arvore.countNode();
        System.out.println("Total de nós na árvore: " + total);
        System.out.println("\nPre-Order ");
        arvore.preOrder();
        System.out.println("\nIn-Order ");
        arvore.inOrder();
        System.out.println("\nPost-Order ");
        arvore.postOrder();
        System.out.println("\nBusca por nível ");
        arvore.breadthFirst();
    }
}

class Node {
    String content;
    Node left, right;

    public Node(String content){
        this.content = content;
        left = right = null;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}

class Tree {
    private Node raiz;

    public void setRaiz(Node raiz) {
        this.raiz = raiz;
    }

    public Node getRaiz() {
        return raiz;
    }

    public int countNode() {
        return countNode(raiz);
    }

    private int countNode(Node node){
        if(node == null) return 0;
        return 1 + countNode(node.getLeft()) + countNode(node.getRight());
    }

    public void preOrder(){
        preOrder(raiz);
    }
    public void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.content + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(){
        inOrder(raiz);
    }
    public void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.println(node.content + " ");
            inOrder(node.right);
        }
    }

    public void postOrder(){
        postOrder(raiz);
    }
    public void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.content + " ");
        }
    }
    public void breadthFirst(){
        if(raiz == null) return;

        Queue<Node> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()){
            Node atual = fila.poll();
            System.out.println(atual.content + " ");

            if (atual.left != null) fila.add(atual.left);
            if (atual.right != null) fila.add(atual.right);
        }
    }
}
