package com.example.smallcalculations;

public class SmallCalculations {
    private int m_time;
    private String name;
    private int summand1, summand2;
    private int summandsResult=0;

    public SmallCalculations(){
        m_time=5;
        name = "Mike";

    }

    public int printNumber(int i){
        return i+1;
    }
    public int printTime(){
        return this.m_time;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name=newName;
    }

    public int getResult(){
        return summandsResult;
    }

    public void setSummand1(int a){
        summand1=a;
    }
    public void setSummand2(int a){
        summand2=a;
    }
    public void addSummands(){
        summandsResult=summand1+summand2;
    }
}
