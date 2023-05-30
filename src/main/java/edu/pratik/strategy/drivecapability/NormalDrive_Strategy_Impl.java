package edu.pratik.strategy.drivecapability;

public class NormalDrive_Strategy_Impl implements IDriveStrategy {
    @Override
    public void drive() {
        System.out.println("This is normal drive.");
    }
}
