package Ex01;

public class Pilha {
    private int tamanho;
    private int topo;
    private int vetor[];
    private int qtdInteirosPar;

    public Pilha (int tamanho){
        this.topo = -1;
        this.tamanho = tamanho;
        this.vetor = new int[tamanho];
        this.qtdInteirosPar = 0; // Conta quantos inteiros pares estão armazenados na pilha
    }


    public boolean pilhaVazia()
    {
        return topo == -1 ? true : false;
    }

    public boolean pilhaCheia()
    {
        return topo == tamanho - 1 ? true : false;
    }

    public int pop() {
        int elemento;

        if (this.pilhaVazia()){return Integer.MIN_VALUE;}

        elemento = vetor[topo--];

        if(elemento%2==0) qtdInteirosPar-=1; // Decrementa o inteiro par tirado da pilha
        return elemento;
    }

    public boolean push(int elemento) {
        if (this.pilhaCheia()) {return false;}

        vetor[++topo]= elemento;

        if(elemento%2==0) qtdInteirosPar+=1; // incrementa o inteiro par adicionado na pilha
        return true;
    }

    public int retornaTopo() {
            int elemento = Integer.MIN_VALUE;
        if(!this.pilhaVazia()) {
            elemento = vetor[topo];
        }
        else {
            System.out.println("Pilha vazia.");
        }

        return elemento;
    }

    public int getTopo() {
        return topo;
    }

    public int getQtdInteirosPar() {
        return qtdInteirosPar;
    }
}
