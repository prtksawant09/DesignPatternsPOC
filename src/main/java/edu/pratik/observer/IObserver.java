package edu.pratik.observer;

public interface IObserver {
    void update(String data);
    void subscribe(IObservable observable);
    void unsubscribe(IObservable observable);
}
