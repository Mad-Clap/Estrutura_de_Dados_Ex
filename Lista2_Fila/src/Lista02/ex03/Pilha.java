package Lista02.ex03;

import java.util.Vector;

public class Pilha<E> {
    private int tamanho;
    private int topo;
    private Vector<E> vetor;

    public Pilha (int tamanho){
        this.topo = -1;
        this.tamanho = tamanho;
        this.vetor = new Vector<>(tamanho);
    }


    public boolean pilhaVazia()
    {
        return topo == -1 ? true : false;
    }

    public boolean pilhaCheia()
    {
        return topo == tamanho - 1 ? true : false;
    }

    public E pop() {
        E elemento;

        if (this.pilhaVazia()){return null;}

        elemento = vetor.get(topo--);
        return elemento;
    }

    public boolean push(E elemento) {
        if (this.pilhaCheia()) {return false;}

        vetor.add(++topo, elemento);
        return true;
    }

    public E retornaTopo() {
            E elemento = null;
        if(!this.pilhaVazia()) {
            elemento = vetor.get(topo);
        }
        else {
            System.out.println("Pilha vazia.");
        }

        return elemento;
    }

    public int getTopo() {
        return topo;
    }


}
