package gals;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Semantico implements Constants
{
    Stack<Integer> stack = new Stack();
    Map<String, Integer> vars = new HashMap<String, Integer>();
    String ultimaVariavel;
    public void executeAction(int action, Token token)	throws SemanticError
    {
        System.out.println("acao " + action + " -> token " + token.getLexeme());
        //System.out.println("Ação #"+action+", Token: "+token);
        Integer a, b;
        switch (action)
        { 
            case 1: //Empilha numeros #1
              stack.push(Integer.parseInt(token.getLexeme(), 2));
              break;
            case 2: //Empilha variavel #2
              stack.push(vars.get(token.getLexeme()));
              break;
            case 3://adição
              b = stack.pop();
              a = stack.pop();
              stack.push(new Integer(a.intValue() + b.intValue()));
              break;
            case 4://subtração
              b = stack.pop();
              a = stack.pop();
              stack.push(new Integer(a.intValue() - b.intValue()));
              break;
            case 5://multiplicação
              b = stack.pop();
              a = stack.pop();
              stack.push(new Integer(a.intValue() * b.intValue()));
              break;
            case 6://divisão
              b = stack.pop();
              a = stack.pop();
              stack.push(new Integer(a.intValue() / b.intValue()));
              break;
            case 7: //exponeciação
              b = stack.pop();
              a = stack.pop();
              Double A = Math.pow(a, b);
              stack.push(A.intValue());
              break;
            case 8: //FUNÇÃO IMPRIMIR
              System.out.print("Resultado: "+Integer.toBinaryString(vars.get(ultimaVariavel))+"\n");
              break;
            case 9: //ATRIBUI NO MAP O NOME DA VARIAVEL E SEU VALOR.
              vars.put(ultimaVariavel, stack.pop());
              break;
            case 10:    //USADO PARA SABER QUAL VARIAVEL ESTA SENDO TRABALHADO
              ultimaVariavel = token.getLexeme();
              break; 
              
        }
        //if (!vars.isEmpty())
        //System.out.print("Resultado: "+Integer.toBinaryString(vars.get(ultimaVariavel))+"\n");
    }	
}
