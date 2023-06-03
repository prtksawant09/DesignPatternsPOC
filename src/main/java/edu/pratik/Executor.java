package edu.pratik;

import edu.pratik.decorator.BasePizza;
import edu.pratik.decorator.pizza.ChickenDelight;
import edu.pratik.decorator.pizza.Margherita;
import edu.pratik.decorator.pizza.VegDelight;
import edu.pratik.decorator.toppings.Cheese;
import edu.pratik.decorator.toppings.ChickenPepperoni;
import edu.pratik.decorator.toppings.ChickenSausage;
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
        executor.decoratorDemo();
    }

    private void decoratorDemo() {
        BasePizza pizza = new ChickenDelight();
        System.out.println("ChickenDelight pizza.getCost(): "+pizza.getCost());
        pizza = new Cheese(pizza);
        System.out.println("ChickenDelight with extra cheese pizza.getCost(): "+pizza.getCost());
        pizza = new ChickenPepperoni(new ChickenSausage(pizza));
        System.out.println("ChickenDelight with extra ChickenPepperoni ChickenSausage Cheese pizza.getCost(): "+pizza.getCost());

        pizza = new Margherita();
        System.out.println("Margherita pizza.getCost(): "+pizza.getCost());
        pizza = new Cheese(pizza);
        System.out.println("Margherita with extra Cheese pizza.getCost(): "+pizza.getCost());
        pizza = new Cheese(pizza);
        System.out.println("Margherita with extra double Cheese pizza.getCost(): "+pizza.getCost());

        pizza = new VegDelight();
        System.out.println("VegDelight pizza.getCost(): "+pizza.getCost());
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