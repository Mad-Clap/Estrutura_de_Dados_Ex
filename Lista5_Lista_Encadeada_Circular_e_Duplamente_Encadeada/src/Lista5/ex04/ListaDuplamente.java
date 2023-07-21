package Lista5.ex04;

public class ListaDuplamente {

    /* Referência para primeiro elemento */
    protected Elo prim;

    protected class Elo
    {
        protected int dado;
        protected Elo ant;
        protected Elo prox;

        public Elo()
        {
            ant = null;
            prox = null;
        }

        public Elo(int elem)
        {
            dado = elem;
            ant = null;
            prox = null;
        }

        public Elo(int elem, Elo antElem, Elo proxElem)
        {
            dado = elem;
            ant = antElem;
            prox = proxElem;
        }
    }

    public ListaDuplamente()
    {
        prim = null;
    }

    /* Testa se a lista está vazia. */
    public boolean vazia()
    {
        return prim == null;
    }

    /* Insere elemento no in�cio da lista. */
    public void insere(int novo)
    {
        Elo p;

        p = new Elo(novo);

        p.prox = prim;

        p.ant = null;

        if (prim != null)
            prim.ant = p;

        prim = p;
    }

    /* Método auxiliar para busca. */
    private Elo busca(int elem)
    {
        Elo p = null;

        for( p = prim; ((p != null) && (p.dado != elem)); p = p.prox);

        return p;
    }

    /* Remove da lista o primeiro elemento com valor igual a "elem". Retorna true se removeu. */
    public boolean remove(int elem)
    {
        Elo p = null;
        p = busca(elem);

        if (p == null) return false;

        /* Retira primeiro elemento */
        if (p == prim)
            prim = prim.prox;
        else
            /* Retira elemento do meio */
            p.ant.prox = p.prox;

        /* Testa  se é ultimo elemento */
        if (p.prox != null)
            p.prox.ant = p.ant;

        p = null;

        return true;
    }

    /* Imprime todos os elementos da lista. */
    public void imprime()
    {
        Elo p;

        System.out.println("Elementos da lista:");

        for(p = prim; p != null; p = p.prox)
        {
            System.out.print(p.dado + " ");
        }

        System.out.println();
    }

    /* Imprime todos os elementos da lista em ordem reversa. */
    public void imprimeReversa()
    {
        Elo p;
        Elo ult = null;

        System.out.println("Elementos da lista em ordem reversa:");

        p = prim;

        while(p != null)
        {
            ult = p;
            p = p.prox;
        }

        for(p = ult; p != null; p = p.ant)
        {
            System.out.print(p.dado + " ");
        }

        System.out.println();
    }

    //RESPOSTA DO EXERCICIO 4
    public void trocaElos(int indiceElo1, int indiceElo2){

        if(indiceElo1==indiceElo2) return;

        Elo elo1=null;
        Elo elo2=null;
        Elo p;
        int percorreLista=0;

        for (p = prim; p != null; p = p.prox) {
            // Testes para saber se encontrou a referência correta
            if (percorreLista == indiceElo1) {
                elo1 = p;
            } else if (percorreLista == indiceElo2) {
                elo2 = p;
            }
            percorreLista++;
        }

        //Se um dos elementos não existirem na lista, encerra o método
        if(elo1 == null || elo2 == null) return;

        //Realiza a troca entre elos consecutivos
        if(elo1.prox == elo2){
            Elo anterior, proximo;
            anterior = elo1.ant;
            proximo = elo2.prox;

            anterior.prox = elo2;
            elo1.ant = elo2;
            elo2.prox = elo1;
            elo1.prox = proximo;

        } else if(elo1.ant == elo2){
            Elo anterior, proximo;
            anterior = elo2.ant;
            proximo = elo1.prox;

            anterior.prox = elo1;
            elo2.ant = elo1;
            elo1.prox = elo2;
            elo2.prox = proximo;

        } else{
            //Realiza a troca de elos não consecutivos

            Elo anterior, proximo;
            anterior = elo1.ant;
            proximo = elo1.prox;

            elo1.ant = elo2.ant;
            elo1.prox = elo2.prox;

            if (elo2.ant != null) elo2.ant.prox = elo1;

            if (elo2.prox != null) elo2.prox.ant = elo1;

            elo2.ant = anterior;
            elo2.prox = proximo;

            if (anterior != null) anterior.prox = elo2;

            if (proximo != null) proximo.ant = elo2;

            //Testa de um dos elos não é prim, trocando a referência do prim se for
            if (prim == elo1) {
                prim = elo2;
            } else if (prim == elo2) {
                prim = elo1;
            }
        }
    }

}
