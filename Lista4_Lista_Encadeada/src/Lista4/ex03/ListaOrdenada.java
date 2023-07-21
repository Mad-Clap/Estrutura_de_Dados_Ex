package Lista4.ex03;

public class ListaOrdenada<E extends Comparable<E>> extends Lista<E>
{

    public void insere(E novo)
    {
        Elo p, q;
        Elo ant = null;

        q = new Elo(novo);

        for (p = prim; ((p != null) && (p.dado.compareTo(novo) < 0)); p = p.prox)
            ant = p;

        if (ant == null)
            prim = q;
        else
            ant.prox = q;

        q.prox = p;
        tamanho++;
    }

    public boolean remove(E elem)
    {
        Elo p;
        Elo ant = null;

        for(p = prim; ((p != null) && (p.dado.compareTo(elem) < 0)); p = p.prox)
            ant = p;
        if ((p == null) || (p.dado != elem))
            return false;

        if (p == prim)
            prim = prim.prox;
        else
            ant.prox = p.prox;

        p = null;
        tamanho--;

        return true;
    }
}