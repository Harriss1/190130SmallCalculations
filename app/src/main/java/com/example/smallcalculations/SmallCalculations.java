package com.example.smallcalculations;

public class SmallCalculations {
    private int m_time;
    private String name;

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

}
