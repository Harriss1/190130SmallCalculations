package com.example.smallcalculations.Model;

public class SmallCalculations {
    //This class performs the four basic operations +-*/ with two doubles, returns one result.
    //It checks for valid input and returns an errorMessage-String what happens, because
    //I use a boolean that declares that the calculation wasn't successful, and I am not jet used to enums.



    private double firstNumber;
    private double secondNumber;


    public class ResultContainer{
        public double resultNumber;

        public boolean calculationSuccessful=false;
        public String errorMessage="none";
        public double getResultNumber(){
            return resultNumber;
        }
        public boolean getCalculationSuccessful(){
            return calculationSuccessful;
        }
        public String getErrorMessage(){return errorMessage;}
    }

    private ResultContainer resultContainer = new ResultContainer();

    public enum Operator{
        NOTSET, PLUS, MINUS, MULTIPLY,DIVIDE
    }
    private Operator operatorType;

    boolean firstNumberIsSet;
    boolean secondNumberIsSet;
    boolean operatorTypeIsSet;

    public SmallCalculations(){
        firstNumberIsSet=false;
        secondNumberIsSet=false;
        operatorTypeIsSet=false;
    }


    public void calculateResult(double a, double b, Operator operatorType){
        double result=9.999999;
        boolean calcSuccess=false;
        String errorMessage="";
        boolean calcValid=true;

        if (!firstNumberIsSet){
            errorMessage+="First number is not jet set. ";
            calcValid=false;
        }
        if (!secondNumberIsSet){
            calcValid=false;
            errorMessage+="Second number is not jet set. ";
        }
        if (!operatorTypeIsSet) {
            calcValid=false;
            errorMessage+="You didn't specify an operator. ";
        }

        if(calcValid)
        switch (operatorType){
            case NOTSET: {
                errorMessage+="You specified the NOTSET operator. ";

                break;
            }
            case PLUS:{ result=a+b; calcSuccess=true; break;}
            case MINUS: {result=a-b;calcSuccess=true; break;}
            case MULTIPLY: {result=a*b; calcSuccess=true; break;}
            case DIVIDE: {
                if (b!=0) {result=a/b; calcSuccess=true; break;}
                else{
                    errorMessage+="You can't divide by zero.";
                    break;
                }
            }
        }

        if (result == -0) {result=0;}
        resultContainer.calculationSuccessful=calcSuccess;
        resultContainer.errorMessage=errorMessage;
        resultContainer.resultNumber=result;
    }

    public ResultContainer getResult(){
        ResultContainer result = new ResultContainer();

        calculateResult(firstNumber, secondNumber, operatorType);
        result=resultContainer;

        return result;
    }

    //As Input I only allow one type. The ViewModel is responsible for handling inputs.
    public void setFirstNumber(double firstNumber){
        this.firstNumber=firstNumber;
        firstNumberIsSet=true;
    }
    public void setSecondNumber(double secondNumber){
        this.secondNumber=secondNumber;
        secondNumberIsSet=true;
    }
    public void setOperatorType(Operator operatorType){
        this.operatorType=operatorType;
        operatorTypeIsSet=true;
    }

    //is this really good practice? I guess the second function is really justified.
    public void setNumbers(double firstNumber, double secondNumber){
        setFirstNumber(firstNumber);
        setSecondNumber(secondNumber);
    }
    public void setSmallCalculation(double firstNumber, double secondNumber, Operator operatorType){
        setNumbers(firstNumber,secondNumber);
        setOperatorType(operatorType);
    }
}
