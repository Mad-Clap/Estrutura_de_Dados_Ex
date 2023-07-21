package Lista8.ex04;

import java.util.NoSuchElementException;

public class ArvBinBusca<Chave extends Comparable<Chave>, Valor> 
{
	private No raiz; /* Raiz da �rvore. */

	private class No
	{
		private Chave chave; /* Chave usada nas compara��es. */
		private Valor valor; /* Informa��o armazenada. */
		private No esq, dir; /* Refer�ncias para sub�rvores esquerda e direita. */

		/* Cria um n� com chave e valor fornecidos e esq = dir = null. */
		public No(Chave chave, Valor valor)
		{
			this.chave = chave;
			this.valor = valor;
			this.esq = null;
			this.dir = null;
		}
		
		/* Cria um n� com chave e valor fornecidos. As sub�rvores esq e dir s�o
		 * passadas por par�metro. */
		public No(Chave chave, Valor valor, No esq, No dir)
		{
			this.chave = chave;
			this.valor = valor;
			this.esq = esq;
			this.dir = dir;
		}
	}
	
	/**
	 *  Cria��o de uma �rvore vazia. 
	 */
	public ArvBinBusca()
	{
		raiz = null;
	}
	
	/** 
	 * Verifica se a �rvore est� vazia.
	 * 
	 * @return se a �rvore est� vazia ou possui algum elemento
	 */
	public boolean vazia()
	{
		return (raiz == null);
	}
	
	/**
	 * Apresenta o conte�do da �rvore em ordem sim�trica.
	 */
	public void mostra()
	{
		mostra(raiz);
	}
	
	private void mostra(No x)
	{
		/* Caso base (crit�rio de parada). */
		if(x == null)
			return;
		
		System.out.print("[");
		
		/* Chamada recursiva para a esquerda. */
		mostra(x.esq);
		
		/* Imprime a chave do n� corrente. */
		System.out.print("<" + x.chave + ">");
		
		/* Chamada recursiva para a direita. */
		mostra(x.dir);
		
		System.out.print("]");
	}
	
    /**
     * Retorna a menor chave da �rvore.
     *
     * @return a menor chave da �rvore
     * @throws NoSuchElementException se a �rvore est� vazia
     */
    public Chave min()
    {
        if(vazia()) 
        	throw new NoSuchElementException("�rvore est� vazia!");
        
        return min(raiz).chave;
    } 

    private No min(No x) { 
        if (x.esq == null) 
        	return x; 
        else
        	return min(x.esq); 
    }
    
    /**
     * Retorna o maior elemento da �rvore.
     *
     * @return o maior elemento da �rvore
     * @throws NoSuchElementException se a �rvore est� vazia
     */
    public Chave max() {
        if(vazia()) 
        	throw new NoSuchElementException("A �rvore est� vazia!");
        
        return max(raiz).chave;
    } 

    private No max(No x) {
        if (x.dir == null)
        	return x; 
        else
        	return max(x.dir); 
    }
    
    /**
     * Retorna o n�mero de n�s, isto �, pares (chave, valor), contidos na �rvore 
     * bin�ria de busca.
     * 
     * @return o n�mero de n�s da �rvore
     */
    public int tamanho()
    {
    	return tamanho(raiz);
    }
    
    private int tamanho(No x)
    {
    	/* Caso base (crit�rio de parada). */
    	if(x == null)
    		return 0;
    	
    	/* Chamada recursiva para sub�rvores esquerda e direita. */
    	return 1 + tamanho(x.esq) + tamanho(x.dir);
    }
    
    
    /**
     * Retorna a altura da �rvore bin�ria de busca.
     *
     * @return a altura da �rvore (uma �rvore de um �nico n� possui altura 0)
     */
    public int altura()
    {
    	return altura(raiz);
    }
    
    private int altura(No x)
    {
    	if(x == null)
    		return -1;
    	
    	int maxAltura = Math.max(altura(x.esq), altura(x.dir));
    	
    	return 1 + maxAltura;
    }
    
    
    /**
     * Essa �rvore bin�ria de busca cont�m a chave fornecida?
     *
     * @param  chave a chave fornecida
     * @return {@code true} se a �rvore cont�m a chave {@code chave} e
     *         {@code false} caso contr�rio
     * @throws IllegalArgumentException se {@code key} � {@code null}
     */
    public boolean contem(Chave chave) {
        if (chave == null) 
        	throw new IllegalArgumentException("A chave fornecida � null!");
        
        return get(chave) != null;
    }
	
    /**
     * Retorna o valor associado � chave fornecida.
     *
     * @param  chave a chave a ser buscada
     * @return o valor associado � chave fornecida se tal chave se encontra na �rvore
     *         e {@code null} se a chave n�o est� na �rvore
     * @throws IllegalArgumentException if {@code chave} is {@code null}
     */
    public Valor get(Chave chave) 
    {
        return get(raiz, chave);
    }

    private Valor get(No x, Chave chave) 
    {
        if(chave == null) 
        	throw new IllegalArgumentException("A chave fornecida � null!");
        
        /* A chave n�o se encontra na �rvore. */
        if(x == null)
        	return null;
        
        int cmp = chave.compareTo(x.chave);
        
        if(cmp < 0) /* Deve-se ir para a esquerda. */
        	return get(x.esq, chave);
        else if(cmp > 0) /* Deve-se ir para a direita. */
        	return get(x.dir, chave);
        else /* Chave encontrada. */
        	return x.valor;
    }
    
    /**
     * Insere na �rvore bin�ria de busca o par (chave, valor) fornecido. Caso a �rvore
     * j� possua a chave especificada, o valor antigo � sobrescrito com o novo valor 
     * fornecido. Remove o n� de chave igual � chave fornecida caso o valor especificado
     * seja {@code null}.
     *
     * @param  chave a chave fornecida
     * @param  valor o valor fornecido
     * @throws IllegalArgumentException se {@code chave} � {@code null}
     */
    public void put(Chave chave, Valor valor)
    {
        if(chave == null) 
        	throw new IllegalArgumentException("A chave fornecida � null!");
        
        if(valor == null) {
            delete(chave);
            return;
        }
        
        raiz = put(raiz, chave, valor);
    }

    private No put(No x, Chave chave, Valor valor)
    {
    	/* Caso base: encontrou a posi��o de inser��o. */
        if (x == null)
        	return new No(chave, valor);
        
        int cmp = chave.compareTo(x.chave);
        
        if(cmp < 0) /* Deve-se ir para a esquerda. */
        	x.esq = put(x.esq, chave, valor);
        else if(cmp > 0) /* Deve-se ir para a direita. */
        	x.dir = put(x.dir, chave, valor);
        else /* Caso tenha encontrado n� de mesma chave. */
        	x.valor = valor;
        
        return x;
    }
	
    /**
     * Remove o n� de menor chave da �rvore.
     *
     * @throws NoSuchElementException se a �rvore est� vazia
     */
    public void deleteMin() 
    {
        if(vazia())
        	throw new NoSuchElementException("A �rvore est� vazia!");
        
        raiz = deleteMin(raiz);
    }

    /* M�todo recursivo que anda sempre para a esquerda, procurando o n�
     * de menor chave a ser removido. */
    private No deleteMin(No x) 
    {
    	/* Caso n�o haja filho � esquerda, o n� corrente possui a menor chave. */
        if(x.esq == null) 
        	return x.dir;
        
        x.esq = deleteMin(x.esq);
        
        return x;
    }

    /**
     * Remove o n� de maior chave da �rvore.
     *
     * @throws NoSuchElementException se a �rvore est� vazia
     */
    public void deleteMax()
    {
        if(vazia())
        	throw new NoSuchElementException("A �rvore est� vazia!");
        
        raiz = deleteMax(raiz);
    }

    /* M�todo recursivo que anda sempre para a direita, procurando o n�
     * de maior chave a ser removido. */
    private No deleteMax(No x) 
    {
        if(x.dir == null)
        	return x.esq;
        
        x.dir = deleteMax(x.dir);
        
        return x;
    }
    
    /**
     * Remove o n� cuja chave seja igual � {@code chave} fornecida.
     * 
     * @param chave a chave fornecida
     * @return {@code true} se foi poss�vel remover o n� de chave {@code chave} e
     *         {@code false} caso contr�rio
     */
    public void delete(Chave chave)
    {    	
    	raiz = delete(raiz, chave);    	
    }
    
    /* Remove o n� com o valor "val" da "�rvore" a partir do n� para o qual est� sendo chamada a fun��o.
    Obs: "ref_no" � o ponteiro que referencia o n� para o qual est� sendo chamada a fun��o,
    o qual pode ter que ser modificado. Retorna false se o valor n�o pertencer � "�rvore".
    */
    private No delete(No x, Chave chave)
    {
    	if (x == null)
    		return null;

    	int cmp = chave.compareTo(x.chave);
    	
    	if(cmp < 0)
    		x.esq = delete(x.esq, chave);
    	else if(cmp > 0)
    		x.dir = delete(x.dir, chave);
    	else
    	{ 
    		if(x.dir == null)
    			return x.esq;
    		if(x.esq  == null)
    			return x.dir;
    		
    		No t = x;

    		/* Pega o menor da sub�rvore direita (mais � esquerda). */
    		x = min(t.dir);

    		/* Remove o menor. */
    		x.dir = deleteMin(t.dir);

    		/* A sub�rvore esquerda se mant�m a mesma. */
    		x.esq = t.esq;
    	}

    	return x;
    }
    
    
    /**
     * Retorna a maior chave na �rvore que � menor ou igual � {@code chave} fornecida.
     *
     * @param  chave a chave fornecida
     * @return a maior chave na �rvore menor ou igual � {@code chave}
     * @throws NoSuchElementException se a �rvore est� vazia
     * @throws IllegalArgumentException se a {@code chave} � {@code null}
     */
    public Chave piso(Chave chave)
    {
        if (chave == null)
        	throw new IllegalArgumentException("A chave fornecida � null!");
        
        if (vazia()) 
        	throw new NoSuchElementException("A �rvore est� vazia!");
        
        No x = piso(raiz, chave);
        
        if (x == null)
        	return null;
        else
        	return x.chave;
    } 

    private No piso(No x, Chave chave)
    {
        if (x == null)
        	return null;
        
        int cmp = chave.compareTo(x.chave);
        
        if (cmp == 0)
        	return x;
        
        if (cmp <  0)
        	return piso(x.esq, chave);
        
        No t = piso(x.dir, chave);

        if (t != null) 
        	return t;
        else
        	return x; 
    }

    
    /**
     * Retorna a menor chave na �rvore que � maior ou igual � {@code chave} fornecida.
     *
     * @param  chave a chave fornecida
     * @return a menor chave na �rvore maior ou igual � {@code chave}
     * @throws NoSuchElementException se a �rvore est� vazia
     * @throws IllegalArgumentException se a {@code chave} � {@code null}
     */
    public Chave topo(Chave chave)
    {
        if (chave == null) 
        	throw new IllegalArgumentException("A chave fornecida � null!");

        if (vazia())
        	throw new NoSuchElementException("A �rvore est� vazia!");
        
        No x = topo(raiz, chave);
        
        if (x == null)
        	return null;
        else 
        	return x.chave;
    }

    private No topo(No x, Chave chave)
    {
        if (x == null)
        	return null;
        
        int cmp = chave.compareTo(x.chave);
        
        if (cmp == 0)
        	return x;
        
        if (cmp < 0)
        { 
            No t = topo(x.esq, chave);
            
            if (t != null)
            	return t;
            else
            	return x; 
        } 
        
        return topo(x.dir, chave); 
    }


    //RESPOSTA EXERCICIO 4
    public boolean removeForaIntervalo(Chave chaveMin, Chave chaveMax){

        //Caso uma das chaves seja nula, ou chaveMax seja menor que chaveMin, ou s� haja um n� na �rvore,
        // o m�todo retorna false (no �ltimo caso porque, mesmo que seja declarada como par�metro
        // para chaveMin a �nica chave existente na �rvore, nada ser� removido).
            if (chaveMin == null || chaveMax ==null) return false;
            if(chaveMax.compareTo(chaveMin)<0) return false;
            if(raiz.esq==null && raiz.dir==null) return false;

        //Os booleanos indicam se algo foi removido acima do valor m�nimo e/ou abaixo do valor m�ximo,
        // e eles que s�o retornados ao final da execu��o. Caso um deles seja true, o m�todo retorna true.
        boolean removeAcima= removeForaIntervaloAuxiliar(chaveMin,true);
        boolean removeAbaixo= removeForaIntervaloAuxiliar(chaveMax,false);

        return removeAbaixo || removeAcima;
    }

    //O m�todo recebe uma das chaves e o booleando chaveMin, que serve justamente para saber se o m�todo
    // est� recebendo o objeto Chave chaveMin ou chaveMax. Ele retorna um booleano que indica se o retorno
    // do m�todo removeSubArvore() � nulo ou n�o. Sendo nulo significa que o outro m�todo rodou a
    // �rvore inteira, e n�o existe nenhum n� com a chave fornecida.
    private boolean removeForaIntervaloAuxiliar(Chave chave, Boolean chaveMin)
    {
        return removeSubArvore(raiz, chave, chaveMin) != null;
    }

    //Esse m�todo � uma modifica��o do m�todo getchave(), mas ao inv�s de retornar a chave ou seu valor ele realiza
    // a exclus�o das sub-�rvores acima e abaixo dos n�s com as chaves cujo valor � igual a chaveMin e chaveMax.
    // Ele tamb�m recebe um par�metro a mais que o m�todo getchave(), sendo este o booleano chaveMin.
    private No removeSubArvore(No x, Chave chaveRemove, Boolean chaveMin )
    {
        // Chave n�o se encontra na �rvore.
        if(x == null)
            return null;

        int cmp = chaveRemove.compareTo(x.chave);

        if(cmp < 0) /* Deve-se ir para a esquerda. */
            return removeSubArvore(x.esq, chaveRemove, chaveMin);
        else if(cmp > 0) /* Deve-se ir para a direita. */
            return removeSubArvore(x.dir, chaveRemove, chaveMin);
        else{
            //O booleano chaveMin serve para determinar o que ser� feito ao encontrar o n� com a chave
            // desejada. Caso o m�todo tenha a chave chaveMin passada como par�metro,
            // o booleano chaveMin ser� true, e o n� encontrado passar� a ser o n� raiz da �rvore.
            // Caso o booleano seja false, o m�todo tem como par�metro a chave chaveMax,
            // e o m�todo ir� excluir as sub-�rvores direita e esquerda do n�.
            if(chaveMin) raiz=x;
            else {
                x.dir=null;
                x.esq=null;
            }
        }

        return x;
    }

}