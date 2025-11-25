package org.example;

import Feeds.EnvironmentalSystem;

public class PollutionSen extends Sensor{

    private float Pollution;
    private airpurifier airpurifier;

    public PollutionSen(EnvironmentalSystem environmentalSystem,airpurifier airpurifier){
        super(environmentalSystem);
        this.airpurifier = airpurifier;
    }

    public float getPollution(){
        this.Pollution = environmentalSystem.getPollutionFeed().getPollution();
        return Pollution;
    };

    public String getInfo(){
        return "Pollution Level"+String.valueOf(getPollution())+"airpurifier:"+airpurifier.getStatus();
    }


}
