import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import Commands.CalcContext;
import Commands.CalcException;
import Commands.Command;

public class Main {
    public static void main(String[] args) {
        CalcContext context = new CalcContext();
        CommandFactory commandFactory = new CommandFactory(context);
        Scanner scanner = null;

        String fileName = "src/commands.txt";

        boolean printExecuted = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String commandLine;
            while ((commandLine = reader.readLine()) != null) {
                try {
                    Command command = commandFactory.getCommand(commandLine);
                    if (command != null) {
                        command.execute(context);
                        if (command instanceof Commands.Print) {
                            printExecuted = true;
                        }
                    }
                } catch (CalcException e) {
                    System.out.println("Error executing command: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        if (!printExecuted) {
            System.out.println("Stack contents:");
            for (double value : context.getStack()) {
                System.out.println(value);
            }
        }
    }
}
