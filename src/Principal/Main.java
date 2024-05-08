package Principal;

import gals.*;
import java.io.IOException;
public class Main {
     public static void main(String[] args) throws IOException{
         
         try
         {
            Lexico lexico = new Lexico("A=(100+11*11)^11;B = 10; C = Math.log(B); show(C);");
            
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
