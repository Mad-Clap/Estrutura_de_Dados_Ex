package Lista02.ex01;

public class FilaProcessos {
    private int ini;
    private int n;
    private Processo [] vetor;
    private int tamanho;


    public FilaProcessos(int tamanho) {
        this.ini = 0;
        this.n = 0;
        this.vetor = new Processo [tamanho];
        this.tamanho=tamanho;
    }


    public boolean vazia() { return (n == 0);}

    public boolean cheia() { return (n == tamanho);}

    public boolean insere(Processo processo) {
        int fim;

        if ( !cheia() ) {
            fim = (ini + n) % tamanho;
            vetor[fim] = processo;
            n++;
            return true;
        }
        else
            return false;
    }

    public Processo remove() {
        Processo processo = null;

        if (!this.vazia())
        {
            processo = vetor[ini];
            ini = (ini + 1) % tamanho;
            n--;
        }

        return processo;
    }

    public Processo removeFim() {
        Processo elemento = null;
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

    public boolean ImprimeVetorProcessos(){
        int printN = this.n;
        int printIni = this.ini;

        if(!this.vazia()){
            while (printN>0){
                int print = this.vetor[printIni].getNumeroIdentificador();
                printIni = (printIni + 1) % tamanho;
                printN--;
                System.out.println("Processo "+print+" em fila para execução");
            }
            return true;
        }
        return false;
    }
}
