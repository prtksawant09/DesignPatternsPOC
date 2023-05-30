package edu.pratik.strategy;

import edu.pratik.strategy.drivecapability.HeavyDrive_Strategy_Impl;

public class OffroadVehicle extends Vehicle {
    public OffroadVehicle() {
        super(new HeavyDrive_Strategy_Impl());
    }
}
