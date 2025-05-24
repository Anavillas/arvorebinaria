//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Nozinho<Character> raiz = new Nozinho<>('A');

        Nozinho<Character> esquerdo = new Nozinho<>('B');
        Nozinho<Character> direito = new Nozinho<>('C');

        raiz.setLeft(esquerdo);
        raiz.setRight(direito);

        esquerdo.setLeft(new Nozinho<>('D'));
        esquerdo.setRight(new Nozinho<>('E'));
        direito.setRight(new Nozinho<>('F'));

    }
}