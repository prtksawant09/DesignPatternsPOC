package edu.pratik.strategy;

import edu.pratik.strategy.drivecapability.IDriveStrategy;

public class Vehicle {
    IDriveStrategy iDriveStrategy;

    public Vehicle(IDriveStrategy iDriveStrategy) {
        this.iDriveStrategy = iDriveStrategy;
    }

    public void driveCapability() {
        iDriveStrategy.drive();
    }
}
