package edu.pratik.strategy;

import edu.pratik.strategy.drivecapability.NormalDrive_Strategy_Impl;

public class PassengerVehicle extends Vehicle {

    public PassengerVehicle() {
        super(new NormalDrive_Strategy_Impl());
    }
}
