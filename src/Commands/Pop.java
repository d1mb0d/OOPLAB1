//Pop.java
package Commands;

import Exceptions.CalcException;

public class Pop extends Command {
    public Pop() {
        // Constructor
    }
    @Override
    public void execute(CalcContext context) throws CalcException {
        context.pop();
    }
}
