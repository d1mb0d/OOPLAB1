package Commands;

public class Sqrt extends Command{
    @Override
    public void execute(CalcContext context) throws CalcException {
        double operand = context.pop();

        if (operand < 0) {
            throw new CalcException("Square root of a negative number is undefined");
        }

        double result = Math.sqrt(operand);
        context.push(result);
    }
}
