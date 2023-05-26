//CalcContext.java
package Commands;

import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

import Exceptions.*;

public class CalcContext {
    private Stack<Double> stack;
    private Map<String, Double> definedValues;

    public CalcContext() {
        stack = new Stack<>();
        definedValues = new HashMap<>();
    }

    public void push(double value) {
        stack.push(value);
    }

    public double pop() throws CalcException {
        if (stack.isEmpty()) {
            throw new CalcException("Stack underflow");
        }
        return stack.pop();
    }

    public void define(String parameter, double value) {
        definedValues.put(parameter, value);
    }

    public double getValue(String parameter) throws CalcException {
        if (!definedValues.containsKey(parameter)) {
            throw new CalcException("Undefined parameter: " + parameter);
        }
        return definedValues.get(parameter);
    }

    public double[] getStack() {
        double[] stackArray = new double[stack.size()];
        int index = 0;
        for (Double value : stack) {
            stackArray[index++] = value;
        }
        return stackArray;
    }

    public void printStack() {
        System.out.println("Stack contents:");
        for (Double value : stack) {
            System.out.println(value);
        }
    }
}
