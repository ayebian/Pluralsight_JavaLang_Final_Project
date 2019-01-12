package com.ayebian.project.calcEngine;

//Created by Ayebare Ian on 12/01/2018

public class MathEquation {
    public double leftVal;
    public double rightVal;
    public double result;
    public char opCode;


    public void execute (){
        switch (opCode){
            case 'a':
                result = leftVal + rightVal;
                break;
            case  's':
                result = leftVal - rightVal;
                break;
            case 'd':
                result= (rightVal != 0.0d) ? leftVal / rightVal : 0.0d;
                break;
            case 'm':
                result = rightVal * leftVal;
                break;

            default:
                System.out.println("Error -Invalid opCode");
                result =0.0d;
        }
    }



}
