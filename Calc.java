import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calc {

    public static void main(String[] args) {
        try {
            BufferedReader reader;
            if (args.length == 1) {
                // Leer desde el archivo proporcionado
                String fileName = args[0];
                reader = new BufferedReader(new FileReader(fileName));
            } else {
                // Leer desde la entrada estándar (consola)
                System.out.println("Introduce expresiones (CTRL+D para finalizar):");
                reader = new BufferedReader(new InputStreamReader(System.in));
            }

            String inputString;

            while ((inputString = reader.readLine()) != null) { // Leer cada línea de entrada
                CharStream input = CharStreams.fromString(inputString);

                // Crear el lexer
                LabeledExprLexer lexer = new LabeledExprLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);

                // Imprimir tokens para depuración (opcional)
                tokens.fill();
                for (Token token : tokens.getTokens()) {
                    System.out.println("Token: " + token.getText() + " Tipo: " + token.getType());
                }

                // Crear el parser
                LabeledExprParser parser = new LabeledExprParser(tokens);
                ParseTree tree = parser.stat();
                System.out.println("Árbol de Análisis:");
                System.out.println(tree.toStringTree(parser));

                // Evaluar la expresión
                EvalVisitor eval = new EvalVisitor();
                try {
                    Double result = eval.visit(tree);
                    System.out.println("Resultado: " + result);
                } catch (ArithmeticException e) {
                    // Capturar y manejar específicamente la excepción de división por cero
                    System.out.println("Error: División por cero");
                } catch (RuntimeException e) {
                    // Capturar y manejar otras excepciones que puedan ocurrir durante la evaluación
                    System.out.println("Error durante la evaluación: " + e.getMessage());
                }
            }

            // Cerrar el BufferedReader
            reader.close();
        } catch (IOException e) {
            System.err.println("Error al leer el archivo o entrada: " + e.getMessage());
        }
    }
}
