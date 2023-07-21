package Lista4.ex06;
public class Diretorio extends Arquivo {
    private Lista listaArquivos;

    public Diretorio(String nome) {
        super(nome);
        listaArquivos = new Lista();
    }

    public Lista getListaArquivos() {
        return listaArquivos;
    }

    public void insere(Arquivo arquivo) {
        listaArquivos.insere(arquivo);
    }

    public void imprimeArquivos() {
        System.out.println(this.getNome());
        listaArquivos.imprime();
    }
}
