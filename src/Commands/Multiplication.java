//Multiplication.java
package Commands;

import Exceptions.CalcException;
public class Multiplication extends Command {
    @Override
    public void execute(CalcContext context) throws CalcException {
        double operand1 = context.pop();
        double operand2 = context.pop();
        double result = operand1 * operand2;
        context.push(result);
    }
}
