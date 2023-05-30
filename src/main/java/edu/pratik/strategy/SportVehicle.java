package edu.pratik.strategy;

import edu.pratik.strategy.drivecapability.SportDrive_Strategy_Impl;

public class SportVehicle extends Vehicle {
    public SportVehicle() {
        super(new SportDrive_Strategy_Impl());
    }
}
