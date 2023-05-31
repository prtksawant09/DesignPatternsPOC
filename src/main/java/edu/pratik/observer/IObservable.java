package edu.pratik.observer;

import java.util.*;

public interface IObservable {
    List<IObserver> observers = new ArrayList<>();
    void subscribe(IObserver observer);
    void unsubscribe(IObserver observer);
    void notifySubscriber();
    void setData(String data);
    String getData();
}
