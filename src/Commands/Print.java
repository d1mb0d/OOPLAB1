package Commands;

public class Print extends Command{
    @Override
    public void execute(CalcContext context) throws CalcException {
        context.printStack();
    }
}
