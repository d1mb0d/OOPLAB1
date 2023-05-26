//Subtraction.java
package Commands;

import Exceptions.CalcException;
public class Subtraction extends Command{
    @Override
    public void execute(CalcContext context) throws CalcException {
        double operand2 = context.pop();
        double operand1 = context.pop();
        double result = operand1 - operand2;
        context.push(result);
    }
}
