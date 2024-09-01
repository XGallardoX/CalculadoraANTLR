import org.antlr.v4.runtime.tree.TerminalNode;

public class EvalVisitor extends LabeledExprBaseVisitor<Double> {

    @Override
    public Double visitStat(LabeledExprParser.StatContext ctx) {
        // Imprimir el contexto visitado
        // System.out.println("Visiting Stat: " + ctx.getText());

        // Evaluar expresión
        if (ctx.expr() != null) {
            return visit(ctx.expr());
        }

        // Lógica para asignaciones o nuevas líneas
        if (ctx.ID() != null && ctx.expr() != null) {
            // Aquí se puede agregar la lógica para manejar variables si se desea
            System.out.println("Asignación no implementada para: " + ctx.ID().getText());
            return visit(ctx.expr());
        }

        return 0.0; // Si es solo un newline, puede retornar 0.0 o lo que decidas
    }

    @Override
    public Double visitExpr(LabeledExprParser.ExprContext ctx) {
        // Imprimir el texto del contexto para depuración
        // System.out.println("Visiting Expr: " + ctx.getText());

        // Manejo de la función valor absoluto
        if (ctx.ABS() != null) {
            double value = visit(ctx.expr(0)); // `ctx.expr(0)` porque `abs` solo tiene un argumento
            return Math.abs(value);
        }

        // Manejo de operaciones binarias
        if (ctx.op != null) {
            double left = visit(ctx.expr(0));
            double right = visit(ctx.expr(1));
            String operator = ctx.op.getText();
            System.out.println("Operación: " + operator + " con valores " + left + " y " + right);

            switch (operator) {
                case "+":
                    return round(left + right);
                case "-":
                    return round(left - right);
                case "*":
                    return round(left * right);
                case "/":
                    if (right == 0) {
                        throw new ArithmeticException("División por cero");
                    }
                    return round(left / right);
                case "^":
                    return round(Math.pow(left, right));
                default:
                    throw new RuntimeException("Operador desconocido: " + operator);
            }
        }

        // Manejo de operaciones con paréntesis
        if (ctx.expr().size() == 1) {
            return visit(ctx.expr(0));
        }

        // Manejo de números enteros
        if (ctx.INT() != null) {
            double value = Double.parseDouble(ctx.INT().getText());
            System.out.println("Número entero: " + value);
            return value;
        }

        // Manejo de números flotantes
        if (ctx.FLOAT() != null) {
            double value = Double.parseDouble(ctx.FLOAT().getText());
            System.out.println("Número flotante: " + value);
            return value;
        }

        // Manejo de identificadores
        if (ctx.ID() != null) {
            System.out.println("Identificador no implementado: " + ctx.ID().getText());
            return 0.0;
        }

        // Lógica para el caso por defecto
        throw new RuntimeException("Expresión desconocida: " + ctx.getText());
    }

    // Método para redondear a 10 decimales
    private double round(double value) {
        return Math.round(value * 1e10) / 1e10;
    }
}
