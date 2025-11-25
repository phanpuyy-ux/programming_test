package org.example;

import Feeds.EnvironmentalSystem;

import java.text.DecimalFormat;

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
        return Temp;
    }

    public String getInfo(){
        double num = getTem();
        DecimalFormat df = new DecimalFormat("#.0"); // "#.0"表示保留一位小数
        String result = df.format(num);

        if(WardID==0){
            return "Ward Name:"+WardID+"Current Temperature"+String.valueOf(result)+"Ideal Temperatrue:23"+"heating:"+heating.getStatus();
        }
        else if(WardID==1){
            return "Ward Name:"+WardID+"Current Temperature"+String.valueOf(result)+"Ideal Temperatrue:22"+"heating:"+heating.getStatus();
        }
        else if(WardID==2){
            return "Ward Name:"+WardID+"Current Temperature"+String.valueOf(result)+"Ideal Temperatrue:20"+"heating:"+heating.getStatus();
        };
        return null;
    }

    public boolean isnormal(){
        if(WardID==0&& (getTem()>23.5 || getTem()<22.5)){
            return false;
        }
        if(WardID==1&& (getTem()>21.5 || getTem()<22.5)){
            return false;
        }
        if(WardID==2&& (getTem()>19.5 || getTem()<20.5)){
            return false;
        }
        return true;
    }





}
