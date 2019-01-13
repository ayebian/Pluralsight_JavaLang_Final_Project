package com.ayebian.project.calcEngine;

public class Main {

    public static void main(String[] args) {

//        MathEquation[] equations = new MathEquation[4];
//        equations[0]= new MathEquation(100.0d,50.0d,'d');
//        equations[1]= new MathEquation(25.0d,92.0d,'a');
//        equations[2]= new MathEquation(225.0d,17.0d,'s');
//        equations[3]= new MathEquation(11.0d,3.0d,'m');


//        for (MathEquation equation:equations){
//            equation.execute();
//            System.out.print("Result = ");
//            System.out.println(equation.getResult());
//        }


        String[] statements= {
                "add 1.0",//Error - Incorrect number of fields
                "add xx 25.0", //None numeric data
                "addx 0.0 0.0", // Invalid command
                "divide 100.0 50.0",
                "add 25.0 92.0",
                "subtract 225.0 17.0",
                "multiply 11.0 3.0"
        };

        CalculateHelper helper = new CalculateHelper();
        for (String statement: statements){
            try{
                helper.process(statement);
                System.out.println(helper);
            }catch (InvalidStatementException e){
                System.out.println(e.getMessage());
                if (e.getCause() != null)
                    System.out.println("Original Exception: " + e.getCause().getMessage());
            }

        }



//        CalculateBase[] calculators = {
//                new Divider(100.0d,50.0d),
//                new Adder( 25.0d, 92.0d),
//                new Subtractor(225.0d,17.0d),
//                new Multiplier(11.0d, 3.0d)
//        };
//
//        for (CalculateBase calculator:calculators){
//            calculator.calculate();
//            System.out.print("Result = ");
//            System.out.println(calculator.getResult());
//        }




    }

}
