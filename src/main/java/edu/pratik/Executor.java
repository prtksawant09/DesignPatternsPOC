package edu.pratik;

import edu.pratik.singleton.SingletonClass;
import edu.pratik.strategy.*;

public class Executor {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Executor executor = new Executor();
        executor.singletonDemo();
        executor.strategyDemo();

    }

    private void strategyDemo() {
        System.out.println("Creating SportVehicle");
        Vehicle vehicle = new SportVehicle();
        vehicle.driveCapability();

        System.out.println("Creating PassengerVehicle");
        vehicle = new PassengerVehicle();
        vehicle.driveCapability();

        System.out.println("Creating HeavyVehicle");
        vehicle = new HeavyVehicle();
        vehicle.driveCapability();

        System.out.println("Creating OffroadVehicle");
        vehicle = new OffroadVehicle();
        vehicle.driveCapability();
    }

    private void singletonDemo() {
        SingletonClass singletonClass = SingletonClass.getInstance();
        singletonClass.task();
    }
}