package edu.pratik.strategy.drivecapability;

public class HeavyDrive_Strategy_Impl implements IDriveStrategy {
    @Override
    public void drive() {
        System.out.println("This is heavy drive.");
    }
}
