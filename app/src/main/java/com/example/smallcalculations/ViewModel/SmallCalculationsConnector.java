package com.example.smallcalculations.ViewModel;

import android.widget.TextView;

import com.example.smallcalculations.Model.SmallCalculations;
//import com.example.smallcalculations.ViewModel.DisplayableResult;

public class SmallCalculationsConnector extends ViewModel {

    SmallCalculations smallCalculations = new SmallCalculations();
    DisplayableResult resultContainer= new DisplayableResult();

    public void setA(double a){

        smallCalculations.setFirstNumber(a);
    }
    //I expect TextView to be the usual input type (The View is not supposed to convert input!!!),
    //the class should be reusable though.
    public void setA(TextView a) {
        setA(Double.parseDouble(a.getText().toString()));
    }
    public void setA(int a){

        setA((double)a);
    }
    public void setA(String a){
        setA(Double.parseDouble(a));
        //smallCalculations.setFirstNumber(10);
    }

    public void setB(double b){
        smallCalculations.setSecondNumber(b);
    }
    public void setB(TextView b){
        setB(Double.parseDouble(b.getText().toString()));
    }
    public void setB(int b){
        setB((double)b);
    }
    public void setB(String b){
        if (b.isEmpty()){
            //ErrorMessage or set to 0?
            //I want to use an Errormessage.
        }
        setB(Double.parseDouble(b));
        //smallCalculations.setSecondNumber(20);
    }

    public void setOperator(int operator){
        smallCalculations.setOperatorType(SmallCalculations.Operator.PLUS);
    }

    public DisplayableResult getResult(){
        SmallCalculations.ResultContainer resultFromModel=smallCalculations.getResult();

        resultContainer.calculationSuccessful = resultFromModel.getCalculationSuccessful();
        resultContainer.result = resultFromModel.getResultNumber();
        resultContainer.errorMessage = resultFromModel.getErrorMessage();
        //resultContainer.calculationSuccessful = true;

        //resultContainer.calculationSuccessful=resultFromModel.getCalculationSuccessful();
        //resultContainer.errorMessage="none";
        //resultContainer.result=5.1;
        return resultContainer;
    }

}
