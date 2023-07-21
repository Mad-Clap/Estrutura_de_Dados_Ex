package Lista5.ex02;

public class Lista {

        /* Referência para primeiro elemento */
        protected Elo prim;

        protected class Elo
        {
            protected int dado;
            protected Elo prox;

            public Elo()
            {
                prox = null;
            }

            public Elo(int elem)
            {
                dado = elem;
                prox = null;
            }

            public Elo(int elem, Elo proxElem)
            {
                dado = elem;
                prox = proxElem;
            }
        }

        public Lista()
        {
            prim = null;
        }

        /* Testa se a lista está vazia. */
        public boolean vazia()
        {
            return prim == null;
        }

        /* Insere elemento no início da lista. */
        public void insere(int novo)
        {
            Elo p = new Elo(novo);
            p.prox = prim;
            prim = p;
        }

        /* Verifica se um determinado elemento está na lista. */
        public boolean busca(int elem)
        {
            Elo p;

            for(p = prim; p != null; p = p.prox)
            {
                if(p.dado == elem)
                    return true;
            }

            return false;
        }

    /* Remove da lista o primeiro elemento com valor igual a “elem". Ret. true se removeu. */
    public boolean remove(int elem)
    {
        Elo p;
        Elo ant = null; /* Referência para anterior. */

        for(p = prim; ((p != null) && (p.dado != elem)); p = p.prox)
            ant = p;

        /* Se p é null, então não encontrou elemento. */
        if (p == null)
            return false;

        if (p == prim)
            prim = prim.prox; /* Remove elemento do início. */
        else
            ant.prox = p.prox;  /* Remove elemento do meio. */

        /* Remove a última referência para o elo a ser removido. Dessa forma,
         * o Garbage Collector irá liberar essa memória. */
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

    public int tamanho(){ int tam = 0;
        Elo p = prim;

        while (p != null) {
            tam++;
            p = p.prox;
        }

        return tam; }

    //MÉTODOS RECURSIVOS

    public boolean buscaRecursiva(int elem)
    {
        if(this.vazia())
            return false;

        return buscaRecursiva(elem, prim);
    }

    private boolean buscaRecursiva(int elem, Elo p)
    {
        if(p == null)
            return false;

        if(p.dado == elem)
            return true;

        return buscaRecursiva(elem, p.prox);
    }
    public void imprimeRecursivo()
    {
        System.out.println("Elementos da lista:");

        if(this.vazia())
            return;

        imprimeRecursivo(prim);

        System.out.println();
    }

    private void imprimeRecursivo(Elo p)
    {
        if(p == null)
            return;

        System.out.print(p.dado + " ");

        imprimeRecursivo(p.prox);
    }
}
