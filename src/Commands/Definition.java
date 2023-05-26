//Definition.java
package Commands;

import Exceptions.CalcException;

public class Definition extends Command {
    private String parameter;
    private double value;

    public Definition() {
        // Default constructor without arguments
    }

    public Definition(String parameter, double value) {
        this.parameter = parameter;
        this.value = value;
    }

    @Override
    public void execute(CalcContext context) throws CalcException {
        context.define(parameter, value);
    }
}
