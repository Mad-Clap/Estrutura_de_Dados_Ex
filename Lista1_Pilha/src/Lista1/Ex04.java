package Lista1;

public class Ex04 <E>{

    private Pilha<E> pilha;

    public Ex04(Pilha<E> pilha){this.pilha = pilha;}

    public boolean ex04(int tamanho, int remocao){
        Pilha<E> pilhaAuxiliar = new Pilha(tamanho);
        E elemento;

        boolean elementoRemovido = false;
        //Dá push à uma pilha auxiliar nos elementos da pilha da classe até a mesma esvaziar-se, menos no elemento que deve ser removido
        // caso ele exista, e retorna se o elemento estava de fato na pilha e foi removido ou não pelo boolean elementoRemovido
        while (!this.pilha.pilhaVazia()){
            elemento = this.pilha.pop();
            if(elemento.equals(remocao)){
                elementoRemovido=true;
                continue;
            }
            pilhaAuxiliar.push(elemento);
        }

        while (!pilhaAuxiliar.pilhaVazia()){
            this.pilha.push(pilhaAuxiliar.pop());
        }

        return elementoRemovido;
    }

}
