//Command.java
package Commands;

import Exceptions.CalcException;

public abstract class Command{
    public abstract void execute(CalcContext context) throws CalcException;
}
