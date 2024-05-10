package Principal;

import gals.*;
import java.io.IOException;
public class Main {
    
    public static void main(String[] args) throws IOException{
         try
         {
            Lexico lexico = new Lexico("A=101101; B = 101; C = 1101; D = Math.log(A*((C/B)^B)); show(D);");
            
            Sintatico sintatico = new Sintatico();
            Semantico semantico = new Semantico();

            sintatico.parse(lexico, semantico);
        }
            catch ( LexicalError | SyntaticError | SemanticError e )
            {
                System.out.println("Comando não identificado.");
            }
    }
}
