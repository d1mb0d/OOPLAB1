package Commands;

public class Push extends Command {
    private String valueString;
    private double valueNumber;

    public Push(String value) {
        if (isNumeric(value)) {
            this.valueNumber = Double.parseDouble(value);
        } else {
            this.valueString = value;
        }
    }

    private boolean isNumeric(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    @Override
    public void execute(CalcContext context) throws CalcException {
        if (valueString != null) {
            double value = context.getValue(valueString);
            context.push(value);
        } else {
            context.push(valueNumber);
        }
    }
}

