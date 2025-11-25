package org.example;


import Feeds.EnvironmentalSystem;

public abstract class Sensor {
    public EnvironmentalSystem environmentalSystem;

    public Sensor(EnvironmentalSystem environmentalSystem){
        this.environmentalSystem = environmentalSystem;
    }

    public abstract String getInfo();

    public abstract boolean isnormal();

}
