package Commands;

public class Pop extends Command {
    public Pop() {}
    @Override
    public void execute(CalcContext context) throws CalcException {
        context.pop();
    }
}
