package org.example;

import Feeds.EnvironmentalSystem;
import Systems.AirPurifier;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.Timer;

public class Main {
    ArrayList<Sensor> sensors = new ArrayList<>();
    ArrayList<Control> controls = new ArrayList<>();
    EnvironmentalSystem environmentalSystem;

    public Main() {
        environmentalSystem = new EnvironmentalSystem();
        airpurifier airpurifier1 = new airpurifier(environmentalSystem.isAirPurifierOn());
        dehumidifier dehumidifier1 = new dehumidifier(environmentalSystem.isDehumudifierOn());

        heating heating0 = new heating(environmentalSystem.isHeatingOn(0),0);
        heating heating1 = new heating(environmentalSystem.isHeatingOn(1),1);
        heating heating2 = new heating(environmentalSystem.isHeatingOn(2),2);

        TemSen temsensor0 = new TemSen(environmentalSystem,0,heating0);
        TemSen temsensor1 = new TemSen(environmentalSystem,1,heating1);
        TemSen temsensor2 = new TemSen(environmentalSystem,2,heating2);
        PollutionSen pollutionSenor = new PollutionSen(environmentalSystem,airpurifier1);
        HumSen humSensor = new HumSen(environmentalSystem,dehumidifier1);



        sensors.add(humSensor);
        sensors.add(temsensor0);
        sensors.add(temsensor1);
        sensors.add(temsensor2);
        sensors.add(pollutionSenor);

        controls.add(airpurifier1);
        controls.add(heating0);
        controls.add(heating1);
        controls.add(heating2);


        JFrame jFrame = new JFrame("environmental system");
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));


        for (Sensor s : sensors) {
            JPanel row = new JPanel();

            JLabel infoLabel = new JLabel("My Initial Text");
            infoLabel.setText("<html>"+s.getInfo()+"<html>");
            row.add(infoLabel);
            mainPanel.add(row);
        }

        jFrame.add(mainPanel);
        jFrame.pack();
        jFrame.setVisible(true);

        // 原来的定时器逻辑不变
        new Timer(1000, e -> tick(mainPanel,jFrame)).start();


    }

    private void tick(JPanel panel,JFrame jFrame) {
        panel.removeAll();

        for (Sensor s : sensors) {
            JPanel row = new JPanel();
            JLabel infoLabel = new JLabel("My Initial Text");
            infoLabel.setText("<html>"+s.getInfo()+"<html>");
            row.add(infoLabel);
            System.out.println(s.isnormal());
            if(!s.isnormal()){
                row.setBackground(Color.RED);
            }
            panel.add(row);
        }

        jFrame.add(panel);
        jFrame.pack();
        jFrame.setVisible(true);

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
