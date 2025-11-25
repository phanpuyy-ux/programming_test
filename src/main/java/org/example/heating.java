package org.example;

public class heating extends Control{
    int WardID;

    public heating(boolean status, int WardID){
        super(status);
        this.WardID = WardID;
    }

    public int getWardID(){
        return WardID;
    }

}
