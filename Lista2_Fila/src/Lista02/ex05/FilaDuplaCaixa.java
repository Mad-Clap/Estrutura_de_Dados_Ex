package Lista02.ex05;

public class FilaDuplaCaixa extends FilaCaixa {
    //A FilaDuplaCaixa extende a FilaCaixa e também recebe objetos da classe Clientes
    public FilaDuplaCaixa(int tam)
    {
        super(tam);
    }

    public boolean insereInicio(Cliente elemento)
    {
        int prec;

        if (!cheia())
        {
            /* Insere na posição precedente ao início */
            prec = (ini - 1 + tamanho) % tamanho;
            vetor[prec] = elemento;
            ini = prec; /* Atualiza �ndice para in�cio */
            n++;
            return true;
        }
        else
            return false;
    }

    public Cliente removeFim()
    {
        Cliente elemento = null;
        int ult;

        if (!this.vazia())
        {
            /* Retira o último elemento */
            ult = (ini + n - 1) % tamanho;
            elemento = vetor[ult];
            n--;
        }

        return elemento;
    }
}
