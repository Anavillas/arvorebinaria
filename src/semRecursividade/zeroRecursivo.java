package semRecursividade;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class zeroRecursivo {
    public static void main(String args[]){
        Tree tree = new Tree();
        tree.raiz = new Node(1);
        tree.raiz.setLeft(new Node(2));
        tree.raiz.setRight(new Node(3));
        tree.raiz.getLeft().setLeft(new Node(4));
        tree.raiz.getLeft().setRight(new Node(5));

        System.out.println(tree.countNode());
        tree.searchPosOrder(tree.raiz);
    }
}


class Node{
    private int content;
    private Node left;
    private Node right;
    boolean visited;

    public Node(int content){
        this.content = content;
        this.left = null;
        this.right = null;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
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

class Tree{
    Node raiz;

    public Tree(){
        this.raiz = null;
    }

    //Pesquisei código no site geekforgeeks, portanto vou explicar
    // o que estou fazendo. Usando root pra representar folhas dos nós.
    public int countNode(){

        if(raiz == null) return 0;

        //Iniciei uma lista vazia para guardar os nós
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(raiz);

        int count = 0;

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            count ++;

            if (temp.getLeft() != null){
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null){
                queue.add(temp.getRight());
            }
        }
        return  count;
    }

    public void searchPreOrder(){
        if (raiz == null){
            System.out.printf("Nada");
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(raiz);

        while (!stack.isEmpty()){
            Node node = stack.pop();
            System.out.println(node.getContent() + " ");

            if(node.getRight()!= null){
                stack.push(node.getRight());
            }
            if (node.getLeft() != null){
                stack.push(node.getLeft());}
        }
        System.out.println();
    }
    public void searchInOrder() {
        if (raiz == null) {
            System.out.println("Nada");
            return;
        }
        var stack = new Stack<Node>();
        Node current = raiz;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeft();
            }
            current = stack.pop();
            System.out.printf(current.getContent() + " ");
            current = current.getRight();
        }
    }

    //Stack overflow salvou demais - depois que eu vi o seu exemplo, cheguei a conclusão q não salvou não
    //esse head, é a raiz no caso, a gente vai recebendo os nós
    public void searchPosOrder(Node head){
        if(head == null){//se o nó for vazio ent retorna vazio
            return;
        }

        //Aqui a gente vai utilizar uma pilha
        LinkedList<Node> stack = new LinkedList<Node>();
        stack.push(head); //A raiz da árvore é o primeiro elemento empilhado a base

        while (!stack.isEmpty()){
            Node next = stack.peek();

            boolean finishedSubtrees = (next.getRight() == head || next.getLeft() == head);
            boolean isLeaf = (next.getLeft() == null && next.getRight() == null);
            if (finishedSubtrees || isLeaf){
                stack.pop();
                System.out.println(next.getContent());
                head = next;
            }
            else {
                if (next.getRight() != null) {
                    stack.push(next.getRight());
                }
                if (next.getLeft() != null) {
                    stack.push(next.getLeft());
                }
            }
        }

    }
    public void searcBreadthFirst(){
        if(raiz == null) return;

        Queue<Node> fila = new LinkedList<>();
        fila.add(raiz);

        while(!fila.isEmpty()){
            Node atual = fila.poll();
            System.out.println(atual.getContent() + " ");

            if(atual.getLeft() != null) fila.add(atual.getLeft());
            if(atual.getLeft() != null) fila.add(atual.getRight());
            //se o atual que pegamos for diferente de nulo, vamos adicionar a direita ou esq dele
        }
    }
}

