package Lista4.ex02;

public class ListaOrdenada extends Lista{
    public void insere(int novo)
    {
        Elo p, q;
        Elo ant = null;

        q = new Elo(novo);

        for (p = prim; ((p != null) && (p.dado < novo)); p = p.prox)
            ant = p;

        if (ant == null)
            prim = q;
        else
            ant.prox = q;

        q.prox = p;
        tamanho++;
    }

    /* Remove da lista o primeiro elemento com valor igual a “elem". Ret. true se removeu. */
    public boolean remove(int elem)
    {
        Elo p;
        Elo ant = null; /* referência para anterior */

        for(p = prim; ((p != null) && (p.dado < elem)); p = p.prox)
            ant = p;

        /* Se p é null ou p.dado != elem, então não encontrou elemento. */
        if ((p == null) || (p.dado != elem))
            return false;

        if (p == prim)
            prim = prim.prox; /* Remove elemento do início. */
        else
            ant.prox = p.prox;  /* Remove elemento do meio. */

        /* Remove a última referência para o elo a ser removido. Dessa forma,
         * o Garbage Collector irá liberar essa memória. */
        p = null;
        tamanho--;

        return true;
    }
    //RESOLUÇÃO DA QUESTÃO 2
    public ListaOrdenada listaIntercalada(ListaOrdenada l2){

        ListaOrdenada listaIntercalada = new ListaOrdenada();
        Elo p1 = this.prim;
        Elo p2 = l2.prim;
        Elo p;

        //Se uma das listas forem nulas (p1 ser nulo, ou p2 ser nulo), será retornada a outra lista.
        // Da mesma forma se ambas listas forem nulas será retornado "null".
        if(p1 == null) return l2;
        if(p2 == null) return this;

        //inicializa a lista intercalado com o prim de menor valor de uma das outras listas e referencia
        // o inicio (prim) da lista em p
        if(p1.dado <= p2.dado){
            listaIntercalada.prim = p1;
            p1=p1.prox;
        }
        else{
            listaIntercalada.prim = p2;
            p2=p2.prox;
        }

        p = listaIntercalada.prim;
        int tam = 0;

            //inclui novos elementos ordenadamente na nova lista, estando só uma delas vazia ou não
            while (p1 != null || p2 != null) {

                if ((p2!=null && p1!=null) && p1.dado <= p2.dado) {
                    p.prox = p1;
                    p1 = p1.prox;
                } else if(p2 != null && p1 != null){
                    p.prox = p2;
                    p2 = p2.prox;
                } else if(p1==null){
                    p.prox = p2;
                    p2 = p2.prox;
                } else {
                    p.prox = p1;
                    p1 = p1.prox;
                }
                p = p.prox;
                tam++;
            }
            listaIntercalada.tamanho=tam;

        return listaIntercalada;
    }
}
