package com.example.smallcalculations.ViewModel;

import com.example.smallcalculations.Model.SmallCalculations;

public class ViewModel {
    public class DisplayableResult{
        public int result;
        public boolean calculationSuccessful;
        public String errorMessage;
    }


    //implement: errormessage: model not connected
    //implement: model not knowing the viewmodel
    private class CalculationsModel{
        SmallCalculations testTest = new SmallCalculations();

    }

    public ViewModel(){

    }

    public DisplayableResult getResult(){
        int result = 0;
        boolean success=true;
        String errorMessage="none";
        DisplayableResult returnValue= new DisplayableResult();
        returnValue.calculationSuccessful=true;
        returnValue.result=0;
        returnValue.errorMessage="none";
        return returnValue;
    }
    public void runViewModel(){
        //each time we press any button in the UI we run Viewmodel tell this class that we
        //have new data that it can get from a container
        //the viewModel decides what data it wants to get it does not know what data exists.

        //example: tell me the input for a and b IN CASE there is some
        //if I get new input for a and b I tell my model to do X
        //if I get new information I display to the view that he can get new info and update its contents
        //the view has a reference to the ViewModel, whileas the ViewModel does not know about the View or it's data
        //the ViewModel retrieves the Data from the model that we want
        //this means: We set a and b are

        //the model is not tied to the viewmodel and can  run on its own.

    }

    public void setUserActionCalculate(boolean isActivated){

    }

    public void setSummand1(int a){

    }

    SmallCalculations test1 = new SmallCalculations();
    DisplayableResult test2 = new DisplayableResult();

    public void doCalculate(){
        test1.setSummand1(1);
        test1.setSummand2(1);
        test1.addSummands();
        int result = test1.getResult();
        test2.result=result;
        test2.errorMessage="none";
        test2.calculationSuccessful=true;
    }

    public DisplayableResult getDisplayableResult(){
        return test2;
    }
}
