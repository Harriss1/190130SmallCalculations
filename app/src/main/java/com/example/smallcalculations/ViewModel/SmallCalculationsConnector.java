package com.example.smallcalculations.ViewModel;

import android.widget.TextView;

import com.example.smallcalculations.Model.SmallCalculations;
//import com.example.smallcalculations.ViewModel.DisplayableResult;

public class SmallCalculationsConnector extends ViewModel {

    SmallCalculations smallCalculations = new SmallCalculations();
    DisplayableResult resultContainer = new DisplayableResult();

    public void setA(double a) {

        smallCalculations.setFirstNumber(a);
    }

    //I expect TextView to be the usual input type (The View is not supposed to convert input!!!),
    //the class should be reusable though.
    public void setA(TextView a) {
        setA(Double.parseDouble(a.getText().toString()));
    }

    public void setA(int a) {

        setA((double) a);
    }

    public void setA(String a) {
        //this is bad practise, I should send an error message to View.
        //But I don't know how to make it properly. The message would be generated in the ViewModel.
        if (a.isEmpty()) {
            setA(0);
            return;
        }
        setA(Double.parseDouble(a));
        //smallCalculations.setFirstNumber(10);
    }

    public void setB(double b) {
        smallCalculations.setSecondNumber(b);
    }

    public void setB(TextView b) {
        setB(Double.parseDouble(b.getText().toString()));
    }

    public void setB(int b) {
        setB((double) b);
    }

    public void setB(String b) {
        if (b.isEmpty()) {
            setB(0);
            return;
        }
        setB(Double.parseDouble(b));
        //smallCalculations.setSecondNumber(20);
    }

    public void setOperator(int operator) {
        switch (operator) {
            case 0: {
                smallCalculations.setOperatorType(SmallCalculations.Operator.PLUS);
                break;
            }
            case 1: {
                smallCalculations.setOperatorType(SmallCalculations.Operator.MINUS);
                break;
            }
            case 2: {
                smallCalculations.setOperatorType(SmallCalculations.Operator.MULTIPLY);
                break;
            }
            case 3: {
                smallCalculations.setOperatorType(SmallCalculations.Operator.DIVIDE);
                break;
            }
        }

    }

    public DisplayableResult getResult() {
        //getResult doesnt feel like Cleancode. Its not explaining that I calculate it here
        // when I read through this piece of code I dont know what its doing except for when I study the
        //model class...
        SmallCalculations.ResultContainer resultFromModel = smallCalculations.getResult();

        //todo handle error message from model...

        resultContainer.calculationSuccessful = resultFromModel.getCalculationSuccessful();
        resultContainer.result = resultFromModel.getResultNumber();
        resultContainer.errorMessage = resultFromModel.getErrorMessage();
        //resultContainer.calculationSuccessful = true;

        if (!resultFromModel.getCalculationSuccessful()){
            //tell the view to display the error
            //maybe this:
            //resultContainer.result = ("Error: " + resultFromModel.getErrorMessage().toString());
        }
        //resultContainer.calculationSuccessful=resultFromModel.getCalculationSuccessful();
        //resultContainer.errorMessage="none";
        //resultContainer.result=5.1;
        return resultContainer;
    }

}
