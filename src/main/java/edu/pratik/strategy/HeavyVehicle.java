package edu.pratik.strategy;

import edu.pratik.strategy.drivecapability.HeavyDrive_Strategy_Impl;

public class HeavyVehicle extends Vehicle {

    public HeavyVehicle() {
        super(new HeavyDrive_Strategy_Impl());
    }
}
