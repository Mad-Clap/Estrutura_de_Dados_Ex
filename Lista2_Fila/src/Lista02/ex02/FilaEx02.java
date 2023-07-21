package Lista02.ex02;

public class FilaEx02 {
    protected int tamanho;	/* Tamanho do vetor */
    protected int[] vetor;	/* Vetor de elementos */
    protected int ini;	/* Posicao do proximo elemento a ser retirado */
    protected int n;	/* Numero de elementos na fila */

    public FilaEx02(int tam)
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

    public void combinaFilas(FilaEx02 f1, FilaEx02 f2) {
        while (!this.cheia()){

            //Transfere os elementos das filas f1 e f2 para a fila mista.
            // Caso uma fique vazia e a outra não o loop continua e adiciona os elementos restantes
            // da lista que ainda não estiver vazia direto, isso caso a fila mista não estiver cheia

            if(!f1.vazia()) this.insere(f1.remove());
            if(!f2.vazia()) this.insere(f2.remove());

            if(f1.vazia() && f2.vazia()) break;
        }
        //Se f1 ou f2 não estiverem vazias a tranferências de elementos foi realizada parcialmente,
        // o que será acusado por meio de um print
        if (!f1.vazia() || !f2.vazia()) {
            System.out.println("Transferência realizada parcialmente, a fila está cheia\n");
        }
    }
}
