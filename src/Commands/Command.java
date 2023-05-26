package Commands;

public abstract class Command{
    public abstract void execute(CalcContext context) throws CalcException;
}
