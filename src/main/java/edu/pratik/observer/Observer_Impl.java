package edu.pratik.observer;

public class Observer_Impl implements IObserver {
    String observerName;
    public Observer_Impl(String observerName) {
        this.observerName=observerName;
    }
    @Override
    public void update(String data) {
        System.out.println("updated data is: "+data+" Received to Observer: "+observerName);
    }

    @Override
    public void subscribe(IObservable observable) {
        observable.subscribe(this);
    }

    @Override
    public void unsubscribe(IObservable observable) {
        observable.unsubscribe(this);
    }
}
