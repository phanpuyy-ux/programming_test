package org.example;

import Feeds.EnvironmentalSystem;

public class TemSen extends Sensor{
    private int WardID;
    private float Temp;
    private heating heating;

    public TemSen(EnvironmentalSystem environmentalSystem, int WardID,heating heating){
        super(environmentalSystem);
        this.WardID = WardID;
        this.heating = heating;
    }


    public float getTem(){
        this.Temp = environmentalSystem.getTempFeed().getTemperature(WardID);
        System.out.println(Temp);
        return Temp;
    }

    public String getInfo(){
        if(WardID==0){
            return "Ward Name:"+WardID+"Current Temperature"+String.valueOf(getTem())+"Ideal Temperatrue:23"+"heating:"+heating.getStatus();
        }
        else if(WardID==1){
            return "Ward Name:"+WardID+"Current Temperature"+String.valueOf(getTem())+"Ideal Temperatrue:22"+"heating:"+heating.getStatus();
        }
        else if(WardID==2){
            return "Ward Name:"+WardID+"Current Temperature"+String.valueOf(getTem())+"Ideal Temperatrue:20"+"heating:"+heating.getStatus();
        };
        return null;
    }



}
