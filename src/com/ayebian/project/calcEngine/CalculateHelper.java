package com.ayebian.project.calcEngine;

public class CalculateHelper {
    private static  final  char ADD_SYMBOL = '+';
    private static  final  char DIVIDE_SYMBOL = '/';
    private static  final  char MULTIPLY_SYMBOL = '*';
    private static  final  char SUBTRACT_SYMBOL = '-';



    MathCommand command;
    double leftValue;
    double rightValue;
    double result;

    public void process (String statement) throws InvalidStatementException {

        String[] parts = statement.split(" ");
        if (parts.length !=3)
            throw new InvalidStatementException("Incorrect number of fields",statement);

//        add 1.0 2.0
        String commandString = parts[0]; //add

        try{
            leftValue = Double.parseDouble(parts[1]); //1.0
            rightValue = Double.parseDouble(parts[2]); //2.0
        } catch (NumberFormatException e){
            throw new InvalidStatementException("Non-numeric data", statement, e);
        }

        setCommandFromSting(commandString);
        if (command == null)
            throw new InvalidStatementException("Invalid command", statement);
        CalculateBase calculator = null;

        switch (command){
            case Add:
                calculator = new Adder(leftValue, rightValue);
                break;
            case Divide:
                calculator = new Divider(leftValue, rightValue);
                break;
            case Multiply:
                calculator = new Multiplier(leftValue, rightValue);
                break;
            case Subtract:
                calculator = new Subtractor(leftValue, rightValue);
                break;
        }

        calculator.calculate();
        result = calculator.getResult();
    }

    private void setCommandFromSting ( String commandString){
        // add -> MathCommand.Add

        if (commandString.equalsIgnoreCase(MathCommand.Add.toString()))
            command = MathCommand.Add;
        else if ( commandString.equalsIgnoreCase(MathCommand.Divide.toString()))
            command = MathCommand.Divide;
        else if (commandString.equalsIgnoreCase(MathCommand.Multiply.toString()))
            command = MathCommand.Multiply;
        else if (commandString.equalsIgnoreCase(MathCommand.Subtract.toString()))
            command = MathCommand.Subtract;
    }

    @Override
    public String toString(){
//        1.0 + 2.0 = 3.0

        char symbol = ' ';
        switch (command){
            case Add:
                symbol = ADD_SYMBOL;
                break;
            case Multiply:
                symbol = MULTIPLY_SYMBOL;
                break;
            case Subtract:
                symbol = SUBTRACT_SYMBOL;
                break;
            case Divide:
                symbol = DIVIDE_SYMBOL;
                break;
        }

        StringBuilder sb = new StringBuilder(20);
        sb.append(leftValue);
        sb.append(' ');
        sb.append(symbol);
        sb.append(' ');
        sb.append(rightValue);
        sb.append(' ');
        sb.append('=');
        sb.append(' ');
        sb.append(result);
        return sb.toString();

    }
}
