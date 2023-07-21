package Lista4.ex07;

public class Lista {
    protected Elo prim;

    protected class Elo {
        protected Inimigo inimigo;
        protected Elo prox;

        public Elo() {
            prox = null;
        }

        public Elo(Inimigo elem) {
            inimigo = elem;
            prox = null;
        }

        public Elo(Inimigo elem, Elo proxElem) {
            inimigo = elem;
            prox = proxElem;
        }
    }

    public Lista() {
        prim = null;
    }

    public void inserir(Inimigo inimigo) {
        Elo p = new Elo(inimigo);
        p.prox = prim;
        prim = p;
    }


    public Inimigo localizar(Inimigo inimigo) {
        Elo p;
        // Loop vai rodar até que o elemento seja encontrado
        for (p = prim; p != null; p = p.prox) {
            if (p.inimigo.equals(inimigo))
                return p.inimigo;
        }
        // se não for encontrado, retorna null
        return null;
    }

    public int efetuarDano(Inimigo inimigo, double dano) {

        //retorna -1 se o inimigo não estiver na lista encadeada
        if(localizar(inimigo) == null) return -1;

        int vida = (int) (inimigo.getVida() - dano);

        // Altera os pontos de vida do inimigo.Se a vida do inimigo zerar,
        // o inimigo é também removido da lista encadeada.
        if (vida <= 0) {
            vida=0;
            inimigo.setVida(0);
            removeInimigo(inimigo);

        } else inimigo.setVida(vida);

        return vida; // Retorna o valor da vida.

    }

    private boolean removeInimigo(Inimigo inimigo) {
        Elo p;
        Elo ant = null;

        for (p = prim; ((p != null) && (!p.inimigo.equals(inimigo))); p = p.prox)
            ant = p;

        if (p == null)
            return false;

        if (p == prim)
            prim = prim.prox;
        else
            ant.prox = p.prox;

        p = null;

        return true;
    }

}
