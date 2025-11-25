package org.example;

public abstract class Control{
    private boolean status;

    public Control(Boolean status){
        this.status = status;
    }

    public boolean getStatus(){
        return status;
    }

}
