package Lista1;
import java.util.Scanner;
public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static boolean FormatoC (String input){
        //Método para o exercício 1 e 2
        Pilha<Character> pilha = new Pilha<>(input.length());

        //Percorre a string
        int inputIndex = 0;

        //Localiza a posição do 'C' na string
        int indexC = 0;

        if(input.charAt(0) == 'C') return false; //Caso o formato especificado não for respeitado retorna falso

        while(!pilha.pilhaCheia()){

            //Caso o formato especificado não for respeitado retorna falso
            if(input.charAt(inputIndex) != 'A' && input.charAt(inputIndex) != 'B' && input.charAt(inputIndex) != 'C') {return false;}

            //Define a posição do 'C' na string
            if(input.charAt(inputIndex) == 'C') {indexC = inputIndex;} // Localiza a posição do 'C'

            pilha.push(input.charAt(inputIndex));
            inputIndex++;
        }

        //Nova pilha de caracteres com os caracteres após o caracter 'C'.Estará cheia antes de dar push no caractere 'C'
        Pilha<Character> pilhaInversa = new Pilha<>(pilha.getTopo() - indexC);

        while (!pilhaInversa.pilhaCheia()){
            pilhaInversa.push(pilha.pop());
        }
        //Descarta o caractere 'C' da pilha
        pilha.pop();

        //Se as pilhas não tiverem como topo números iguais,o formato não foi respeitado
        if(pilha.getTopo() != pilhaInversa.getTopo()) return false;

        //Confere se os caracteres após o caracter 'C' é a exata inversão dos anteriores ao 'C'
        while (!pilha.pilhaVazia() && !pilhaInversa.pilhaVazia()) {
            char caractere1 = pilha.pop();
            char caractere2 = pilhaInversa.pop();
            if (caractere1 != caractere2) return false;
        }

        return true;
    }
    private static void exercicio01() {

        //Escreva uma função para determinar se uma cadeia de caracteres (string) é da forma: x
        //C y onde x e y são cadeias de caracteres compostas por letras ‘A’ e/ou ‘B’, e y é o inverso
        //de x. Isto é, se x = “ABABBA”, y deve equivaler a “ABBABA”. Em cada ponto, você só
        //poderá ler o próximo caractere da cadeia

        System.out.println("Exercício 1 -\n Digite uma cadeia de caracteres:");
        String input= sc.nextLine();
        if(input.equals("")) {System.out.println("Não há uma cadeia de caracteres");return; }

        if(FormatoC(input))
            System.out.println("A cadeia de caracteres está no formato especificado.");
        else
            System.out.println("A cadeia de caracteres NÃO está no formato especificado.");
    }

    public static boolean FormatoD(String input) {
        //Método para o exercício 2
        int i;
        //Define o início de cada sequência xCy conforme a string é lida
        int indexInicial = 0;

        //Caso o formato especificado não for respeitado retorna falso
        if (input.charAt(0) == 'C' || input.charAt(0) == 'D') return false;
        if(input.charAt(input.length()-1)=='D') return false;

        //Adiciona um 'D' ao final da string, permitindo ler a última sequência do formato,
        // ou ele inteiro caso a string respeite o formato xCy, mas não tenha o 'D' e outras sequências xCy
        input +="D";

        for (i = 0; i < input.length(); i++) {

            //Caso o formato especificado não for respeitado retorna falso
            if (input.charAt(i) != 'A' && input.charAt(i) != 'B' && input.charAt(i) != 'C' &&
                    input.charAt(i) != 'D') {
                return false;
            }
            //Cria uma pilha que começa a dar push do D para trás
            if (input.charAt(i) == 'D') {
                //Uma pilha da posição de um 'D' até o início da sequência anterior a esse 'D'
                Pilha <Character> pilhaParcial = new Pilha<>(i- indexInicial);

                int j = indexInicial;

                while (j < i) {
                    if(input.charAt(j) != 'D') pilhaParcial.push(input.charAt(j));
                    j++;
                }

                StringBuilder subs = new StringBuilder();
                while (!pilhaParcial.pilhaVazia()) {
                    char caracter = pilhaParcial.pop();
                    subs.append(caracter);
                }
                // Permite que cada sequência xCy seja lida separadamente
                indexInicial = i;
                //Testa a sequência xCy da vez. Se não estiver no formato retorna false
                if (!FormatoC(subs.toString())) return false;

            }
        }
        return true;
    }
    private static void exercicio02() {
        //Escreva uma função para determinar se uma cadeia de caracteres (string) é da forma: a
        //D b D c D ... D z onde cada cadeia de caracteres, a, b, ..., z, é da forma do exercício 1.
        //Portanto, uma cadeia de caracteres estará no formato correto se consistir
        //em qualquer número de cadeias deste tipo ( x C y ), separadas pelo caractere ‘D’. Em cada
        //ponto, você só poderá ler o próximo caractere da cadeia (é mandatório o uso de pilha).

        System.out.println("Exercício 2 -\n Digite uma cadeia de caracteres:");
        String input= sc.nextLine();
        if(input.equals("")) {System.out.println("Não há uma cadeia de caracteres");return; }


        if(FormatoD(input))
            System.out.println("A cadeia de caracteres está no formato especificado");
        else
            System.out.println("A cadeia de caracteres NÃO está no formato especificado");


    }

    private static void testePilhaCheiaOuVazia(DuasPilhas duasPilhas){
        //Método para o exercício 3

        System.out.print("Testando se a pilha 1 e a pilha 2 estão cheias:\nPilha 1:");
        if(duasPilhas.pilhaCheia(1)) System.out.println(" está cheia");
        else System.out.println(" não está cheia");

        System.out.print("Pilha 2:");
        if(duasPilhas.pilhaCheia(2)) System.out.println(" está cheia");
        else System.out.println(" não está cheia");

        System.out.print("\n");

        System.out.print("Testando se a pilha 1 e a pilha 2 estão vazias:\nPilha 1:");
        if(duasPilhas.pilhaVazia(1)) System.out.println(" está vazia");
        else System.out.println(" não está vazia");

        System.out.print("Pilha 2:");
        if(duasPilhas.pilhaVazia(2)) System.out.println(" está vazia");
        else System.out.println(" não está vazia");

        System.out.print("\n");

    }
    private static void exercicio03() {
        //Desenvolva um método para manter duas pilhas dentro de um único vetor (array) de
        //modo que nenhuma das pilhas incorra em estouro até que toda a memória seja usada, e
        //toda uma pilha nunca seja deslocada para outro local dentro do vetor.

        System.out.println("Exercício 3 -\n Qual tamanho deve ter a pilha 1 (será preenchida com '0')?");

        int tamanho1=-1;
        while(tamanho1 < 1){
            if(sc.hasNextInt()){tamanho1 = sc.nextInt();}
            else {
                System.out.println("É necessário a entrada de um número positivo para o tamanho da pilha");
                sc.nextLine();
            }
        }

        System.out.println("Qual tamanho deve ter a pilha 2? (será preechida com '1')");

        int tamanho2=-1;
        while(tamanho2 < 1){
            if(sc.hasNextInt()){tamanho2 = sc.nextInt();}
            else {
                System.out.println("digite um número positivo para o tamanho da pilha");
                sc.nextLine();

            }
        }

        DuasPilhas<Integer> duasPilhas = new DuasPilhas<>((tamanho2+tamanho1), tamanho1);

        System.out.println("\nPreenchendo a pilha 1...\n");
        while (!duasPilhas.pilhaCheia(1)) {
            duasPilhas.push(0,1);
        }

        testePilhaCheiaOuVazia(duasPilhas);

        System.out.println("Retornando a pilha 1 e a esvaziando com método pop:");
        System.out.print("Pilha 1: ");
        while (!duasPilhas.pilhaVazia(1)){
            System.out.print(duasPilhas.pop(1)+" ");
        }

        System.out.print("\n");

        System.out.println("\nPreenchendo a pilha 2...\n");
        while (!duasPilhas.pilhaCheia(2)) {
            duasPilhas.push(1,2);
        }

        testePilhaCheiaOuVazia(duasPilhas);


        System.out.println("Retornando a pilha 2 e a esvaziando com método pop:");
        System.out.print("Pilha 2: ");
        while (!duasPilhas.pilhaVazia(2)){
            System.out.print(duasPilhas.pop(2)+" ");
        }
        System.out.print("\n\n");

        testePilhaCheiaOuVazia(duasPilhas);
    }

    private static void exercicio04() {
        ////Utilizando as operações de manipulação de pilhas, use uma pilha auxiliar e uma variável do tipo T, para desenvolver
        //    //um procedimento que remova um dado objeto do tipo T de uma posição qualquer de uma
        //    //pilha. Para saber se dois objetos do tipo T são iguais, você deve usar o método equals (ou
        //    //compareTo). Note que você não pode acessar diretamente a estrutura interna da pilha
        //    //(atributos), devendo usar apenas as operações (métodos) de manipulação.

        int tamanho = 10;
        Pilha<Integer> pilha = new Pilha(tamanho);
        Ex04<Integer> ex04 = new Ex04(pilha);

        for(int i=10;!pilha.pilhaCheia();i--){
            pilha.push(i);
        }
        System.out.println("Há uma pilha de números de 1 a 10. digite um número para remover da pilha:");

        int remocao;
        if(sc.hasNextInt()){remocao = sc.nextInt();}
        else {
            System.out.println("Não há esse elemento na pilha");
            sc.nextLine();
            return;
        }

        if(!ex04.ex04(tamanho, remocao)){
            System.out.println("Não há esse número na pilha");
            return;
        }
        System.out.printf("Número %d removido. retornando pilha e a esvaziando com método pop:\n Pilha: ", remocao);
        while (!pilha.pilhaVazia()){
            System.out.print(pilha.pop()+" ");
        }
    }

    public static boolean expressoesBalanceadas(String input){
        //Método para o exercício 5

        Pilha<Character> pilha = new Pilha<>(input.length());

        for(int i =0;!pilha.pilhaCheia() && i< input.length();i++){
            // Empilha as aberturas de chaves, parênteses e colchetes.
            if(input.charAt(i) == '[' || input.charAt(i) == '('  || input.charAt(i) == '{' ){
                pilha.push(input.charAt(i));
            }
            if( input.charAt(i) == ']'|| input.charAt(i) == ')'|| input.charAt(i) == '}'){
                //Se a pilha estiver vazia a sequência está desbalanceada.
                if(pilha.pilhaVazia()) return false;

                //Testa se as aberturas de chaves, parênteses e colchetes estão balanceadas com seus fechamentos
                int caractereA = pilha.pop();
                int caractereB = input.charAt(i);
                //Teste para parênteses pelo código ASCII (abertura de parênteses é igual a 40, o fechamento é 41).
                if (caractereA==40 && (caractereA == caractereB-1)) continue;
                //Teste para chaves e colchetes pelo cósigo ASCII (colchetes são 91 e 93, chaves são 123 e 125).
                if (caractereA == caractereB-2) continue;
                return false;
            }
        }
        //Se a pilha estiver vazia nesse caso ou nunca houve qualquer caracter nela ou a sequência está balanceada.
        return pilha.pilhaVazia();
    }
    private static void exercicio05() {
        //Escreva um programa que leia uma sequência de caracteres e determine se os
        //parênteses, colchetes e chaves estão balanceados. Se a sequência não possuir esses
        //caracteres ele deve ser considerado balanceado. Exemplo:
        //“{ab}[cde]” - Balanceado
        //“{ab[cd]efg}” - Balanceado
        //“[abcde{efg]}” - Não balanceado

        System.out.println("Exercício 5 -\n Digite uma cadeia de caracteres:");
        String input= sc.nextLine();
        if(input.equals("")) {System.out.println("Não há uma cadeia de caracteres");return; }

        if(expressoesBalanceadas(input)){
            System.out.println("A sequência de caracteres está balanceada");
        } else {
            System.out.println("A sequência de caracteres NÃO está balanceada");

        }


    }

    private static void exercicio06() {
        //Elabore um método que retorne as letras invertidas das palavras de uma frase recebida
        //por parâmetro, preservando a ordem das palavras na frase. Por exemplo “a maçã está
        //podre”, deve ter como saída: “a ãçam átse erdop”. As operações básicas de uma pilha,
        //push e pop, devem ser usadas.

        System.out.println("Exercício 6 -\n Digite uma cadeia de caracteres:");
        String input= sc.nextLine();
        if(input.equals("")) {System.out.println("Não há uma cadeia de caracteres");return; }

        Pilha<Character> pilha = new Pilha<>(input.length());
        StringBuilder output = new StringBuilder();

        //Realiza as inversões das palavras
        for(int i=0; i < input.length(); i++){

            pilha.push(input.charAt(i));
            //Permite dar pop na pilha palavra por palavra, que terão seus caracteres adicionados no StringBuilder de forma invertida
            // por consequência. Define-se se o próximo caractere é um espaço ou um hífen, e a partir daí o processo para de dar push
            // para a pilha e começa a dar pop nela
            if(i+1<input.length() && (input.charAt(i+1) == ' ' || input.charAt(i+1) == '-')){
                while (!pilha.pilhaVazia()){
                    output.append(pilha.pop());
                }
                i+=1;
                pilha.push(input.charAt(i));
                output.append(pilha.pop());
            }
        }
        //Adiciona ao StringBuilder a última palavra da frase de forma invertida
        while (!pilha.pilhaVazia()){
            output.append(pilha.pop());
        }

        System.out.println("Sequência invertida:\n"+output.toString());
    }

    private static void exercicio07() {
        //Utilize o conceito de Pilha para realizar a avaliação
        //de expressões aritméticas em notação infixa, isto é, aquela que aprendemos e utilizamos ao
        //longo do Ensino Fundamental e do Ensino Médio. Nesse contexto, vamos usar a seguintedefinição recursiva: uma expressão aritmética é um número, ou um parêntese esquerdo
        //seguido de uma expressão aritmética seguida por um operador seguido por outra expressão
        //aritmética seguida de um parêntese direito. Por simplicidade, essa definição assume que a
        //expressão está completamente parentizada, especificando precisamente quais operadores
        //devem ser aplicados a quais operandos e removendo possíveis ambiguidades na avaliação.
        //Por exemplo, a expressão ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) segue essa definição.
        //Você deve então implementar um método que realize a avaliação de tais expressões
        //representadas em uma String usando o conceito de Pilha. Por fim, cabe citar que o código
        //que voces vão desenvolver corresponde a um exemplo simples de um interpretador: um
        //programa que interpreta uma computação especificada por uma string e realiza tal
        //computação para chegar ao resultado.

        System.out.println("Exercício 7 -\n Digite a expressão aritmética:");
        String input= sc.nextLine();
        if(input.equals("")) {System.out.println("Nada foi digitado");return; }

        ExpressaoInfixa infixa = new ExpressaoInfixa(input, input.length());

        if(infixa.avaliaExpressao()) System.out.println(infixa.getResposta());
    }

    private static void exercicio08() {
        //Dada uma sequência de 1 a N armazenada em um array, são formadas todas as
        //subsequências (subarrays) possíveis a partir da sequência original. Para todas essas
        //subsequências geradas, encontre a quantidade de pares únicos (a, b), em que ‘a’ é
        //diferente de ‘b’ e ‘a’ é máximo (maior número) e ‘b’ é o segundo máximo da subsequência.
        System.out.println("Exercício 8 -\n Informe o valor de n da sequência de 1 à n:");

        int n=0;
        while(n < 1){

            if(sc.hasNextInt()){n = sc.nextInt();}
            else {
                System.out.println("É necessário a entrada de um número igual ou superior à 1 para a criação de uma sequência de 1 à n");
                sc.nextLine();
            }
        }
        if(n==1) {System.out.println("Não há subsequências ou pares únicos de 1 à 1"); return;}

        Pilha<Integer> array = new Pilha<>(n);
        Pilha<Integer> pilhaParesUnicosInvertida = new Pilha<>((n-1)*2);
        Pilha<Integer> pilhaParesUnicos = new Pilha<>((n-1)*2);

        for(int i = n; i>0;i--){
            array.push(i);
        }

        int contadorSubsequencias=0;
        int contadorParesUnicos=0;

        //Printa todas as subsequências, contando quantas existem, e adiciona as de pares únicos à pilhaParesUnicosInvertida
        while (!array.pilhaVazia()){
            int i = array.pop();
            for(int j=i;j<=n;j++){
                System.out.print(i+" ");
                for(int k = i+1; k<=j;k++){
                    System.out.print(k+" ");
                    if(j == i+1){
                        pilhaParesUnicosInvertida.push(k);
                        pilhaParesUnicosInvertida.push(i);
                        contadorParesUnicos++;
                    }
                }
                contadorSubsequencias++;
                System.out.print("\n");
            }
        }
        System.out.print("\n");
        // A pilhaParesUnicos dá push nos elementos que são retirados da pilha anterior,
        // assim ordenando os pares dos menores números para os maiores
        while (!pilhaParesUnicosInvertida.pilhaVazia()){
            pilhaParesUnicos.push(pilhaParesUnicosInvertida.pop());
        }

        System.out.printf("Nessas %d subsequências, existe(m) %d par(es) único(s) definido(s): ", contadorSubsequencias, contadorParesUnicos);

        while (!pilhaParesUnicos.pilhaVazia()){
            System.out.print("("+pilhaParesUnicos.pop()+","+pilhaParesUnicos.pop()+")  ");
        }


    }

    public static void main(String[] args) {

        //exercicio01();

        //exercicio02();

        //exercicio03();

        //exercicio04();

        //exercicio05();

        //exercicio06();

        //exercicio07();

        //exercicio08();


        sc.close();
    }


}
