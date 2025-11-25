package org.example;

import Feeds.EnvironmentalSystem;

public class HumSen extends Sensor{
    private int InsHum;
    private int OutHum;
    private dehumidifier dehumidifier;

    public HumSen(EnvironmentalSystem environmentalSystem,dehumidifier dehumidifier){
        super(environmentalSystem);
        this.dehumidifier = dehumidifier;
    }

    public int getInsHum(){
        this.InsHum = environmentalSystem.getHumidityFeed().getInsideHumidity();
        return InsHum;
    };

    public int getOutHum(){
        this.OutHum = environmentalSystem.getHumidityFeed().getOutsideHumidity();
        return OutHum;
    };


    @Override
    public String getInfo(){
        return "Inside Humidity:"+String.valueOf(getInsHum())+"Outside Humidity:"+ String.valueOf(getOutHum())+"diff:"+String.valueOf(getInsHum()-getOutHum())+"dehumidifier:"+dehumidifier.getStatus();
    }

    @Override
    public boolean isnormal(){
        if(getInsHum()>1.1*getOutHum()){
            return false;
        }
        return true;
    }


}
