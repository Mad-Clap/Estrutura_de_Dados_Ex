package Lista1;

import java.util.Vector;

public class DuasPilhas<E> {
    //tamanho da primeira pilha do vetor
    private int tamanho1;
    //tamanho total do vetor
    private int tamanho2;
    //Topo da primeira pilha
    private int topo1;
    //Topo da segunda pilha
    private int topo2;
    private Vector<E> vetor;

    public DuasPilhas(int tamanhoTotal, int tamanho1) {
        this.topo1 = -1;
        this.tamanho2 = tamanhoTotal;
        this.vetor = new Vector<>(tamanho2);
        this.topo2=-1;
        this.tamanho1 = tamanho1;
    }

    public boolean pilhaVazia(int pilhaSelecionada) {
        if(pilhaSelecionada == 1){ return topo1 == -1 ? true : false;}
        if(pilhaSelecionada == 2) { return topo2 == -1 ? true : false;}

        //Mensagem para qualquer entrada de inteiro que não seja 1 ou 2
        System.out.println("Só há as pilhas 1 e 2");
        return true;
    }

    public boolean pilhaCheia(int pilhaSelecionada)
    {
        if(pilhaSelecionada == 1) return topo1 == tamanho1 - 1 ? true : false;

        if(pilhaSelecionada == 2) return topo2 == tamanho2 - 1 ? true : false;
        return false;
    }

    public E pop(int pilhaSelecionada) {
        E elemento;

        if (this.pilhaVazia(pilhaSelecionada)){return null;}

        if(pilhaSelecionada == 1){
            elemento = vetor.get(topo1--);
        }
        else{
            elemento = vetor.get(topo2--);
            //Se a pilha 2 for chegar ao espaço de alocação da pilha 1 no próximo pop, o topo2 recebe o valor -1,
            // ou seja, a pilha 2 torna-se vazia
            if(topo2 == tamanho1-1) topo2= -1;
        }
        return elemento;
    }

    public boolean push(E elemento, int pilhaSelecionada) {
        if (this.pilhaCheia(pilhaSelecionada)) {return false;}

        if(pilhaSelecionada==2){
            //Se a pilha 2 estiver vazia (com topo2=-1), topo2 recebe o valor da última posição da pilha 1,
            // que é incrementado e então aloca-se o novo elemento na primeira posição da pilha 2 no vetor
            if(topo2==-1) topo2 = tamanho1-1;
            vetor.add(++topo2, elemento);
        }
        else vetor.add(++topo1, elemento);

        return true;
    }

}
