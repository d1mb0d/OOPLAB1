//Division.java
package Commands;

import Exceptions.CalcException;
public class Division extends Command{
    @Override
    public void execute(CalcContext context) throws CalcException {
        double divisor = context.pop();
        double dividend = context.pop();

        if (divisor == 0) {
            throw new CalcException("Division by zero error");
        }

        double result = dividend / divisor;
        context.push(result);
    }
}
