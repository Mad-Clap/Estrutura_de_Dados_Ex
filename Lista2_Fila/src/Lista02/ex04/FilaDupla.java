package Lista02.ex04;

public class FilaDupla extends FilaEx04 {
    public FilaDupla(int tam)
    {
        super(tam);
    }

    public boolean insereInicio(int elemento)
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

    public int removeFim()
    {
        int elemento = Integer.MIN_VALUE;
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
