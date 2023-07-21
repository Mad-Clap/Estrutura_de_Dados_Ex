package Lista1;

public class ExpressaoInfixa {
    private Pilha<Character> pilhaExpressao;
    private final String expressao;
    private int tamanhoExpressao;
    private int resposta;


    public ExpressaoInfixa(String expressao, int tamanhoExpressao) {
        this.pilhaExpressao = new Pilha<>(tamanhoExpressao);
        this.expressao = expressao;
    }

    public boolean infixaBalanceada(){

        Pilha<Character> pilha = new Pilha<>(expressao.length());

        //Se a expressão não começar com um desses caracteres não há possibilidade de estar parentizada como pedido.
        if(expressao.charAt(0) != '[' && expressao.charAt(0) != '('  && expressao.charAt(0) != '{' ){
            return false;
        }

        for(int i =0;!pilha.pilhaCheia() && i< expressao.length();i++){
            // Empilha as aberturas de chaves, parênteses e colchetes.
            if(expressao.charAt(i) == '[' || expressao.charAt(i) == '('  || expressao.charAt(i) == '{' ){
                pilha.push(expressao.charAt(i));

            }
            if( expressao.charAt(i) == ']'|| expressao.charAt(i) == ')'|| expressao.charAt(i) == '}'){
                //Se a pilha estiver vazia a sequência está desbalanceada.
                if(pilha.pilhaVazia()) return false;

                //Testa se as aberturas de chaves, parênteses e colchetes estão balanceadas com seus fechamentos
                int caractereA = pilha.pop();
                int caractereB = expressao.charAt(i);
                //Teste para parênteses pelo código ASCII (abertura de parênteses é igual a 40, o fechamento é 41).
                if (caractereA==40 && (caractereA == caractereB-1)) continue;
                //Teste para chaves e colchetes pelo cósigo ASCII (colchetes são 91 e 93, chaves são 123 e 125).
                if (caractereA == caractereB-2) continue;
                return false;
            }
        }

        //Se a pilha estiver vazia nesse caso a expressão está balanceada.
        return pilha.pilhaVazia();
    }

    public String operacaoParcial(int operando1, int operando2,char operador){
        //Realiza as operações matemáticas dentro de cada parênteses da expressão passada
        StringBuilder conta = new StringBuilder();
        int operacao = 0;
        switch (operador) {
            case '*':
                operacao = operando1 * operando2;  break;
            case '+':
                operacao = operando1 + operando2;  break;
            case '/':
                operacao = operando1 / operando2;  break;
            case '-':
                operacao = operando1 - operando2;  break;

            default: operacao= operando1;
        }

        conta.append(operacao);
        return conta.toString();
    }

    public boolean avaliaExpressao(){
        //Testa se a expressão está balanceada
        if(!infixaBalanceada()){
            System.out.println("A expressão não está devidamente infixada.");
            return false;
        }

        //varre a string da expressão e adiciona os caracteres à pilha
        for(int i=expressao.length()-1; i > -1 ; i--){
            int valido = expressao.charAt(i);

            //Testa se a expressão aritmética só tem parênteses, colchetes ou chaves, números e os operandos permitidos
            if(expressao.charAt(i) != ')' && expressao.charAt(i) != '}' && expressao.charAt(i) != ']' &&
                    expressao.charAt(i) != '(' && expressao.charAt(i) != '{' && expressao.charAt(i) != '[' &&
                    expressao.charAt(i) != '+' && expressao.charAt(i) != '-' && expressao.charAt(i) != '*'
                    && expressao.charAt(i) != '/' && expressao.charAt(i) != ' '){
                if(valido < 48 || valido > 57){
                    System.out.println("Isso não é uma expressão aritmética só com números");
                    return false;
                }
            }

            //pula os espaços dados na string
            if(expressao.charAt(i) ==' ') continue;

            pilhaExpressao.push(expressao.charAt(i));

            //Começa a calcular a expressão infixa da primeira abertura de parênteses encontrada da direita para a esquerda
            if(expressao.charAt(i) == '(' || expressao.charAt(i) == '{' || expressao.charAt(i) == '[') {

                pilhaExpressao.pop();

                char fechaRodada = '\0';
                char operador = '\0';

                StringBuilder operando1 = new StringBuilder();
                StringBuilder operando2 = new StringBuilder();

                // Esses booleanos ajudam a permitir adicionar sinais aos operandos da operação aritmética
                // (permitindo números positivos e negativos, ou adicionar o sinal '+' a um número positivo)
                boolean operando1Vazio = true;
                boolean operando2Vazio = true;

                //Define o primeiro operando de uma operação dentro dos parênteses e seu operador
                while (operador == '\0') {
                    char auxiliar = pilhaExpressao.pop();
                    int numero = auxiliar;

                    //Se só houver um operando dentro de um par de parênteses retorna falso
                    if (auxiliar == ')' || auxiliar == ']' || auxiliar == '}') {
                        System.out.println("Não é uma expressão aritmética.");
                        return false;
                    }

                    //retorna falso caso haja operadores de mais na operação sendo testada dentro dos parênteses
                    if ((auxiliar == '*' || auxiliar == '/')&& operando1Vazio) {
                        System.out.println("Existem muitos operadores ou falta de parênteses");
                        return false;
                    }
                    //Adiciona o possível sinal ao operando1
                    if ((auxiliar == '+' || auxiliar == '-') && operando1Vazio) {
                        operando1.append(auxiliar);
                    }

                    if (numero > 47 && numero < 58) {
                        operando1.append(auxiliar);
                        operando1Vazio = false;
                    }

                    //Ao encontrar o operador da operação entre os parênteses ele é adicionado ao char 'operador' e
                    // a condição para encerrar o loop que define o operando1, o char 'operador' não ser vazio, é atingida
                    // e o loop se encerra
                    if ((auxiliar == '+' || auxiliar == '-' || auxiliar == '*' || auxiliar == '/') && !operando1Vazio) {
                        operador = auxiliar;

                    }
                }
                //Define o segundo operando da mesma operação parentizada
                while (fechaRodada == '\0') {
                    char auxiliar = pilhaExpressao.pop();
                    int numero = auxiliar;

                    //Adiciona o possível sinal ao operando2
                    if (( auxiliar == '-'|| auxiliar =='+') && operando2Vazio) {
                        operando2.append(auxiliar);
                    }

                    if (numero > 47 && numero < 58){
                        operando2.append(auxiliar);
                        operando2Vazio=false;
                    }

                    //retorna falso caso haja operadores de mais na operação sendo testada dentro dos parênteses
                    if (( auxiliar == '-' || auxiliar =='+') && !operando2Vazio) {
                        System.out.println("Existem muitos operadores ou falta de parênteses");
                        return false;
                    }

                    //retorna falso caso haja operadores de mais na operação sendo testada dentro dos parênteses
                    if (auxiliar == '*' || auxiliar == '/') {
                        System.out.println("Existem muitos operadores ou falta de parênteses");
                        return false;
                    }

                    // a condição para encerrar o loop que define o operando2, o char 'fechaRodada' não ser vazio, é atingida
                    // e o loop se encerra
                    if (auxiliar == ')' || auxiliar == '}' || auxiliar == ']') {
                        fechaRodada = auxiliar;

                    }
                }

                //Cria strings que recebem os caracteres alocados nos StringBuilders operando1 e operando2
                String operando1Str = operando1.toString();
                String operando2Str = operando2.toString();

                //Printa a operação que está prestes a ser realizada
                System.out.println(operando1Str + " " + operador + " " + operando2Str);

                String respostaParcial="";
                try {
                    //A string respostaParcial vira endereço do resultado do método operacaoParcial. Para o funcionamento
                    //desse método são passadas as strings dos operandos para tipos
                    // int; caso o 'parse' falhe por uma exceção do tipo NumberFormatException,provavelmente por haver
                    // mais de um sinal de '-' ou de '+' à frente de um operando, é printado que há um erro nos
                    // operandos e o método 'avaliaExpressao' retorna falso
                    respostaParcial = operacaoParcial(Integer.parseInt(operando1Str), Integer.parseInt(operando2Str), operador);
                } catch (NumberFormatException exception) {

                    System.out.println("Um dos operandos acima ou ambos não são válidos.");
                    return false;
                }

                //passa os caracteres do resultado parcial em formato de string para a pilha
                int j = respostaParcial.length() - 1;
                while (j > -1) {

                    pilhaExpressao.push(respostaParcial.charAt(j));
                    j--;
                }
            }
        }
        //Ao final da leitura da string 'expressão' sobra na pilha o resultado final da expressão aritmética infixa. Os caracteres que
        // formam o resultado são desempilhados e adicionados no stringBuilder, que após compõe a string respostaString,
        // cujo valor é convertido para int e passado para o atributo int resposta.
        StringBuilder R = new StringBuilder();
        while (!pilhaExpressao.pilhaVazia()){
            R.append(pilhaExpressao.pop());
        }
        String respostaString = R.toString();
        resposta = Integer.parseInt(respostaString);
        return true;
    }

    public int getResposta(){
        return resposta;
    }
}
