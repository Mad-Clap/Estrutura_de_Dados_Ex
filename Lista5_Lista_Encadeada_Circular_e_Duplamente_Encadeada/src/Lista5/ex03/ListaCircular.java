package Lista5.ex03;

public class ListaCircular extends Lista {
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

    //RESPOSTA DO EXERCICIO 3
    public ListaCircular inverteLista(){
        if (prim == null) {
            return null;    // Se a lista para qual o método for chamado estiver vazia, retorna null
        }

        ListaCircular invertida = new ListaCircular();

        //insere o último elo da lista invertida
       Elo ultimo = prim;
       invertida.prim = ultimo;

       //insere os elos da ListaCircular com o código de inserção de uma lista normal, que já inverte a ordem
       for(Elo p=prim.prox; p != prim ; p=p.prox) {
           Elo temp = new Elo(p.dado);
           temp.prox = invertida.prim;
           invertida.prim = temp;
       }
       //Faz a o último elemento referenciar para o primeiro
       ultimo.prox = invertida.prim;

        return invertida;
    }



}
