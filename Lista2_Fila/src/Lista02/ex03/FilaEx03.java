package Lista02.ex03;
import java.util.Vector;

public class FilaEx03<E> {
    protected int tamanho;	/* Tamanho do vetor */
    protected Vector<E> vetor;	/* Vetor de elementos */
    protected int ini;	/* Posicao do proximo elemento a ser retirado */
    protected int n;	/* Numero de elementos na fila */

    public FilaEx03(int tam)
    {
        tamanho = tam;
        vetor = new Vector<>(tamanho);
        ini = 0;
        n = 0;
    }

    public boolean vazia()
    {
        return (n == 0);
    }

    public boolean cheia()
    {
        return (n == tamanho);
    }

    //Retiramos o elemento do início da fila
    public E remove()
    {
        E elemento = null;

        if (!this.vazia())
        {
            elemento = vetor.get(ini);
            ini = (ini + 1) % tamanho;
            n--;
        }

        return elemento;
    }

    //Inserimos o elemento no final da fila
    public boolean insere(E elemento)
    {
        int fim;

        if ( !cheia() ) {
            fim = (ini + n) % tamanho;
            vetor.add(fim, elemento);
            n++;
            return true;
        }
        else
            return false;
    }


}
