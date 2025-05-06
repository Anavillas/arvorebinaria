public class Arvore {
    private Folha folha;
    private Arvore esquerda;
    private Arvore direita;

    public Arvore(){
        this.folha = null;
        this.esquerda = null;
        this.direita = null;
    }

    public Arvore(Folha folha){
        this.folha = folha;
        this.esquerda = null;
        this.direita = null;
    }

    public boolean isEmpty(){
        return this.folha == null;
    }
    public void inserir(Folha nova){
        if(isEmpty()){
            this.folha = nova;
        } else {
            Arvore novaArvore = new Arvore(nova);
            if (nova.getValor() < this.folha.getValor()){
                if (this.esquerda == null){
                    this.esquerda = novaArvore;
                    System.out.println("Folha: "+nova.getValor()+" a esquerda de: "+this.folha.getValor());
                } else {
                    this.esquerda.inserir(nova);
                }
            } else if (nova.getValor() > this.folha.getValor()) {
                if (this.direita == null){
                    this.direita = novaArvore;
                    System.out.println("Folha: "+nova.getValor()+" a direita de: "+this.folha.getValor());

                } else {
                    this.direita.inserir(nova);
                }
            }
        }
    }

}
