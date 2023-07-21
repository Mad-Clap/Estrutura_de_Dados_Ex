package Lista4.ex05;

public class Lista {

        /* Referência para primeiro elemento */
        protected Elo prim;
        protected int tamanho; // int que conta o tamanho da lista

        protected class Elo
        {
            protected String dado;
            protected Elo prox;

            public Elo()
            {
                prox = null;
            }

            public Elo(String elem)
            {
                dado = elem;
                prox = null;
            }

            public Elo(String elem, Elo proxElem)
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
        public void insere(String novo)
        {
            Elo p = new Elo(novo);
            p.prox = prim;
            prim = p;
            tamanho++; // faz a contagem de elementos na lista
        }

        /* Verifica se um determinado elemento está na lista. */
        public boolean busca(String elem)
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
    public boolean remove(String elem)
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


    //RESPOSTA PARA A QUESTÃO 5
    public java.lang.String listaString(java.lang.String frase) {


        for(int i=0,j=0; i<frase.length();i++){

            //Guarda na lista strings após espaços, que não sejam também um espaço
            if(frase.charAt(i) == ' ' && frase.charAt(i-1) != ' '){
                this.insere(invertePalavra(frase.substring(j,i)));
                j=i+1;
            }
            //Guarda na lista strings que estejam antes de um caracter de pontuação e que não seja um espaço.
            else if (i+1 != frase.length() && (frase.charAt(i+1) == '!' || frase.charAt(i+1) == '?'
                    || frase.charAt(i+1) == '.' || frase.charAt(i+1) == ',' ||
                    frase.charAt(i+1) == ':' || frase.charAt(i+1) == ';') && frase.charAt(i)!=' ') {

                this.insere(invertePalavra(frase.substring(j,i+1)));
                j=i+1;
            }
            //Guarda na lista os caracteres de pontuação
            else if(frase.charAt(i) == '!' || frase.charAt(i) == '?' || frase.charAt(i) == '.' ||
                    frase.charAt(i) == ',' || frase.charAt(i) == ':' || frase.charAt(i) == ';'){
                this.insere(frase.substring(i,i+1));
                j=i+1;

            }
            //Guarda na lista a última palavra da frase
            else if(i == frase.length()-1 && frase.charAt(i-1)!=' '){
                this.insere(invertePalavra(frase.substring(j,i+1)));
                j=i+1;
            }
        }

        return montaString();
    }

    //INVERTE AS PALAVRAS AS ARMAZENANDO EM UMA LISTA ENCADEADA E MONTANDO UMA NOVA STRING A PARTIR
    //DO PRIMEIRO ELEMENTO DESSA LISTA, POSTERIORMENTE A RETORNANDO PARA A FUNÇÃO "listaString".
    private java.lang.String invertePalavra(java.lang.String substring){

        Lista listaInverte = new Lista();

        for(int i=0;i<substring.length();i++){
            String novo = String.valueOf(substring.charAt(i));
            listaInverte.insere(novo);
        }
        StringBuilder S = new StringBuilder();
        for(Elo p = listaInverte.prim;p!=null; p=p.prox){
            S.append(p.dado);
        }
        return S.toString();
    }

    //MONTA A STRING FINAL
    private java.lang.String montaString()
    {
        Elo p;
        StringBuilder S= new StringBuilder();

        System.out.println("Frase armazenada na lista:");

        for(p = prim; p != null; p = p.prox)
        {
            //CODIGO PARA PRINTAR OS PONTOS
            if(p.prox!=null && (p.prox.dado.equals("!") ||p.prox.dado.equals("?") ||
                    p.prox.dado.equals(".") ||p.prox.dado.equals(",") ||p.prox.dado.equals(":") ||
                    p.prox.dado.equals(";"))){

                S.append(p.dado);
            }
            else S.append(p.dado).append(" ");
        }

        return S.toString();
    }
}
