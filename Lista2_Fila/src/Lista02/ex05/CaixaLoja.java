package Lista02.ex05;

public class CaixaLoja {
    private int clienteNumero;
    private final String  nomeCaixa;
    FilaDuplaCaixa filaDoCaixa;

    public CaixaLoja(String nomeCaixa, int tamanho) {
        this.clienteNumero = 1;
        this.nomeCaixa = nomeCaixa;
        this.filaDoCaixa = new FilaDuplaCaixa(tamanho);
    }

    public void adicionaAdulto(){
        // Adiciona adultos à fila do caixa
        if(filaDoCaixa.insere(new Adulto(this.clienteNumero))){
            System.out.println("O "+this.clienteNumero+"° cliente a entrar na fila do caixa " +
                  nomeCaixa+  " está esperando sua vez");
            this.clienteNumero+=1;
        }
        else System.out.println("A fila está cheia!");

    }

    public void adicionaIdoso(){
        // Adiciona idosos à fila do caixa
        if(!filaDoCaixa.cheia()){
            //Primeiro remove, ou tenta remover, o primeiro cliente na fila
            Cliente primeiro = filaDoCaixa.remove();
            //Se não houver clientes, e remove() retornar null, simplesmente adiciona o idoso à primeira posição
            if(primeiro==null){
                filaDoCaixa.insereInicio(new Idoso(this.clienteNumero));

            }
            // Se houver outro cliente idoso na frente (o que foi removido pelo sistema), primeiro é adicionado
            // à primeira posição da fila o idoso que acabou de entrar na mesma, com o método insereInicio, e logo após
            // o cliente idoso que estava na primeira posição da fila é reinserido nela com o mesmo método,
            // voltando então à primeira posição da fila do caixa
            else if(primeiro instanceof Idoso){
                filaDoCaixa.insereInicio(new Idoso(this.clienteNumero));
                filaDoCaixa.insereInicio((Idoso)primeiro);

            }
            // Por fim se há um adulto na primeira posição da fila ele é reinserido à fila com o método insereInicio,
            // e o idoso que acaba de entrar nela é também inserido com o mesmo método,
            // assumindo então a primeira posição da fila do caixa
            else{
                filaDoCaixa.insereInicio((Adulto) primeiro);
                filaDoCaixa.insereInicio(new Idoso(this.clienteNumero));
            }

            System.out.printf("O %d° cliente a entrar na " +
                    "fila do caixa %s está esperando sua vez\n", clienteNumero, nomeCaixa);
            this.clienteNumero+=1;

        } else System.out.println("A fila está cheia!");
    }

    public void atendeCliente(){
        Cliente atendido = filaDoCaixa.remove();
        if(atendido==null) { System.out.println("Não há clientes na fila!"); return; }
        //Simula o cliente na frente da fila sendo atendido e liberando espaço na fila, retornando seu número e
        // se ele era um idoso ou um adulto
        if(atendido instanceof Adulto){
            System.out.println("O "+atendido.getNumeroCliente()+"° cliente " +
                    "(um adulto) a entrar na fila do caixa "+nomeCaixa+" loja foi atendido");

        }else System.out.println("O "+atendido.getNumeroCliente()+"° cliente " +
                "(um idoso) a entrar na fila "+nomeCaixa+" da loja foi atendido");
    }
}
