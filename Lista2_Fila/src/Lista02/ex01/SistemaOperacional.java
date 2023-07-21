package Lista02.ex01;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class SistemaOperacional {
    FilaProcessos processos;

    //Os atributos de Timer e TimerTask simulam o processamento da CPU dos processos colocados
    // na fila pelo Sistema Operacional para serem executados. O tempo de processamento está em 20 segundos,
    // e a cada 20 segundos o método de fila 'remove()' é executado pelo sistema,
    // tirando o primeiro processo que entrou na fila.

    Timer timer = new Timer();

    TimerTask realizarProcesso = new TimerTask() {
        @Override
        public void run() {
            if(!processos.vazia()){
                System.out.print("  (O processo "+processos.remove().getNumeroIdentificador()+
                        " acabou de ser processado)");
            }
        }
    };

    public SistemaOperacional(int tamanho) {
        this.processos = new FilaProcessos(tamanho);
        long tempoProcessamento = (1000 * 20);
        timer.scheduleAtFixedRate(realizarProcesso, tempoProcessamento, tempoProcessamento);
    }

    public void insereProcesso(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o número do processo a ser adicionado na fila de processos:");
        int numero = Integer.MIN_VALUE;
        boolean valido = false;
        if(sc.hasNextInt()){
            numero = sc.nextInt();
            valido = true;
        }
        if(!valido){
            System.out.println("Entrada inválida");
            return;
        }

        if(processos.cheia()){
            System.out.println("A fila de processos está cheia. Deseja remover o processo " +
                    "com maior tempo de espera para adicionar outro processo? (Digite 'sim' ou 'Sim' se sim ou 'nao' caso não queira)");
            char op = sc.next().charAt(0);
            if(op=='s'|| op=='S'){
                processos.removeFim();
            } else return;
        }

        processos.insere(new Processo(numero));
        System.out.println("O processo "+numero+" foi adicionado a fila de processos para ser processado");

    }

    public void retiraProcessoMaiorTempoEsp(){
        //Retira o processo com maior tempo de espera pra ser processado pela CPU da fila (no caso o último dela)
        if(!processos.vazia()){
            System.out.printf("O processo %d, que tinha o maior tempo de espera," +
                    " foi removido\n", processos.removeFim().getNumeroIdentificador());
        }
       else System.out.println("Não há processos sendo executados no Sistema Operacional");
    }
    public void imprimeProcessos(){
        if(!processos.ImprimeVetorProcessos()) System.out.println("Não há processos sendo executados " +
                "no Sistema Operacional");
        System.out.print('\n');
    }
}
