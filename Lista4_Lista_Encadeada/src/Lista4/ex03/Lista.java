package Lista4.ex03;

public class Lista<E> {

        /* Referência para primeiro elemento */
        protected Elo prim;
        protected int tamanho; // int que conta o tamanho da lista

        protected class Elo
        {
            protected E dado;
            protected Elo prox;

            public Elo()
            {
                prox = null;
            }

            public Elo(E elem)
            {
                dado = elem;
                prox = null;
            }

            public Elo(E elem, Elo proxElem)
            {
                dado = elem;
                prox = proxElem;
            }
        }

        public Lista()
        {
            prim = null;
            tamanho=0;
        }

        /* Testa se a lista está vazia. */
        public boolean vazia()
        {
            return prim == null;
        }

        /* Insere elemento no início da lista. */
        public void insere(E novo)
        {
            Elo p = new Elo(novo);
            p.prox = prim;
            prim = p;
            tamanho++; // faz a contagem de elementos na lista
        }

        /* Verifica se um determinado elemento está na lista. */
        public boolean busca(E elem)
        {
            Elo p;

            for(p = prim; p != null; p = p.prox)
            {
                if(p.dado.equals(elem))
                    return true;
            }

            return false;
        }

    /* Remove da lista o primeiro elemento com valor igual a “elem". Ret. true se removeu. */
    public boolean remove(E elem)
    {
        Elo p;
        Elo ant = null; /* Referência para anterior. */

        for(p = prim; ((p != null) && (p.dado.equals(elem))); p = p.prox)
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
        tamanho--; // tamanho é decrementado ao se remover um elemento

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

    public int tamanho(){ return tamanho; } // Nova formulação do método tamanho().
}
