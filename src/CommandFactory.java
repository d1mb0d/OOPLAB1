import java.util.HashMap;
import java.util.Map;

import Commands.*;

public class CommandFactory {
    private Map<String, Command> commandMap;
    private CalcContext context;

    public CommandFactory(CalcContext context) {
        this.context = context;
        commandMap = new HashMap<>();
        initializeCommands();
    }

    private void initializeCommands() {
        Command popCommand = new Pop();
        Command additionCommand = new Addition();
        Command subtractionCommand = new Subtraction();
        Command multiplicationCommand = new Multiplication();
        Command divisionCommand = new Division();
        Command sqrtCommand = new Sqrt();
        Command printCommand = new Print();

        commandMap.put("POP", popCommand);
        commandMap.put("+", additionCommand);
        commandMap.put("-", subtractionCommand);
        commandMap.put("*", multiplicationCommand);
        commandMap.put("/", divisionCommand);
        commandMap.put("SQRT", sqrtCommand);
        commandMap.put("PRINT", printCommand);
    }

    public Command getCommand(String inputText) throws CalcException {
        if (Comment.isComment(inputText)) {
            return Comment.createComment(inputText);
        }

        String[] tokens = inputText.split(" ", 3);
        String commandName = tokens[0];
        String value = tokens.length > 1 ? tokens[1] : null;
        if (commandName.equals("PUSH")) {
            return new Push(value);
        } else if (commandName.equals("DEFINE")) {
            String[] defineTokens = inputText.split(" ", 3);
            if (defineTokens.length == 3) {
                String variable = defineTokens[1];
                double parsedValue;
                if (isNumeric(defineTokens[2])) {
                    parsedValue = Double.parseDouble(defineTokens[2]);
                } else {
                    parsedValue = context.getValue(defineTokens[2]);
                }
                return new Definition(variable, parsedValue);
            } else {
                System.out.println("Invalid syntax for DEFINE command: " + value);
            }
            return null;
        } else {
            return commandMap.get(commandName);
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
}
