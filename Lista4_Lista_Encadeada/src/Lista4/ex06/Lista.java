package Lista4.ex06;
public class Lista {

    protected Elo prim;

    // A lista armazena arquivos e diretorios (já que um é extensão do outro)
    // e se descobre em tempo de execução qual dos dois o elemento é para impressão.

    protected class Elo {
        protected Arquivo arquivo;
        protected Elo prox;

        public Elo() {
            prox = null;
        }

        public Elo(Arquivo elem) {
            arquivo = elem;
            prox = null;
        }

        public Elo(Arquivo elem, Elo proxElem) {
            arquivo = elem;
            prox = proxElem;
        }
    }

    public Lista() {
        prim = null;
    }

    public boolean vazia() {
        return prim == null;
    }

    public void insere(Arquivo novo) {
        Elo p = new Elo(novo);
        p.prox = prim;
        prim = p;
    }

    public boolean removeArquivo(Arquivo elem) {
        Elo p;
        Elo ant = null;

        for (p = prim; ((p != null) && (!p.arquivo.equals(elem))); p = p.prox)
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

    public void imprime() {
        Elo p;
        for (p = prim; p != null; p = p.prox) {
            if (p.arquivo instanceof Diretorio) {
                imprimeDiretorio("    ", (Diretorio) p.arquivo);
            } else {
                System.out.println("    "+p.arquivo.getNome());
            }
        }
    }
    //IMPRIME DIRETORIOS RECURSIVAMENTE
    private void imprimeDiretorio(String indenta, Diretorio diretorio) {
        Lista lista = diretorio.getListaArquivos();
        System.out.println(indenta + diretorio.getNome());
        indenta += "    ";

        if (!lista.vazia()) {
            Elo p;
            for (p = lista.prim; p != null; p = p.prox) {
                if (p.arquivo instanceof Diretorio) {
                    imprimeDiretorio(indenta, (Diretorio) p.arquivo);
                } else {
                    System.out.println(indenta + p.arquivo.getNome());
                }
            }
        } else {
            System.out.println(indenta + "(Pasta Vazia)");
        }
    }
}
