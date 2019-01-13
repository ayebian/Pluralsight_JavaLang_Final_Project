package com.ayebian.project.calcEngine;

public class Main {

    public static void main(String[] args) {


        String [] statements = {
                "add 1.0",//Error - Incorrect number of fields
                "add xx 25.0", //None numeric data
                "addx 0.0 0.0", // Invalid command
                "add 25.0 92.0",
                "Power 5.0 2.0",
                "Multiply 11.0 3.0",
                "Divide 100.0 50.0",
                "Subtract 225.0 17.0"

        };

        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
                new PowerOf(),
                new Adder(),
                new Divider(),
                new Multiplier(),
                new Subtractor()
        });

        for (String statement: statements) {
            try{
                String output = helper.process(statement);
                System.out.println(output);
            }catch (InvalidStatementException e){
                System.out.println(e.getMessage());
                if (e.getCause() != null)
                    System.out.println("Original Exception: " + e.getCause().getMessage());
            }

        }
    }

}
