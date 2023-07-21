package Lista02.ex04;

public class FilaEx04 {
    protected int tamanho;	/* Tamanho do vetor */
    protected int[] vetor;	/* Vetor de elementos */
    protected int ini;	/* Posicao do proximo elemento a ser retirado */
    protected int n;	/* Numero de elementos na fila */

    public FilaEx04(int tam)
    {
        tamanho = tam;
        vetor = new int[tamanho];
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
    public int remove()
    {
        int elemento = Integer.MIN_VALUE;

        if (!this.vazia())
        {
            elemento = vetor[ini];
            ini = (ini + 1) % tamanho;
            n--;
        }

        return elemento;
    }

    //Inserimos o elemento no final da fila
    public boolean insere(int elemento)
    {
        int fim;

        if ( !cheia() ) {
            fim = (ini + n) % tamanho;
            vetor[fim] = elemento;
            n++;
            return true;
        }
        else
            return false;
    }
    //Método pedido no exercício para retornar uma fila dupla com os elementos de uma fila simples
    // previamente instanciada
    public static FilaDupla retornaFilaDupla(FilaEx04 filaSimples){
        FilaDupla filaRetornar = new FilaDupla(filaSimples.tamanho);
        while (!filaSimples.vazia()){
            filaRetornar.insere(filaSimples.remove());
        }
        return filaRetornar;
    }
}
