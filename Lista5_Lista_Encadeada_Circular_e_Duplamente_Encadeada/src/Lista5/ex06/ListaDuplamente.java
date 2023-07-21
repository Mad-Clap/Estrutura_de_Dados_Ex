package Lista5.ex06;

public class ListaDuplamente {

    /* Referência para primeiro elemento */
    protected Elo prim;

    protected class Elo
    {
        protected ChamadaTelefonica dado;
        protected Elo ant;
        protected Elo prox;

        public Elo()
        {
            ant = null;
            prox = null;
        }

        public Elo(ChamadaTelefonica elem)
        {
            dado = elem;
            ant = null;
            prox = null;
        }

        public Elo(ChamadaTelefonica elem, Elo antElem, Elo proxElem)
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

    public void insere(ChamadaTelefonica novo)
    {
        Elo p, q;
        Elo ant = null;

        q = new Elo(novo);

        for (p = prim; ((p != null) && (p.dado.getCusto() >= novo.getCusto())); p = p.prox)
            ant = p;

        if (ant == null){
            prim = q;
            q.prox = p;

        }
        else{
            q.ant = ant;
            q.prox = ant.prox;
            ant.prox = q;
        }
    }

    /* Método auxiliar para busca. */
    private Elo busca(int elem)
    {
        Elo p = null;

        for( p = prim; ((p != null) && (p.dado.equals(elem))) ; p = p.prox);

        return p;
    }

    /* Remove da lista o primeiro elemento com valor igual a "elem". Retorna true se removeu. */
    public ChamadaTelefonica remove()
    {
        if (prim == null) return null;

        ChamadaTelefonica chamadaTelefonica = prim.dado;

        /* Retira primeiro elemento */
            prim = prim.prox;

        return chamadaTelefonica;
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

}
