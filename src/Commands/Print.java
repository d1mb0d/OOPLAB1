//Print.java
package Commands;

import Exceptions.CalcException;

public class Print extends Command{
    @Override
    public void execute(CalcContext context) throws CalcException {
        context.printStack();
    }
}
