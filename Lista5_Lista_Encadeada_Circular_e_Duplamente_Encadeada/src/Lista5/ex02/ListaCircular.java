package Lista5.ex02;

public class ListaCircular extends Lista{
    /* Imprime todos os elementos da lista */
    public void imprime()
    {
        Elo p;
        System.out.println("Elementos da lista");

        p = prim;

        if (p != null)
        {
            do
            {
                System.out.print(p.dado + " ");
                p = p.prox;

            } while (p != prim);
        }

        System.out.println();
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
        System.out.print(p.dado + " ");

        if(p.prox == prim)
            return;

        imprimeRecursivo(p.prox);
    }

    /* Insere elemento no fim da lista. */
    public void insere(int novo)
    {
        Elo p, q;
        q = new Elo(novo);
        p = prim;

        if (p != null)
        {
            /* Percorre até alcancar o início. */
            while (p.prox != prim)
            {
                p = p.prox;
            }

            p.prox = q;
            q.prox = prim;
        }
        else
        {
            prim = q;
            prim.prox = q;
        }
    }

    public boolean remove(int elem)
    {
        Elo p = null;
        Elo ant = null;

        if (prim == null) return false;

        for( p = prim; ( (p.prox != prim ) && (p.dado != elem) ); p = p.prox)
            ant = p;

        /* Achou */
        if ( p.dado == elem )
        {
            /* É o primeiro */
            if ( p == prim )
            {
                /* � o �nico */
                if ( prim == prim.prox )
                {
                    prim = null;
                }
                else
                {
                    /* Guarda o anterior ao primeiro */
                    for( ant = prim; ( ant.prox != prim ); ant = ant.prox);

                    ant.prox = prim.prox;
                    prim = prim.prox;
                }
            }
            else
            {
                /* No meio */
                ant.prox = p.prox;
            }

            /* Remove a última referência para o elo a ser removido. Dessa forma,
             * o Garbage Collector irá liberar essa memória. */
            p = null;

            return true;
        }
        else
            return false;
    }

    //RESPOSTA DO EXERCICIO 2
    public ListaCircular merge(ListaCircular lista2) {
        // Se a lista corrente estiver vazia, retorna a lista2
        if (prim == null)
            return lista2;

        // Se a lista2 estiver vazia, retorna a própria lista corrente
        if (lista2.prim == null) {
            return this;
        }

        ListaCircular l3 = new ListaCircular();

        Elo p, q;
        // Cria o primeiro e segundo elo da lista a ser retornada
        l3.insere(prim.dado);
        l3.insere(lista2.prim.dado);

        boolean voltal1 = false;
        boolean voltal2 = false;
        //Insere os elementos alternadamente de ambas listas
        for(p=prim.prox, q = lista2.prim.prox; !voltal1 || !voltal2; p=p.prox, q=q.prox ){
            if(p==prim) voltal1 = true;
            if(q==lista2.prim) voltal2 = true;

            if(!voltal1) l3.insere(p.dado);
            if(!voltal2) l3.insere(q.dado);


        }

        return l3;
    }
}
