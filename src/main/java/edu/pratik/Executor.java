package edu.pratik;

import edu.pratik.observer.IObservable;
import edu.pratik.observer.IObserver;
import edu.pratik.observer.Observable_Impl;
import edu.pratik.observer.Observer_Impl;
import edu.pratik.singleton.SingletonClass;
import edu.pratik.strategy.*;

public class Executor {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Executor executor = new Executor();
        executor.singletonDemo();
        executor.strategyDemo();
        executor.observerDemo();

    }

    private void observerDemo() {
        IObservable observable = new Observable_Impl();
        IObserver observer1 = new Observer_Impl("Observer 1");
        IObserver observer2 = new Observer_Impl("Observer 2");
        IObserver observer3 = new Observer_Impl("Observer 3");
        IObserver observer4 = new Observer_Impl("Observer 4");
        IObserver observer5 = new Observer_Impl("Observer 5");
        IObserver observer6 = new Observer_Impl("Observer 6");

        observer1.subscribe(observable);
        observer3.subscribe(observable);
        observer5.subscribe(observable);
        observer6.subscribe(observable);

        observer5.unsubscribe(observable);

        observable.setData("First Update");

        observer2.subscribe(observable);
        observer4.subscribe(observable);

        observer3.unsubscribe(observable);
        observer5.unsubscribe(observable);
        observer6.unsubscribe(observable);

        observable.setData("Second Update");
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